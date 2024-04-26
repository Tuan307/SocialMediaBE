package com.social.app.repository.feature_story;

import com.social.app.model.feature_story.StoryFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryFolderRepository extends JpaRepository<StoryFolder, Integer> {

}
