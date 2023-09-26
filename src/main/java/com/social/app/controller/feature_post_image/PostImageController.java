package com.social.app.controller.feature_post_image;

import com.social.app.model.ResponseResult;
import com.social.app.model.feature_post_image.PostImageRequest;
import com.social.app.service.feature_post_image.PostImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/post-image")
public class PostImageController {
    @Autowired
    private PostImageService postImageService;

    @PostMapping("")
    public ResponseResult savePostImage(@RequestBody PostImageRequest postImageRequest) {
        return postImageService.saveData(postImageRequest);
    }

    @GetMapping("/detail")
    public ResponseResult getAllPostByUserId(@RequestParam("userId") String userId, @RequestParam("pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return postImageService.getAlLDataByUser(userId, pageCount, pageNumber - 1);
    }

    @GetMapping("/post-detail")
    public ResponseResult getDetailPost(@RequestParam("postId") String postId) {
        return postImageService.getDetailPost(postId);
    }

    @GetMapping()
    public ResponseResult getAllPosts(@RequestParam(value = "pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return postImageService.getAllPosts(pageCount, pageNumber - 1);
    }

    @DeleteMapping("/delete")
    public ResponseResult deletePost(@RequestParam("postId") String postId) {
        return postImageService.deletePost(postId);
    }

}
