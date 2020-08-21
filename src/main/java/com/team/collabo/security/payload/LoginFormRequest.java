package com.team.collabo.security.payload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class LoginFormRequest {
    @NotBlank
    @Email
    private final String email;

    @NotBlank
    private final String password;
}
