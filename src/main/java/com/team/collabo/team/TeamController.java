package com.team.collabo.team;

import com.team.collabo.security.AuthUser;
import com.team.collabo.security.Authentication;
import com.team.collabo.team.payload.TeamRegisterRequestDto;
import com.team.collabo.team.payload.TeamResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TeamController {
    private final TeamService teamService;

    @GetMapping("api/team/{teamId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TeamResponseDto> aboutTeam(@PathVariable("teamId") final Long teamId,
                                                     @Authentication final AuthUser authUser) {
        return ResponseEntity.ok(teamService.aboutTeam(authUser.getId(), teamId));
    }

    @PostMapping("api/team/registration")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Long> registerTeamAndFirstMember(@Authentication final AuthUser authUser,
                                                           @RequestBody @Valid final TeamRegisterRequestDto payload) {
        return new ResponseEntity<>(teamService.registerTeamAndFirstMember(authUser.getId(), payload), HttpStatus.CREATED);
    }
}
