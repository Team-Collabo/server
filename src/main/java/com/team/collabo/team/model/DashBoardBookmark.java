package com.team.collabo.team.model;

import com.team.collabo.shared.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Getter
@NoArgsConstructor
@Entity
public class DashBoardBookmark extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "dashboard_bookmark_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "dashboard_id")
    private DashBoard dashBoard;

    @Builder
    public DashBoardBookmark(Long id, Member member, DashBoard dashBoard) {
        this.id = id;
        this.member = member;
        this.dashBoard = dashBoard;
    }
}
