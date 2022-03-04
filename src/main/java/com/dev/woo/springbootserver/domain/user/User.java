package com.dev.woo.springbootserver.domain.user;

import com.dev.woo.springbootserver.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String id;

    @Column
    private String password;

    @Column
    private String gender;

    @Column
    private LocalDate birth;

    @Column
    private String socialType;

    @Column
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Builder
    public User(String name, String id, String password, String gender, String socialType, LocalDate birth, String token, Role role) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.socialType = socialType;
        this.token = token;
        this.birth = birth;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
