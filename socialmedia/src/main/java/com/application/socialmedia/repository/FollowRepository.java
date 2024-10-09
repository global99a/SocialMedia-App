package com.application.socialmedia.repository;

import com.application.socialmedia.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollowerId(Long followerId);
    List<Follow> findByFollowedId(Long followedId);
    boolean existsByFollowerIdAndFollowedId(Long followerId, Long followedId);
}
