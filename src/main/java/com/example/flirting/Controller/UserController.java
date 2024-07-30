package com.example.flirting.Controller;

import com.example.flirting.DTO.UserDTO;
import com.example.flirting.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(UserDTO userDTO) {
        log.info("@@UserController@@ 회원가입");
        if(userService.isUserIdUsed(userDTO)) {
            log.info("UserID 이미 사용중");
            return new ResponseEntity<>("UserID 이미 사용중", HttpStatus.CONFLICT);
        }
        else {
            userService.saveUser(userDTO);
            log.info("@@UserController@@ 회원가입 성공");
            return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
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
}
