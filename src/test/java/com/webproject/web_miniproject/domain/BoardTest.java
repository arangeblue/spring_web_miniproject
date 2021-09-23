package com.webproject.web_miniproject.domain;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.webproject.web_miniproject.domain.common.YnEnum;
import com.webproject.web_miniproject.repository.BoardRepository;
import com.webproject.web_miniproject.repository.UserRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;




    

@DataJpaTest
public class BoardTest {


    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("저장_후_게시글_조회_및_카운트")
    @Transactional
    @Rollback(false)
    public void 저장_후_게시글_조회_및_카운트() {
        // given

        User user1 = User.builder()

                .name("wi1").phone("010-9000-9203").build();

        User user2 = User.builder()

                .name("kim2").phone("010-3000-1133").build();

        Board board1 = Board.builder()

                .title("테스트 게시글1").content("테스트 글1").writer("wi1").viewCnt(0).noticeYn(YnEnum.Y).secretYn(YnEnum.Y)
                .deleteYn(YnEnum.N).build();

        Board board2 = Board.builder()

                .title("테스트 게시글2").content("테스트 글2").writer("kim2").viewCnt(0).noticeYn(YnEnum.Y).secretYn(YnEnum.Y)
                .deleteYn(YnEnum.N).build();

        userRepository.save(user1);
        userRepository.save(user2);

        boardRepository.save(board1);
        boardRepository.save(board2);

        // when
        // 저장된 게시글을 id로 조회
        Board findBoard = boardRepository.findById(board1.getId()).get();

        // then
        assertThat(findBoard.getId()).isEqualTo(board1.getId());
        assertThat(findBoard.getTitle()).isEqualTo("테스트 게시글1");
        assertThat(findBoard.getContent()).isEqualTo("테스트 글1");
        assertThat(findBoard.getWriter()).isEqualTo("wi1");

        // 저장된 게시글 모두 조회
        List<Board> findAllBoards = boardRepository.findAll();

        assertThat(findAllBoards.size()).isEqualTo(2);

        // 저장된 게시글 수 조회
        long boardCount = boardRepository.count();

        assertThat(boardCount).isEqualTo(2);
    }
    
    
}
    