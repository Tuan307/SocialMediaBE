package com.social.app.repository.feature_group;

import com.social.app.model.feature_group.GroupModel;
import com.social.app.model.feature_post_image.PostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupModelRepository extends JpaRepository<GroupModel, Long> {

}
