package com.team.collabo.team;

import com.team.collabo.team.payload.TeamRegisterRequestDto;
import com.team.collabo.team.payload.TeamResponseDto;

public interface TeamService {
    TeamResponseDto aboutTeam(final Long userId, final Long teamId);
    Long registerTeamAndFirstMember(final Long userId, final TeamRegisterRequestDto payload);
}
