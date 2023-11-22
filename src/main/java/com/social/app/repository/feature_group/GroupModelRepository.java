package com.social.app.repository.feature_group;

import com.social.app.model.feature_group.GroupModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GroupModelRepository extends JpaRepository<GroupModel, Long> {
    @Query(value = "SELECT g FROM GroupModel g WHERE g.groupOwner.userId = ?1")
    List<GroupModel> findGroupByOwnerId(String userId, PageRequest pageRequest);

    @Modifying
    @Transactional
    @Query(value = "delete from group_model p where p.group_owner_id =:userID",nativeQuery = true)
    void deleteAllByUserId(String userID);
}
