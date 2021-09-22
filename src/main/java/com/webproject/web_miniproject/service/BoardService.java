package com.webproject.web_miniproject.service;

import javax.transaction.Transactional;

import com.webproject.web_miniproject.domain.Board;
import com.webproject.web_miniproject.repository.BoardRepository;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
    
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Board save(Board board) {
        return boardRepository.save(board);
    }
    

}
