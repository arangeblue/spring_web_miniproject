package com.webproject.web_miniproject.service;

import java.util.List;
import java.util.Optional;

import com.webproject.web_miniproject.domain.Board;
import com.webproject.web_miniproject.dto.BoardDto;
import com.webproject.web_miniproject.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    @Transactional
    public Board save(Board board) {
    
        return boardRepository.save(board);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Board> findById = boardRepository.findById(id);
        findById.ifPresent(board -> {
            boardRepository.delete(board);
        });
        
    }

    @Override
    @Transactional
    public void update(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BoardDto> findById(Long id) {
        return boardRepository.findById(id);
    }


    

}
