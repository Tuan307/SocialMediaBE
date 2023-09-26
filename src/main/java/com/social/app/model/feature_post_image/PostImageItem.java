package com.social.app.model.feature_post_image;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "post_image")
public class PostImageItem {
    @Id
    private String id;
    private String description;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImages> imagesList;
    private String userId;

    public PostImageItem(String id, String description, List<PostImages> imagesList, String userId) {
        this.id = id;
        this.description = description;
        this.imagesList = imagesList;
        this.userId = userId;
    }

    public PostImageItem() {
    }

    public PostImageItem(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PostImages> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<PostImages> imagesList) {
        this.imagesList = imagesList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostImageItem{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", imagesList=" + imagesList +
                ", userId=" + userId +
                '}';
    }
}
