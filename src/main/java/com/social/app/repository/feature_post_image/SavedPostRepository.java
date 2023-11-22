package com.social.app.repository.feature_post_image;

import com.social.app.model.feature_post_image.SavedPostItem;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavedPostRepository extends JpaRepository<SavedPostItem, Long> {
    @Query(value = "SELECT s FROM SavedPostItem s WHERE s.user_saved_id.userId = ?1")
    Optional<List<SavedPostItem>> findSavedPostByUserId(String userId, PageRequest pageRequest);

    @Query(value = "SELECT s FROM SavedPostItem s WHERE s.user_saved_id.userId = ?1")
    List<SavedPostItem> findSavedPostByUserIdUnPaging(String userId);

    @Query(value = "SELECT s FROM SavedPostItem s WHERE s.post_saved_id.postId = ?1 AND s.user_saved_id.userId = ?2")
    Optional<SavedPostItem> findSavedPostByPostId(String postId, String userId);
}
