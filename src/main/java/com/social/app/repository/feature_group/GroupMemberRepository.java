package com.social.app.repository.feature_group;

import com.social.app.model.feature_group.GroupMemberModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMemberModel, Long> {

    @Query(value = "SELECT g FROM GroupMemberModel g WHERE g.groupMemberUserId.userId = ?1 AND g.type = ?2")
    Optional<List<GroupMemberModel>> findGroupByUserId(String userId,String type, PageRequest pageRequest);

    @Query(value = "SELECT g FROM GroupMemberModel g WHERE g.groupMemberUserId.userId = ?1")
    Optional<GroupMemberModel> findUserByUserId(String userId);

    @Query(value = "SELECT g FROM GroupMemberModel g WHERE g.groupMemberUserId.userId = ?1 AND g.groupModelId.id = ?2")
    Optional<GroupMemberModel> findGroupByUserIdAndGroupId(String userId, Long groupId);

    @Query(value = "SELECT g FROM GroupMemberModel g WHERE g.groupModelId.id = ?1")
    Optional<List<GroupMemberModel>> findMembersByGroupId(Long groupId);

    @Query(value = "SELECT p FROM GroupMemberModel p WHERE p.groupModelId.id = ?1 AND p.groupMemberUserId.userName LIKE ?2%")
    List<GroupMemberModel> searchMemberByName(Long groupId, String keyword);
}
