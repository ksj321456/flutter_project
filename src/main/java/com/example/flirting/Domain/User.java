package com.example.flirting.Domain;

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
}
