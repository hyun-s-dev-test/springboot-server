package com.dev.woo.springbootserver.controller.dto;

import com.dev.woo.springbootserver.domain.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ApiModel(value = "UserResponseDto", description = "유저조회 정보")
public class UserResponseDto {
    @ApiModelProperty(value = "pk", notes = "pk", example = "1", required = false)
    private final Long pk;
    @ApiModelProperty(value = "name", notes = "이름", example = "남영우", required = false)
    private final String name;
    @ApiModelProperty(value = "id", notes = "아이디", example = "0woodev", required = false)
    private final String id;
    @ApiModelProperty(value = "gender", notes = "성별", example = "M", required = false)
    private final String gender;
    @ApiModelProperty(value = "birth", notes = "생일", example = "1997-07-28", required = false)
    private final LocalDate birth;
    @ApiModelProperty(value = "social type", notes = "소셜로그인 종류", example = "none", required = false)
    private final String socialType;
    @ApiModelProperty(value = "createdAt", notes = "회원가입시간", example = "YYYY-MM-DD-HH-mm-ss", required = false)
    private final LocalDateTime createdAt;

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
