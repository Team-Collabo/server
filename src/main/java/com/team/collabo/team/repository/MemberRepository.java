package com.team.collabo.team.repository;

import com.team.collabo.team.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
