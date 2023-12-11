package com.social.app.repository.feature_post_image;

import com.social.app.model.feature_post.PostItem;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository

public interface PostRepository extends JpaRepository<PostItem, String> {
    @Query(value = "SELECT p FROM PostItem p WHERE p.postUserId.userId = ?1")
    Optional<List<PostItem>> findPostByUserId(String userId, PageRequest pageRequest);

    @Query(value = "SELECT p FROM PostItem p WHERE p.postId = ?1")
    Optional<PostItem> findPostById(String postId);
    @Modifying
    @Transactional
    @Query(value = "delete from post_image p where p.post_user_id =:userID",nativeQuery = true)
    void deleteAllByUserId(String userID);
}
