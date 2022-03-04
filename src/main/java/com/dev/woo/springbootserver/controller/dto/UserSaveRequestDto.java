package com.dev.woo.springbootserver.controller.dto;

import com.dev.woo.springbootserver.domain.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@ApiModel(value = "UserSaveRequestDto", description = "유저 회원가입 정보")
public class UserSaveRequestDto {

    @ApiModelProperty(notes = "이름", value = "name", example ="남영우", required = true)
    private String name;

    @ApiModelProperty(notes = "아이디", value = "id", example = "0woodev", required = true)
    private String id;

    @ApiModelProperty(notes = "비밀번호", value = "password", example = "0woodev")
    private String password;

    @ApiModelProperty(notes = "성별", value = "gender", example = "남자는 M, 여자는 F")
    private char gender;

    @ApiModelProperty(notes = "소셜로그인 타입(일반로그인 : none)", value = "social type", example="none")
    private String socialType;

    @ApiModelProperty(notes = "토큰", value = "token", example = "qq0zvjq390qwfj")
    private String token;

    @Builder
    public UserSaveRequestDto(String name, String id, String password, char gender, String socialType, String token) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.socialType = socialType;
        this.token = token;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .id(id)
                .password(password)
                .gender(gender)
                .socialType(socialType)
                .token(token)
                .build();
    }
}
