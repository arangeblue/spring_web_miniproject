package com.webproject.web_miniproject.repository;

import com.webproject.web_miniproject.dto.BoardDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class CustomBoardRepositoryImpl implements CustomBoardRepository {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    @Transactional
    public BoardDto findById(Long id) {
        boardRepository.findById(id);
        return null;
    }
    
}
