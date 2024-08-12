package com.example.flirting.Service;

import com.example.flirting.DTO.ExerciseDTO;
import com.example.flirting.DTO.UserDTO;
import com.example.flirting.Domain.Exercise;
import com.example.flirting.Domain.User;
import com.example.flirting.Repository.ExerciseRepository;
import com.example.flirting.Repository.UserRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;
    private final JavaMailSender javaMailSender;
    private static final String senderEmail= "seongjaekim3@gmail.com";
    private static int number;  // 랜덤 인증 코드

    public boolean isUserIdUsed(UserDTO userDTO) {
        return userRepository.findByUserId(userDTO.getUserId()).isPresent();
    }

    // 회원가입 정보 DB에 저장
    public User saveUser(UserDTO userDTO) {
        User user = userDTO.toEntity();
        return userRepository.save(user);
    }

    public Long logIn(UserDTO userDTO) {
        Optional<User> user = userRepository.findByUserId(userDTO.getUserId());
        if(user.isPresent()) {
            if(user.get().getPassword().equals(userDTO.getPassword())) {
                log.info("@@UserService@@ ID값 전송");
                return user.get().getId();
            }
            else {
                log.info("@@UserService@@ 로그인 실패 => 비밀번호 다름");
                return null;
            }
        }
        else {
            log.info("@@UserService@@ 로그인 실패 => 아이디 다름");
            return null;
        }
    }

    // 랜덤 인증 코드 생성
    public static void createNumber() {
        number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    // 메일 양식 작성
    public MimeMessage createMail(String mail){
        createNumber();  // 인증 코드 생성
        log.info("@@UserService@@ 인증 코드 생성 " + String.valueOf(number));
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);   // 보내는 이메일
            message.setRecipients(MimeMessage.RecipientType.TO, mail); // 보낼 이메일 설정
            message.setSubject("회원가입을 위한 이메일 인증");  // 제목 설정
            String body = "";
            body += "<h1>" + "안녕하세요." + "</h1>";
            body += "<h1>" + "플러팅 입니다." + "</h1>";
            body += "<h3>" + "회원가입을 위한 요청하신 인증 번호입니다." + "</h3><br>";
            body += "<h2>" + "아래 코드를 회원가입 창으로 돌아가 입력해주세요." + "</h2>";

            body += "<div align='center' style='border:1px solid black; font-family:verdana;'>";
            body += "<h2>" + "회원가입 인증 코드입니다." + "</h2>";
            body += "<h1 style='color:blue'>" + number + "</h1>";
            body += "</div><br>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (Exception e) {
            log.info("@@UserService@@ 이메일 보내기 오류");
            e.printStackTrace();
        }
        log.info("@@UserService@@ 이메일 양식 작성 완료");
        return message;
    }

    // 실제 메일 전송
    public int sendEmail(String email) {
        // 메일 전송에 필요한 정보 설정
        log.info("@@UserService@@ 이메일 보내기 시작");
        MimeMessage message = createMail(email);
        // 실제 메일 전송
        javaMailSender.send(message);
        log.info("@@UserService@@ 이메일 보내기 완료");

        // 인증 코드 반환
        return number;
    }

    // 코드 입력값과 메일로 전송된 코드가 같은지 확인
    public boolean isCodeCorrect(String code) {

        if (number == Integer.parseInt(code)) {
            return true;
        } else {
            return false;
        }
    }

    public User saveHealthRoutine(UserDTO userDTO) {
        Optional<User> user = userRepository.findByUserId(userDTO.getUserId());
        log.info("@@UserService@@ " + user.toString());
        if(user.isPresent()) {
            log.info("@@UserService@@ ID 있으므로 운동루틴 저장 시작");
            User user1 = user.get();

            // userDTO 안에 있는 ExerciseRoutine을 user1 객체에 넣고 ExerciseRoutine 내에 user 필드에 user1 매핑
            log.info("@@UserService@@ userDTO.getExerciseRoutine() => " + userDTO.getExerciseRoutine());

            for(Exercise exercise : userDTO.getExerciseRoutine()) {
                Exercise exercise1 = new Exercise();
                exercise1.setUser(user1);
                exercise1.setExerciseName(exercise.getExerciseName());
                exercise1.setExerciseCount(exercise.getExerciseCount());
                user1.getExerciseRoutine().add(exercise1);
            }

            return userRepository.save(user1);
        } else {
            log.info("@@UserService@@ 해당 ID 없으므로 운동루틴 저장 실패");
            return null;
        }
    }
    // 홈 화면을 위한 유저 정보 주기 => 닉네임과 해당 닉네임과 매핑되는 운동루틴정보
    public Map<String, List<Exercise>> showHome(String userId) {
        Optional<User> userOptional = userRepository.findByUserId(userId);

        if(userOptional.isPresent()) {
            log.info("@@UserService@@ userId에 해당하는 User 객체 Found");
            Map<String, List<Exercise>> map = new HashMap<>();
            User user = userOptional.get();
            log.info("@@UserService@@ user의 id는 " + user.getId());
            Optional<List<Exercise>> exerciseList = exerciseRepository.findByUserId(user.getId());
            if(exerciseList.isPresent()) {
                log.info("@@UserService@@ user의 id에 해당하는 Exercise 리스트 Found");
                map.put(user.getNickname(), exerciseList.get());
                return map;
            }
            else {
                log.info("@@UserService@@ user의 id에 해당하는 Exercise 리스트 Not Found");
                return null;
            }
        } else {
            log.info("@@UserService@@ userId에 해당하는 User 객체 Not Found");
            return null;
        }
    }


}
