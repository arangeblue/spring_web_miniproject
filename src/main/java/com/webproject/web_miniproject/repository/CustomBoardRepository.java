package com.webproject.web_miniproject.repository;

import com.webproject.web_miniproject.dto.BoardDto;

public interface CustomBoardRepository {
    
    BoardDto findById(Long id);

}
