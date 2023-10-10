package com.social.app.repository.feature_group;

import com.social.app.model.feature_group.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupModelRepository extends JpaRepository<GroupModel, Long> {

}
