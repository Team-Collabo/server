package com.team.collabo.team.model;

import com.team.collabo.shared.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Builder
    public Team(Long id, String name, String description, List<Member> members) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.members = members;
    }
}
