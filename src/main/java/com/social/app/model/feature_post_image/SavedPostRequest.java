package com.social.app.model.feature_post_image;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class SavedPostRequest {
    private String userSavedId;
    private String postSavedId;

    public String getUserSavedId() {
        return userSavedId;
    }

    public void setUserSavedId(String userSavedId) {
        this.userSavedId = userSavedId;
    }

    public String getPostSavedId() {
        return postSavedId;
    }

    public void setPostSavedId(String postSavedId) {
        this.postSavedId = postSavedId;
    }

    @Override
    public String toString() {
        return "SavedPostRequest{" +
                "userSavedId='" + userSavedId + '\'' +
                ", postSavedId='" + postSavedId + '\'' +
                '}';
    }
}
