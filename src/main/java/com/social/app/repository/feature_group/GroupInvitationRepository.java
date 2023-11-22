package com.social.app.repository.feature_group;

import com.social.app.model.feature_group.GroupInvitationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupInvitationRepository extends JpaRepository<GroupInvitationModel, Long> {
    @Query(value = "SELECT g FROM GroupInvitationModel g WHERE g.requestUserId.userId = ?1 AND g.type = ?2")
    Optional<List<GroupInvitationModel>> findInvitationByUserId(String userId, String type);

    @Query(value = "SELECT g FROM GroupInvitationModel g WHERE g.requestUserId.userId = ?1 AND g.groupId.id = ?2")
    Optional<GroupInvitationModel> findInvitationByUserIdAndGroupId(String userId, Long groupId);

    @Query(value = "SELECT g FROM GroupInvitationModel g WHERE g.fromInvitedUserId.userId = ?1 AND g.groupId.id = ?2")
    Optional<GroupInvitationModel> findInvitationByFromUserIdAndGroupId(String userId, Long groupId);

    @Query(value = "SELECT g FROM GroupInvitationModel g WHERE g.groupId.id = ?1")
    List<GroupInvitationModel> findInvitationByGroupId(Long groupId);

    @Modifying
    @Transactional
    @Query(value = "delete from group_request p where p.user_id =:userID or p.from_user_id =:userID",nativeQuery = true)
    void deleteAllByUserId(String userID);
}
