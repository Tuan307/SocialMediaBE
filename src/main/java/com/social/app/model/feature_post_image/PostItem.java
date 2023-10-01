package com.social.app.model.feature_post_image;

import com.social.app.model.feature_authentication.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "post_image")
public class PostItem {
    @Id
    @Column(name = "post_id")
    private String postId;
    private String description;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImages> imagesList;
    @ManyToOne
    @JoinColumn(name = "post_user_id", nullable = false)
    private User postUserId;
    @Column(name = "check_in_timestamp")
    private String checkInTimestamp;
    @Column(name = "check_in_address")
    private String checkInAddress;
    @Column(name = "check_in_latitude")
    private Double checkInLatitude;
    @Column(name = "check_in_longitude")
    private Double checkInLongitude;
    @Column(name = "type")
    private String type;
    @Column(name = "video_url")
    private String videoUrl;


    public PostItem(String postId, String description, List<PostImages> imagesList, User postUserId, String checkInTimestamp, String checkInAddress, Double checkInLatitude, Double checkInLongitude, String type, String videoUrl) {
        this.postId = postId;
        this.description = description;
        this.imagesList = imagesList;
        this.postUserId = postUserId;
        this.checkInTimestamp = checkInTimestamp;
        this.checkInAddress = checkInAddress;
        this.checkInLatitude = checkInLatitude;
        this.checkInLongitude = checkInLongitude;
        this.type = type;
        this.videoUrl = videoUrl;
    }

    public PostItem() {
    }

    public PostItem(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCheckInTimestamp() {
        return checkInTimestamp;
    }

    public void setCheckInTimestamp(String checkInTimestamp) {
        this.checkInTimestamp = checkInTimestamp;
    }

    public String getCheckInAddress() {
        return checkInAddress;
    }

    public void setCheckInAddress(String checkInAddress) {
        this.checkInAddress = checkInAddress;
    }

    public Double getCheckInLatitude() {
        return checkInLatitude;
    }

    public void setCheckInLatitude(Double checkInLatitude) {
        this.checkInLatitude = checkInLatitude;
    }

    public Double getCheckInLongitude() {
        return checkInLongitude;
    }

    public void setCheckInLongitude(Double checkInLongitude) {
        this.checkInLongitude = checkInLongitude;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public User getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(User userId) {
        this.postUserId = userId;
    }

    @Override
    public String toString() {
        return "PostItem{" +
                "id='" + postId + '\'' +
                ", description='" + description + '\'' +
                ", imagesList=" + imagesList +
                ", checkInTimestamp='" + checkInTimestamp + '\'' +
                ", checkInAddress='" + checkInAddress + '\'' +
                ", checkInLatitude=" + checkInLatitude +
                ", checkInLongitude=" + checkInLongitude +
                ", type='" + type + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
