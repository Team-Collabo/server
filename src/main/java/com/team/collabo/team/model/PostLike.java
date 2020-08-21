package com.team.collabo.team.model;

import com.team.collabo.shared.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@Entity
public class PostLike extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public PostLike(Long id, Member member, Post post) {
        this.id = id;
        this.member = member;
        this.post = post;
    }
}
