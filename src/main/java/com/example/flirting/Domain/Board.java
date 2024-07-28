package com.example.flirting.Domain;

import com.example.flirting.DTO.BoardDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
