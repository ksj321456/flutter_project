package com.example.flirting.Controller;

import com.example.flirting.DTO.UserDTO;
import com.example.flirting.Domain.Exercise;
import com.example.flirting.Domain.User;
import com.example.flirting.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Data
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public UserDTO signUp(UserDTO userDTO) {
        log.info("@@UserController@@ 회원가입");
        if(userService.isUserIdUsed(userDTO)) {
            log.info("UserID 이미 사용중");
            return null;
        }
        else {
            int num = userService.sendEmail(userDTO.getEmail());
            log.info("@@UserController@@ 이메일 전송 성공");
            log.info("@@UserController@@ " + userDTO.getEmail());
            return userDTO;
        }
    }

    @PostMapping("/signup/code")
    public ResponseEntity<String> checkCode(UserDTO userDTO) {
        if (userService.isCodeCorrect(userDTO.getCode())) {
            log.info("@@UserController@@ 인증코드 일치");
            userService.saveUser(userDTO);
            return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("코드 값 다름", HttpStatus.CONFLICT);
        }
    }

    // ID를 문자열로 변환해 프론트단으로 전송
    @PostMapping("/login")
    public ResponseEntity<String> logIn(UserDTO userDTO) {
        log.info("@@UserController@@ 로그인");
        Long id = userService.logIn(userDTO);
        if (id != null) {
            log.info("@@UserController@@ 로그인 성공");
           return new ResponseEntity<>(String.valueOf(id), HttpStatus.OK);
        }
        else {
            log.info("@@UserController@@ 로그인 실패");
            return new ResponseEntity<>("로그인 실패", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/health_routine")
    public ResponseEntity<String> healthRoutine(@RequestBody UserDTO userDTO) {
        log.info("@@UserController userId는 " + userDTO.getUserId());
        log.info("@@UserController ExerciseRoutine은 " + userDTO.getExerciseRoutine());
        log.info("@@UserController@@ 운동기록 시작");
        User user = userService.saveHealthRoutine(userDTO);
        if(user != null) {
            log.info("@@UserController@@ 운동루틴 저장 완료");
            return new ResponseEntity<>("운동루틴 저장 완료", HttpStatus.OK);
        } else {
            log.info("@@UserController@@ 운동루틴 저장 실패");
            return  new ResponseEntity<>("운동루틴 저장 실패", HttpStatus.CONFLICT);
        }
    }

    // 홈 화면에 데이터 주기 => 이름, 운동루틴 정보
    @GetMapping("/home/{id}")
    public Map<String, List<Exercise>> home(@PathVariable("id") String userId) {
        log.info("@@UserController@@ 홈 화면 userId는 " + userId);
        Map<String, List<Exercise>> map = userService.showHome(userId);
        if(map != null) {
            return map;
        } else {
            log.info("@@UserController@@ map은 null값");
            return null;
        }
    }
}
