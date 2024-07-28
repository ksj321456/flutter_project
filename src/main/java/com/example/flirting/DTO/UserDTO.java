package com.example.flirting.DTO;

import com.example.flirting.Domain.Board;
import com.example.flirting.Domain.User;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    private String userId;
    private String password;
    private String name;
    private String height;
    private String weight;
    private String age;
    private String sex;
    private String nickname;
    private List<Board> boardList;
    private List<String> record;
    private List<String> date;
    private List<String> time;
    private List<String> distance;

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .password(user.getPassword())
                .name(user.getName())
                .height(user.getHeight())
                .weight(user.getWeight())
                .age(user.getAge())
                .sex(user.getSex())
                .nickname(user.getNickname())
                .boardList(user.getBoardList())
                .record(user.getRecord())
                .date(user.getDate())
                .time(user.getTime())
                .distance(user.getDistance())
                .build();
    }
}
