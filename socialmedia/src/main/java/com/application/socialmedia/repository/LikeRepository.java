package com.application.socialmedia.repository;

import com.application.socialmedia.model.Article;
import com.application.socialmedia.model.Like;
import com.application.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByUserAndArticle(User user, Article article);
    void deleteByUserAndArticle(User user, Article article);
}

