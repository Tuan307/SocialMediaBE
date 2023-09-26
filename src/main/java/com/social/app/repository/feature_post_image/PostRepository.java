package com.social.app.repository.feature_post_image;

import com.social.app.model.feature_authentication.User;
import com.social.app.model.feature_post_image.PostImageItem;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostImageItem, String> {
    @Query(value = "SELECT p FROM PostImageItem p WHERE p.userId = ?1")
    Optional<List<PostImageItem>> findPostByUserId(String userId, PageRequest pageRequest);
}
