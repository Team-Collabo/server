package com.team.collabo.team.model;

import com.team.collabo.shared.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@Entity
public class Team extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "team_id")
    private Long id;
    private String name;
    private String description;

    @Builder
    public Team(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
