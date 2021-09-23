package com.webproject.web_miniproject.controller;

import com.webproject.web_miniproject.dto.BoardDto;
import com.webproject.web_miniproject.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
 
    @Autowired
    private BoardService boardService;



    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/board/write.do")
    public String openBoardWrite(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("board", new BoardDto());
        } else {
            boardService.
        }
        
        
        return "board/write";
    }
}
