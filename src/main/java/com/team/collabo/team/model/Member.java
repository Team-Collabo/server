package com.team.collabo.team.model;

import com.team.collabo.shared.entity.BaseTimeEntity;
import com.team.collabo.user.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public Member(Long id, String nickname, User user, Team team) {
        this.id = id;
        this.nickname = nickname;
        this.user = user;
        this.team = team;
    }
}
