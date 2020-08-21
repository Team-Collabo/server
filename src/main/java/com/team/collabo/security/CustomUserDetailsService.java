package com.team.collabo.security;

import com.team.collabo.security.exception.ResourceNotFoundException;
import com.team.collabo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return AuthUser.create(
                userRepository.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email))
        );

    }

    @Transactional
    public UserDetails loadUserById(final Long id) {
        return AuthUser.create(
                userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id))
        );
    }
}