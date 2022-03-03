package com.dev.woo.springbootserver.domain.user;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column
    private char gender;

    @Column
    private LocalDate birth;

    @Column
    private String socialType;

    @Column
    private String token;

    @Builder
    public User(String name, String id, String password, char gender, String socialType, String token) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.socialType = socialType;
        this.token = token;
    }
}
