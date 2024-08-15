package com.example.flirting.Domain;

import com.example.flirting.DTO.BoardDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;  // 작성자
    @Column(columnDefinition = "TEXT")
    private String content;     // 내용

    @CreationTimestamp
    private LocalDateTime createdAt;    // 생성 시간

    @Column(name = "`like`")
    private String like;    // 좋아요

    @Column(name = "`unlike`")
    private String unlike;      // 싫어요

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;      // User의 id와 매핑

    public static Board toEntity(BoardDTO boardDTO) {
        return Board.builder()
                .id(boardDTO.getId())
                .writer(boardDTO.getWriter())
                .content(boardDTO.getContent())
                .createdAt(boardDTO.getCreatedAt())
                .like(boardDTO.getLike())
                .unlike(boardDTO.getUnlike())
                .user(boardDTO.getUser())
                .build();
    }
}
