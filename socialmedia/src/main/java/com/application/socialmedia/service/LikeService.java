package com.application.socialmedia.service;

import com.application.socialmedia.model.Article;
import com.application.socialmedia.model.Like;
import com.application.socialmedia.model.User;
import com.application.socialmedia.repository.ArticleRepository;
import com.application.socialmedia.repository.LikeRepository;
import com.application.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository, ArticleRepository articleRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public void likeArticle(Long userId, Long articleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("Article not found"));

        if (!likeRepository.existsByUserAndArticle(user, article)) {
            Like like = new Like();
            like.setUser(user);
            like.setArticle(article);
            likeRepository.save(like);
        }
    }

    public void unlikeArticle(Long userId, Long articleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("Article not found"));

        likeRepository.deleteByUserAndArticle(user, article);
    }
}
