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
public class DashBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "dashboard_id")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public DashBoard(Long id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }
}
