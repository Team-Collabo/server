package com.team.collabo.team.payload;

import com.team.collabo.team.model.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class TeamRegisterRequestDto {
    private String name;
    private String description;
    private String nickname;

    public TeamRegisterRequestDto(@NotBlank String name,
                                  @NotBlank String description,
                                  @NotBlank String nickname) {
        this.name = name;
        this.description = description;
        this.nickname = nickname;
    }

    public Team toTeamEntity() {
        return new Team(name, description);
    }

}
