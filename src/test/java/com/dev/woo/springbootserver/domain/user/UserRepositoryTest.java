package com.dev.woo.springbootserver.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        userRepository.deleteAllById("test");
    }

    @Test
    public void 유저저장후_불러오기() throws Exception {
        // given
        User user = new User("테스트", "test", "password",
                "M", "none", LocalDate.now(),"", Role.USER);
        // save
        userRepository.save(User.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .gender(user.getGender())
                .socialType(user.getSocialType())
                .token(user.getToken())
                .build());
            // findById 테스트
        User savedUser = userRepository.findById(user.getId());
        assertThat(savedUser.getName()).isEqualTo(user.getName());
        assertThat(savedUser.getId()).isEqualTo(user.getId());
    }
}