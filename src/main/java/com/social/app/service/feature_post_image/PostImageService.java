package com.social.app.service.feature_post_image;

import com.social.app.model.ResponseResult;
import com.social.app.model.Status;
import com.social.app.model.feature_post_image.PostImageItem;
import com.social.app.model.feature_post_image.PostImageRequest;
import com.social.app.model.feature_post_image.PostImages;
import com.social.app.repository.feature_post_image.PostImageRepository;
import com.social.app.repository.feature_post_image.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostImageService {
    @Autowired
    private PostImageRepository postImageRepository;
    @Autowired
    private PostRepository postRepository;

    public ResponseResult saveData(PostImageRequest postImageRequest) {
        PostImageItem item = new PostImageItem(postImageRequest.getId(), postImageRequest.getDescription(), new ArrayList<PostImages>(), postImageRequest.getUserId());
        for (int i = 0; i < postImageRequest.getImagesList().size(); i++) {
            PostImages post = new PostImages(null, postImageRequest.getImagesList().get(i), new PostImageItem(postImageRequest.getId()));
            item.getImagesList().add(post);
        }
        PostImageItem result = postRepository.save(item);
        return new ResponseResult(new Status(200, "Yes"), result);
    }

    public ResponseResult getAlLDataByUser(String userId, int pageCount, int pageNumber) {
        Optional<List<PostImageItem>> postImageItemList = postRepository.findPostByUserId(userId, PageRequest.of(pageNumber, pageCount));
        return new ResponseResult(new Status(200, "Yes"), postImageItemList.get());
    }

    public ResponseResult getAllPosts(int pageCount, int pageNumber) {
        Page<PostImageItem> list = postRepository.findAll(PageRequest.of(pageNumber, pageCount));
        return new ResponseResult(new Status(200, "Successfully"), list, pageCount, pageNumber + 1);
    }

    public ResponseResult deletePost(String postId) {
        Optional<PostImageItem> post = postRepository.findById(postId);
        if (post.isPresent()) {
            postRepository.deleteById(postId);
            return new ResponseResult(new Status(200, "Successfully"), null);
        } else {
            return new ResponseResult(new Status(200, "Post does not exist"), null);
        }
    }

    public ResponseResult getDetailPost(String postId) {
        Optional<PostImageItem> post = postRepository.findById(postId);
        return post.map(postImageItem -> new ResponseResult(new Status(200, "Successfully"), postImageItem)).orElseGet(() -> new ResponseResult(new Status(200, "Post does not exist"), null));
    }
}

