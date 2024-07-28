package com.example.flirting.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createdAt;
    @Column(name = "`like`")
    private String like;
    @Column(name = "`unlike`")
    private String unlike;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
