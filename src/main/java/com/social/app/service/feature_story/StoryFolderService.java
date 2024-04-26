package com.social.app.service.feature_story;

import com.social.app.common.CommonUtils;
import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.dto.AddStoryContentDTO;
import com.social.app.model.dto.AddStoryFolderDTO;
import com.social.app.model.feature_story.StoryContent;
import com.social.app.model.feature_story.StoryFolder;
import com.social.app.model.feature_user.User;
import com.social.app.repository.feature_story.StoryContentRepository;
import com.social.app.repository.feature_story.StoryFolderRepository;
import com.social.app.repository.feature_user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StoryFolderService {
    @Autowired
    private StoryFolderRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoryContentRepository storyContentRepository;

    // folder
    public ResponseResult addStoryFolder(AddStoryFolderDTO dto) {
        Optional<User> user = userRepository.findUserByUserId(dto.getUserId());
        if (user.isPresent()) {
            StoryFolder storyFolder = new StoryFolder(0, dto.getName(), dto.getCreatedAt(), dto.getFolderAvatar(), user.get(), new ArrayList<>());
            return new ResponseResult(new Status(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()), repository.save(storyFolder));
        } else {
            return new ResponseResult(new Status(HttpStatus.NO_CONTENT.value(), CommonUtils.USER_EXIST_ERROR_RESPONSE), null);
        }
    }

    public ResponseResult getAllStoryFolder() {
        return new ResponseResult(new Status(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()), repository.findAll());
    }

    public ResponseResult deleteStoryFolder(int id) {
        Optional<StoryFolder> storyFolder = repository.findById(id);
        if (storyFolder.isPresent()) {
            repository.deleteById(id);
            return new ResponseResult(new Status(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()), null);
        } else {
            return new ResponseResult(new Status(HttpStatus.NO_CONTENT.value(), CommonUtils.STORY_FOLDER_EXIST_ERROR_RESPONSE), null);
        }
    }

    //content
    public ResponseResult fetchStoryContentFromFolder(int id) {
        return new ResponseResult(new Status(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()), storyContentRepository.findStoryContentByStoryFolderId(id));
    }

    public ResponseResult saveStoryContent(AddStoryContentDTO model) {
        Optional<StoryFolder> folder = repository.findById(model.getStoryId());
        if (folder.isPresent()) {
            for (int i = 0; i < model.getContentUrl().size(); i++) {
                StoryContent storyContent = new StoryContent(0, model.getType(), model.getContentUrl().get(i), folder.get());
                folder.get().getStoryContents().add(storyContent);
            }
            return new ResponseResult(new Status(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()), repository.save(folder.get()));
        } else {
            return new ResponseResult(new Status(HttpStatus.NO_CONTENT.value(), CommonUtils.USER_EXIST_ERROR_RESPONSE), null);
        }
    }

    public ResponseResult deleteStoryContent(int id) {
        Optional<StoryContent> folder = storyContentRepository.findById(id);
        if (folder.isPresent()) {
            storyContentRepository.deleteById(id);
            return new ResponseResult(new Status(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()), null);
        } else {
            return new ResponseResult(new Status(HttpStatus.NO_CONTENT.value(), CommonUtils.STORY_FOLDER_EXIST_ERROR_RESPONSE), null);
        }
    }

}
