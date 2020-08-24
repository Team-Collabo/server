package com.team.collabo.team.repository;

import com.team.collabo.team.model.Member;
import com.team.collabo.team.model.Team;
import com.team.collabo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUserAndTeam(final User user, final Team team);
}
