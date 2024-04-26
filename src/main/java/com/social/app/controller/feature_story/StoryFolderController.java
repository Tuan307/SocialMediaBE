package com.social.app.controller.feature_story;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.dto.AddStoryContentDTO;
import com.social.app.model.dto.AddStoryFolderDTO;
import com.social.app.service.feature_story.StoryFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "api/v1/story")
public class StoryFolderController {

    @Autowired
    StoryFolderService service;

    @GetMapping()
    public ResponseResult fetchAllStoryFolder() {
        return service.getAllStoryFolder();
    }

    @PostMapping()
    public ResponseResult saveStoryFolder(@RequestBody AddStoryFolderDTO dto) {
        return service.addStoryFolder(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult deleteStoryFolder(@PathVariable("id") int id) {
        return service.deleteStoryFolder(id);
    }

    @PostMapping("/content")
    public ResponseResult saveStoryContent(@RequestBody AddStoryContentDTO dto) {
        return service.saveStoryContent(dto);
    }

    @GetMapping("/content")
    public ResponseResult saveStoryContent(@RequestParam("id") int id) {
        return service.fetchStoryContentFromFolder(id);
    }

    @DeleteMapping("/content/delete/{id}")
    public ResponseResult deleteStoryContent(@PathVariable("id") int id) {
        return service.deleteStoryContent(id);
    }
}
