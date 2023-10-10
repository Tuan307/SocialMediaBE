package com.social.app.repository.feature_group;

import com.social.app.model.feature_group.GroupPostItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupPostItemRepository extends JpaRepository<GroupPostItem, String> {
    @Query(value = "SELECT p FROM GroupPostItem p WHERE p.groupPostModelId.id = ?1")
    Page<GroupPostItem> findPostByGroupId(Long groupId, Pageable pageable);

    @Query(value = "SELECT p FROM GroupPostItem p WHERE p.groupPostModelId.id = ?1 AND p.groupPostId = ?2")
    Optional<GroupPostItem> findPostByGroupIdAndPostId(Long groupId, String postId);

    @Query(value = "SELECT p FROM GroupPostItem p WHERE p.groupPostModelId.id = ?1 AND p.description LIKE ?2%")
    List<GroupPostItem> searchPostByDescription(Long groupId, String keyword);
}
