package com.team.collabo.user.service;

import com.team.collabo.security.exception.BadRequestException;
import com.team.collabo.security.payload.SignUpRequest;
import com.team.collabo.user.model.AuthProvider;
import com.team.collabo.user.model.User;
import com.team.collabo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(final SignUpRequest payload) {
        if (userRepository.existsByEmail(payload.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        return userRepository.save(
                User.builder()
                        .name(payload.getName())
                        .email(payload.getEmail())
                        .password(passwordEncoder.encode(payload.getPassword()))
                        .provider(AuthProvider.LOCAL).build());
    }
}
