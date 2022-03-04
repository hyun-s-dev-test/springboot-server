package com.dev.woo.springbootserver.controller.dto;

import com.dev.woo.springbootserver.domain.user.Role;
import com.dev.woo.springbootserver.domain.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@ApiModel(value = "UserLoginRequestDto", description = "유저로그인 요청 정보")
public class UserLoginRequestDto {

    @ApiModelProperty(notes = "아이디", value = "id", example = "0woodev", required = true)
    private String id;

    @ApiModelProperty(notes = "비밀번호", value = "password", example = "0woodev")
    private String password;

    @Builder
    public UserLoginRequestDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
