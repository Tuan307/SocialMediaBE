package com.social.app.repository.feature_post_image;

import com.social.app.model.feature_post_image.PostItem;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostItem, String> {
    @Query(value = "SELECT p FROM PostItem p WHERE p.userId = ?1")
    Optional<List<PostItem>> findPostByUserId(String userId, PageRequest pageRequest);
}
