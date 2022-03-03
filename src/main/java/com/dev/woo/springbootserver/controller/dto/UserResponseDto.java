package com.dev.woo.springbootserver.controller.dto;

import com.dev.woo.springbootserver.domain.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserResponseDto {
    private Long pk;
    private String name;
    private String id;
    private char gender;
    private LocalDate birth;
    private String socialType;
    private LocalDateTime createdAt;

    public UserResponseDto(User user) {
        this.pk = user.getPk();
        this.name = user.getName();
        this.id = user.getId();
        this.gender = user.getGender();
        this.birth = user.getBirth();
        this.socialType = user.getSocialType();
        this.createdAt = user.getCreatedAt();
    }
}
