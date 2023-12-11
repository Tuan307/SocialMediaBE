package com.social.app.repository.feature_group;

import com.social.app.model.feature_group.GroupPostImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPostContentRepository extends JpaRepository<GroupPostImages, Long> {
}
