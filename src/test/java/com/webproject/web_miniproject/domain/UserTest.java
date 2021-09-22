package com.webproject.web_miniproject.domain;
import static org.assertj.core.api.Assertions.assertThat;

import com.webproject.web_miniproject.repository.UserRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
    @Transactional
    @Rollback(false)
    public void 저장() {
        
        User user = new User();
        user.changeInfo("wi", "000-000-0000");
        User savedUser = userRepository.save(user);

        assertThat(savedUser.getName()).isEqualTo(user.getName());
        
    }
}
    