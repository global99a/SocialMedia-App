package com.application.socialmedia.service;

import com.application.socialmedia.model.Follow;
import com.application.socialmedia.model.User;
import com.application.socialmedia.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    private final FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public void followUser(Long followerId, Long followedId) {
        if (!followRepository.existsByFollowerIdAndFollowedId(followerId, followedId)) {
            Follow follow = new Follow();
            follow.setFollower(new User(followerId));
            follow.setFollowed(new User(followedId));
            followRepository.save(follow);
        }
    }

    public void unfollowUser(Long followerId, Long followedId) {
        followRepository.findByFollowerId(followerId).stream()
                .filter(follow -> follow.getFollowed().getId().equals(followedId))
                .findFirst()
                .ifPresent(follow -> followRepository.delete(follow));
    }

    public List<Follow> getFollowedUsers(Long followerId) {
        return followRepository.findByFollowerId(followerId);
    }

    public List<Follow> getFollowers(Long followedId) {
        return followRepository.findByFollowedId(followedId);
    }
}
