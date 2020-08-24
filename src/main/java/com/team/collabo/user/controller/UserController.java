package com.team.collabo.user.controller;

import com.team.collabo.security.Authentication;
import com.team.collabo.security.AuthUser;
import com.team.collabo.security.exception.ResourceNotFoundException;
import com.team.collabo.user.model.User;
import com.team.collabo.user.repository.UserRepository;
import com.team.collabo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@Authentication final AuthUser authUser) {
        return userRepository.findById(authUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", authUser.getId()));
    }
}
