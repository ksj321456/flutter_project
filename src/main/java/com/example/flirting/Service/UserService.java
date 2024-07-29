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

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public boolean isUserIdUsed(UserDTO userDTO) {
        return userRepository.findByUsername(userDTO.getUserId()).isPresent();
    }

    public User saveUser(UserDTO userDTO) {
        User user = userDTO.toEntity();
        log.info(user.toString());
        log.info("@@UserService@@ UserRepository에 저장");
        return userRepository.save(user);
    }
}
