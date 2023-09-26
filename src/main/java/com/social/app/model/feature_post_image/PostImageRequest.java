package com.social.app.model.feature_post_image;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostImageRequest {
    private String id;
    private String description;
    private List<String> imagesList;
    private String userId;

    public PostImageRequest() {
    }

    public PostImageRequest(String id, String description, List<String> imagesList, String userId) {
        this.id = id;
        this.description = description;
        this.imagesList = imagesList;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostImageRequest{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", imagesList=" + imagesList +
                ", userId='" + userId + '\'' +
                '}';
    }
}
