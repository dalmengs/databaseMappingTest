package com.dalmeng.databaseMappingTest.Service;

import com.dalmeng.databaseMappingTest.Entity.Board;
import com.dalmeng.databaseMappingTest.Repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board createBoard(){
        Board board = new Board();
        return boardRepository.save(board);
    }

}
