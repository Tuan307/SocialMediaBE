package com.social.app.repository.feature_dating;

import com.social.app.model.feature_dating.DatingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatingImageRepository extends JpaRepository<DatingImage, Long> {
}
