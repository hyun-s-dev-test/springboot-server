package com.dev.woo.springbootserver.domain.term;

import com.dev.woo.springbootserver.domain.user.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TermRepositoryTest {

    @Autowired
    TermRepository termRepository;

    @After
    public void cleanup() {
        termRepository.deleteAll();
    }

    @Test
    public void 약관저장후_불러오기() throws Exception {
        Term term = new Term("Google 서비스 약관",
                "본 약관에서 다루는 내용\n" +
                "본 서비스 약관을 확인하는 것이 번거로울 수 있다는 점은 이해하지만, 귀하가 Google 서비스를 사용하면서 Google에 기대할 수 있는 부분과 Google이 귀하에게 기대하는 부분을 명확히 해 두는 것은 중요합니다.",
                "남영우");

        termRepository.save(Term.builder()
                .title(term.getTitle())
                .content(term.getContent())
                .writer(term.getWriter())
                .build());

        Term savedTerm = termRepository.findAll().get(0);
        assertThat(savedTerm.getTitle()).isEqualTo(term.getTitle());
        assertThat(savedTerm.getWriter()).isEqualTo(term.getWriter());
    }
}