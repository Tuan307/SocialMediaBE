package com.social.app.repository.feature_dating;

import com.social.app.model.feature_dating.DatingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatingUserRepository extends JpaRepository<DatingUser, String> {
}
