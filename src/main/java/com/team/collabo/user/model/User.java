package com.team.collabo.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String email;

    private String picture;

    @Enumerated(STRING)
    @Column(nullable = false)
    private OAuthProvider oAuthProvider;

    @Enumerated(STRING)
    @Column(nullable = false)
    private UserRole role;

    @Builder
    public User(Long id, OAuthProvider oAuthProvider, UserRole role) {
        this.id = id;
        this.oAuthProvider = oAuthProvider;
        this.role = role;
    }
}
