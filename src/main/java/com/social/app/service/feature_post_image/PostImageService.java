package com.social.app.service.feature_post_image;

import com.social.app.model.ResponseResult;
import com.social.app.model.Status;
import com.social.app.model.feature_post_image.PostImages;
import com.social.app.model.feature_post_image.PostItem;
import com.social.app.model.feature_post_image.PostRequest;
import com.social.app.repository.feature_post_image.PostImageRepository;
import com.social.app.repository.feature_post_image.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public ResponseResult saveData(PostRequest postRequest) {
        PostItem item = new PostItem(postRequest.getId(), postRequest.getDescription(), new ArrayList<PostImages>(), postRequest.getUserId(), postRequest.getCheckInTimestamp(), postRequest.getCheckInAddress(), postRequest.getCheckInLatitude(), postRequest.getCheckInLongitude(), postRequest.getType(), postRequest.getVideoUrl());
        if(postRequest.getType().equals("image")){
            for (int i = 0; i < postRequest.getImagesList().size(); i++) {
                PostImages post = new PostImages(null, postRequest.getImagesList().get(i), new PostItem(postRequest.getId()));
                item.getImagesList().add(post);
            }
        }
        PostItem result = postRepository.save(item);
        return new ResponseResult(new Status(200, "Yes"), result);
    }

    public ResponseResult getAlLDataByUser(String userId, int pageCount, int pageNumber) {
        Optional<List<PostItem>> postImageItemList = postRepository.findPostByUserId(userId, PageRequest.of(pageNumber, pageCount));
        return new ResponseResult(new Status(200, "Yes"), postImageItemList.get());
    }

    public ResponseResult getAllPosts(int pageCount, int pageNumber, String field) {
        Page<PostItem> list = postRepository.findAll(PageRequest.of(pageNumber, pageCount).withSort(Sort.by(field).descending()));
        return new ResponseResult(new Status(200, "Successfully"), list, pageCount, pageNumber + 1);
    }

    public ResponseResult deletePost(String postId) {
        Optional<PostItem> post = postRepository.findById(postId);
        if (post.isPresent()) {
            postRepository.deleteById(postId);
            return new ResponseResult(new Status(200, "Successfully"), null);
        } else {
            return new ResponseResult(new Status(200, "Post does not exist"), null);
        }
    }

    public ResponseResult getDetailPost(String postId) {
        Optional<PostItem> post = postRepository.findById(postId);
        return post.map(postItem -> new ResponseResult(new Status(200, "Successfully"), postItem)).orElseGet(() -> new ResponseResult(new Status(200, "Post does not exist"), null));
    }
}

