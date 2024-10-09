package com.application.socialmedia.controller;
import com.application.socialmedia.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like")
    public void likeArticle(@RequestParam Long userId, @RequestParam Long articleId) {
        likeService.likeArticle(userId, articleId);
    }

    @DeleteMapping("/unlike")
    public void unlikeArticle(@RequestParam Long userId, @RequestParam Long articleId) {
        likeService.unlikeArticle(userId, articleId);
    }
}
