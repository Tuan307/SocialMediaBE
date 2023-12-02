package com.social.app.repository.feature_user;

import com.social.app.model.feature_user.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<UserFollow, Long> {

    @Query("SELECT u FROM UserFollow u WHERE u.sourceId.userId = ?1 AND u.targetId.userId = ?2 AND u.type = ?3")
    Optional<UserFollow> findFollowUserByUserId(String sourceId, String targetId, String type);

    @Query("SELECT u FROM UserFollow u WHERE u.sourceId.userId = ?1 AND u.type = ?2")
    List<UserFollow> findUserFollow(String sourceId, String type);

}
