package com.dev.woo.springbootserver.controller;


import com.dev.woo.springbootserver.controller.dto.UserResponseDto;
import com.dev.woo.springbootserver.controller.dto.UserSaveRequestDto;
import com.dev.woo.springbootserver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "User Controller", tags = "User")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "모든 유저 조회", notes = "모든 유저의 정보를 가져옵니다.(비밀번호, 토큰 제외)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 404, message = "NOT FOUND!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUserInfo() {
        return new ResponseEntity<List<UserResponseDto>>(userService.findAllUser(), HttpStatus.OK);
    }

    @Operation(summary = "아이디로 유저 조회", description = "입력한 아이디와 동일한 유저의 정보를 가져옵니다.(비밀번호, 토큰 제외)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 404, message = "NOT FOUND!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserInfoById(@PathVariable String id) {
        UserResponseDto userResponseDto = null;

        try {
             userResponseDto = userService.findUserById(id);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>((UserResponseDto)null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>((UserResponseDto)null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @Operation(summary = "유저 추가", description = "입력한 데이터로 새로운 유저를 생성합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 404, message = "NOT FOUND!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @PostMapping()
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }
}
