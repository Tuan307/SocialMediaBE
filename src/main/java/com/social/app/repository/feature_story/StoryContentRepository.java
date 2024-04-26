package com.social.app.repository.feature_story;

import com.social.app.model.feature_story.StoryContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryContentRepository extends JpaRepository<StoryContent, Integer> {

    @Query(value = "SELECT p FROM StoryContent p WHERE p.storyFolder.id = ?1")
    List<StoryContent> findStoryContentByStoryFolderId(int id);
}
