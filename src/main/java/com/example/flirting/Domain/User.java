package com.example.flirting.Domain;

import com.example.flirting.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;
    private String name;
    private String height;
    private String weight;
    private String age;
    private String sex;
    private String nickname;
    @OneToMany(mappedBy = "user")
    private List<Board> boardList;
    private List<String> record;
    private List<String> date;
    private List<String> time;
    private List<String> distance;
    // 체중감소
    private boolean loseWeight;
    // 근육증가
    private boolean increaseMuscle;
    private String BMI;

    public static User toEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .userId(userDTO.getUserId())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .height(userDTO.getHeight())
                .weight(userDTO.getWeight())
                .age(userDTO.getAge())
                .sex(userDTO.getSex())
                .nickname(userDTO.getNickname())
                .boardList(userDTO.getBoardList())
                .record(userDTO.getRecord())
                .date(userDTO.getDate())
                .time(userDTO.getTime())
                .distance(userDTO.getDistance())
                .loseWeight(userDTO.isLoseWeight())
                .increaseMuscle(userDTO.isIncreaseMuscle())
                .BMI(userDTO.getBMI())
                .build();
    }

    public static UserDTO toDTO(UserDTO userDTO) {
        return UserDTO.builder()
                .id(userDTO.getId())
                .userId(userDTO.getUserId())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .height(userDTO.getHeight())
                .weight(userDTO.getWeight())
                .age(userDTO.getAge())
                .sex(userDTO.getSex())
                .nickname(userDTO.getNickname())
                .boardList(userDTO.getBoardList())
                .record(userDTO.getRecord())
                .date(userDTO.getDate())
                .time(userDTO.getTime())
                .distance(userDTO.getDistance())
                .loseWeight(userDTO.isLoseWeight())
                .increaseMuscle(userDTO.isIncreaseMuscle())
                .BMI(userDTO.getBMI())
                .build();
    }
}
