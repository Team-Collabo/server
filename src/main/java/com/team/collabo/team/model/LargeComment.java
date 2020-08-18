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
public class LargeComment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "large_comment_id")
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public LargeComment(Long id, String content, Member member, Comment comment) {
        this.id = id;
        this.content = content;
        this.member = member;
        this.comment= comment;
    }
}
