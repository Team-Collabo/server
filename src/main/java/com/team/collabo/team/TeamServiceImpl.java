package com.team.collabo.team;

import com.team.collabo.security.exception.ResourceNotFoundException;
import com.team.collabo.team.model.Member;
import com.team.collabo.team.model.Team;
import com.team.collabo.team.payload.TeamRegisterRequestDto;
import com.team.collabo.team.payload.TeamResponseDto;
import com.team.collabo.team.repository.MemberRepository;
import com.team.collabo.team.repository.TeamRepository;
import com.team.collabo.user.model.User;
import com.team.collabo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Transactional
    @Override
    public TeamResponseDto aboutTeam(final Long userId, final Long teamId) {
        final Team target = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team", "id", teamId));

        if (!memberRepository.existsByUserAndTeam(findUserById(userId), target))
            throw new RuntimeException("No Matching Team <-> Member");

        return TeamResponseDto.TeamResponseDtoMapper(target);
    }

    @Transactional
    @Override
    public Long registerTeamAndFirstMember(final Long userId,
                                           final TeamRegisterRequestDto payload) {
        final Team team = teamRepository.save(payload.toTeamEntity());

        return memberRepository.save(Member.builder()
                .nickname(payload.getNickname())
                .user(findUserById(userId))
                .team(team)
                .build())
                .addMemberToTeam(team)
                .getTeam().getId();
    }

    private User findUserById(final Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }
}
