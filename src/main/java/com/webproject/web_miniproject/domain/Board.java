package com.webproject.web_miniproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import groovy.transform.builder.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "boards")
public class Board {
    
    @Id
    @GeneratedValue
    @Column(name = "board_id", nullable = false)
    private Long id;

    @Column(name = "board_title", length = 100, nullable = false)
    private String title;
    
    @Column(name = "board_content", length = 500, nullable = false)
    private String content;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_name")
    private String writer;

    @Column(name = "view_cnt")
    private int viewCnt;

    @Column(name = "notice_yn")
    private String noticeYn;

    @Column(name = "secret_yn")
    private String secretYn;

    @Column(name = "delete_yn")
    private String deleteYn;

    protected Board() {
        
    }

    @Builder
    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }



    
    

    

}
