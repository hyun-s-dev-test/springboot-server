package com.dev.woo.springbootserver.service;

import com.dev.woo.springbootserver.controller.dto.UserResponseDto;
import com.dev.woo.springbootserver.domain.user.User;
import com.dev.woo.springbootserver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

}
