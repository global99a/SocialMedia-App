package com.application.socialmedia.controller;

import com.application.socialmedia.model.Follow;
import com.application.socialmedia.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
public class FollowController {
    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/follow")
    public ResponseEntity<String> followUser(@RequestParam Long followerId, @RequestParam Long followedId) {
        followService.followUser(followerId, followedId);
        return ResponseEntity.ok("Followed user successfully.");
    }

    @DeleteMapping("/unfollow")
    public ResponseEntity<String> unfollowUser(@RequestParam Long followerId, @RequestParam Long followedId) {
        followService.unfollowUser(followerId, followedId);
        return ResponseEntity.ok("Unfollowed user successfully.");
    }

    @GetMapping("/followed/{followerId}")
    public ResponseEntity<List<Follow>> getFollowedUsers(@PathVariable Long followerId) {
        return ResponseEntity.ok(followService.getFollowedUsers(followerId));
    }

    @GetMapping("/followers/{followedId}")
    public ResponseEntity<List<Follow>> getFollowers(@PathVariable Long followedId) {
        return (ResponseEntity<List<Follow>>) ResponseEntity.ok();
    }
}
