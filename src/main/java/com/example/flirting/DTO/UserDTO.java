package com.example.flirting.DTO;

import com.example.flirting.Domain.Board;
import com.example.flirting.Domain.Exercise;
import com.example.flirting.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String userId;      // 로그인 ID
    private String password;    // 비밀번호
    private String name;        // 이름
    private String nickname;    // 닉네임
    private String email;

    private List<Board> boardList;      // 작성한 글 리스트
    private List<Exercise> exerciseRoutine;    // 운동 루틴

    // 회원가입 시 인증코드
    private String code;

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setUserId(this.userId);
        user.setPassword(this.password);
        user.setName(this.name);
        user.setNickname(this.nickname);
        user.setEmail(this.email);
        user.setBoardList(this.boardList);
        user.setExerciseRoutine(this.exerciseRoutine);
        user.setCode(this.code);
        return user;
    }
}
