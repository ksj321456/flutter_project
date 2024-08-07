package com.example.flirting.Domain;

import com.example.flirting.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;      // 로그인 ID
    private String password;    // 비밀번호
    private String name;        // 이름
    private String nickname;    // 닉네임
    private String email;       // 이메일

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boardList;      // 작성한 글 리스트

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exerciseRoutine;    // 운동 루틴

    // 회원가입 시 인증번호
    private String code;

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .password(user.getPassword())
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .boardList(user.getBoardList())
                .exerciseRoutine(user.getExerciseRoutine())
                .code(user.getCode())
                .build();
    }
}
