package com.team.collabo.team.repository;

import com.team.collabo.team.model.MemberPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<MemberPost, Long> {
}
