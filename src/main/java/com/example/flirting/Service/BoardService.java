package com.example.flirting.Service;

import com.example.flirting.DTO.BoardDTO;
import com.example.flirting.Domain.Board;
import com.example.flirting.Domain.User;
import com.example.flirting.Repository.BoardRepository;
import com.example.flirting.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    // 전체 게시글 리스트 DTO 형식으로 변환해 Controller에 전달
    public List<BoardDTO> getList() {
        List<Board> list = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for(Board board : list) {
            BoardDTO boardDTO = BoardDTO.toDTO(board);
            boardDTOList.add(boardDTO);
        }
        Collections.reverse(boardDTOList);
        return boardDTOList;
    }

    // 게시글 작성 서비스
    public boolean writeArticle(String userId, String content) {
        Optional<User> userOptional = userRepository.findByUserId(userId);

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            Board board = new Board();
            board.setContent(content);
            board.setLike("0");
            board.setUnlike("0");
            board.setUser(user);
            board.setWriter(user.getNickname());
            boardRepository.save(board);
            log.info("@@BoardService@@ 게시글 저장 완료");
            return true;
        }
        else {
            log.info("@@BoardService@@ 게시글 저장 실패 => 해당 userId 존재하지 않음");
            return false;
        }
    }
}
