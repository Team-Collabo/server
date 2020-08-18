package com.team.collabo.team.repository;

import com.team.collabo.team.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
