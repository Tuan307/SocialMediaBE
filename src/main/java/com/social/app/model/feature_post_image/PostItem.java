package com.social.app.model.feature_post_image;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "post_image")
public class PostItem {
    @Id
    private String id;
    private String description;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImages> imagesList;
    private String userId;
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

    public PostItem(String id, String description, List<PostImages> imagesList, String userId, String checkInTimestamp, String checkInAddress, Double checkInLatitude, Double checkInLongitude, String type, String videoUrl) {
        this.id = id;
        this.description = description;
        this.imagesList = imagesList;
        this.userId = userId;
        this.checkInTimestamp = checkInTimestamp;
        this.checkInAddress = checkInAddress;
        this.checkInLatitude = checkInLatitude;
        this.checkInLongitude = checkInLongitude;
        this.type = type;
        this.videoUrl = videoUrl;
    }

    public PostItem() {
    }

    public PostItem(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "PostItem{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", imagesList=" + imagesList +
                ", userId='" + userId + '\'' +
                ", checkInTimestamp='" + checkInTimestamp + '\'' +
                ", checkInAddress='" + checkInAddress + '\'' +
                ", checkInLatitude=" + checkInLatitude +
                ", checkInLongitude=" + checkInLongitude +
                ", type='" + type + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
