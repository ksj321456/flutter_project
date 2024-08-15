package com.example.flirting.Controller;

import com.example.flirting.DTO.BoardDTO;
import com.example.flirting.DTO.UserDTO;
import com.example.flirting.Domain.Board;
import com.example.flirting.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {


    private final BoardService boardService;

    // 전체 게시글 보여주기
    @GetMapping
    public List<BoardDTO> showHome() {
        return boardService.getList();
    }

    // 게시글 작성, userId를 받아오는걸로 시작
    @PostMapping("/write")
    public ResponseEntity<String> writeBoard(UserDTO userDTO) {
        log.info("@@BoardController@@ 게시글 작성 시작");
        if (boardService.writeArticle(userDTO.getUserId(), userDTO.getContent())) {
           log.info("@@BoardController@@ 게시글 작성 성공");
           return new ResponseEntity<>("게시글 저장 성공", HttpStatus.OK);
        } else {
            log.info("@@BoardController@@ 게시글 저장 실패");
            return new ResponseEntity<>("게시글 저장 실패", HttpStatus.CONFLICT);
        }
    }
}
