package com.webproject.web_miniproject.service;



import java.util.List;

import com.webproject.web_miniproject.domain.Board;
import com.webproject.web_miniproject.dto.BoardDto;


public interface BoardService {
    

    // 저장
    public Board save(Board board);
    

    // 게시글 전체 조회
    public List<Board> findAll();

    // 삭제
    public void delete(Long id);

    // 수정
    public void update(Long id);
    
    // 게시글 상세 조회
    public BoardDto findById(Long id);
    

}
