package com.social.app.repository.feature_dating;

import com.social.app.model.feature_authentication.User;
import com.social.app.model.feature_dating.DatingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatingUserRepository extends JpaRepository<DatingUser, Long> {

    @Query("SELECT u FROM DatingUser u WHERE u.profileId = ?1")
    Optional<DatingUser> findUserByProfileId(String profileId);
}
