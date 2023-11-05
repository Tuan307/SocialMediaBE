package com.social.app.repository.feature_user;

import com.social.app.model.feature_user.TourInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourInterestRepository extends JpaRepository<TourInterest, Long> {
}
