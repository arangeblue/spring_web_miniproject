package com.webproject.web_miniproject.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.webproject.web_miniproject.domain.common.BaseTimeEntity;
import com.webproject.web_miniproject.domain.common.YnEnum;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "boards")
public class Board extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "board_title", length = 100, nullable = false)
    private String title;
    
    @Column(name = "board_content", length = 500, nullable = false)
    private String content;

    @Column(name = "board_writer")
    private String writer;

    @Column(name = "view_cnt")
    private int viewCnt;

    @Enumerated(EnumType.STRING)
    @Column(name = "notice_yn")
    private YnEnum noticeYn;

    @Enumerated(EnumType.STRING)
    @Column(name = "secret_yn")
    private YnEnum secretYn;

    @Enumerated(EnumType.STRING)
    @Column(name = "delete_yn")
    private YnEnum deleteYn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Board(String title, String content, String writer, int viewCnt, YnEnum noticeYn, YnEnum secretYn,
            YnEnum deleteYn) {
       
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.viewCnt = viewCnt;
        this.noticeYn = noticeYn;
        this.secretYn = secretYn;
        this.deleteYn = deleteYn;
    }

   
    



    
    

    

}
