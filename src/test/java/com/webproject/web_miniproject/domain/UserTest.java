package com.webproject.web_miniproject.domain;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.webproject.web_miniproject.repository.UserRepository;
import com.webproject.web_miniproject.service.UserService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
    

@DataJpaTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 정보가 변경되는 지")
    public void 유저_정보_변경() {
        // given
        User user = new User();

        // when
        user.changeInfo("wi", "000-0000-00000");

        // then
        assertThat(user.getName()).isEqualTo("wi");
        assertThat(user.getPhone()).isEqualTo("000-0000-00000");
    }

    @Test
    @DisplayName("저장")
    @Transactional
    @Rollback(false)
    public void 저장() {

        User user = new User();
        user.changeInfo("wi", "000-000-0000");
        User savedUser = userRepository.save(user);

        assertThat(savedUser.getName()).isEqualTo(user.getName());

    }

    @Test
    @DisplayName("저장 후 조회 findById")
    public void 조회() {
        // given
        User user = new User();
        user.changeInfo("wi", "000-000-0000");
        User savedUser = userRepository.save(user);

        // when
        User findById = userRepository.findById(savedUser.getId()).get();

        // then
        assertThat(findById.getId()).isEqualTo(savedUser.getId());
    }

    @Test
    @DisplayName("저장_후_모두_조회 findAll")
    public void 저장_후_모두_조회() {
        // given
        User user1 = new User();
        user1.changeInfo("wi", "000-000-0000");
        User savedUser1 = userRepository.save(user1);

        User user2 = new User();
        user2.changeInfo("kim", "111-111-1111");
        User savedUser2 = userRepository.save(user2);

        // when
        List<User> findAll = userRepository.findAll();

        // then
        assertThat(findAll.size()).isEqualTo(2);
    }


    
    @Test
    @DisplayName("저장_후_삭제 delete")
    public void 저장_후_삭제() {
        // given
        User user1 = new User();
        user1.changeInfo("wi", "000-000-0000");
        User savedUser1 = userRepository.save(user1);

        User user2 = new User();
        user2.changeInfo("kim", "111-111-1111");
        User savedUser2 = userRepository.save(user2);

        // when
        userRepository.delete(savedUser2);

        List<User> findAll = userRepository.findAll();
        // then
        assertThat(findAll.size()).isEqualTo(1);
        assertThat(findAll.get(0).getId()).isEqualTo(savedUser1.getId());

    }

}   
    