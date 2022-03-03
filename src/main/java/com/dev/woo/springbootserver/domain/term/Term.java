package com.dev.woo.springbootserver.domain.term;

import com.dev.woo.springbootserver.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Term extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Builder
    public Term(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
