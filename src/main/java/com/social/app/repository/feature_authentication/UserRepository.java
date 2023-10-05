package com.social.app.repository.feature_authentication;

import com.social.app.model.feature_authentication.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.userId = ?1")
    Optional<User> findUserByUserId(String userId);

    Optional<List<User>> findByUserNameContaining(String keyword, PageRequest pageRequest);
}
