package com.example.flirting.Service;

import com.example.flirting.DTO.UserDTO;
import com.example.flirting.Domain.User;
import com.example.flirting.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public boolean isUserIdUsed(UserDTO userDTO) {
        return userRepository.findByUserId(userDTO.getUserId()).isPresent();
    }

    public User saveUser(UserDTO userDTO) {
        User user = userDTO.toEntity();
        log.info(user.toString());
        log.info("@@UserService@@ UserRepository에 저장");
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
        else{
            log.info("@@UserService@@ 로그인 실패 => 아이디 다름");
            return null;
        }
    }
}
