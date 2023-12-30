package com.social.app.repository.feature_user;

import com.social.app.model.feature_user.UserInterestProfile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTourRepository extends JpaRepository<UserInterestProfile, Long> {
    @Query("SELECT u FROM UserInterestProfile u WHERE u.userInterest.userId = ?1")
    List<UserInterestProfile> findByUserId(String userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_interest WHERE user_id = ?1", nativeQuery = true)
    void deleteInterestByUserId(String userId);
}
