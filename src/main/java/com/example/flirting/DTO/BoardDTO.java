package com.example.flirting.DTO;

import com.example.flirting.Domain.Board;
import com.example.flirting.Domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

    private Long id;

    private String writer;

    private String content;
    private LocalDateTime createdAt;

    private String like;

    private String unlike;

    private User user;

    public static BoardDTO toDTO(Board board) {
        return BoardDTO.builder()
                .id(board.getId())
                .writer(board.getWriter())
                .content(board.getContent())
                .createdAt(board.getCreatedAt())
                .like(board.getLike())
                .unlike(board.getUnlike())
                .user(board.getUser())
                .build();
    }
}
