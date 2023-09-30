package com.social.app.model.feature_post_image;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostRequest {
    private String id;
    private String description;
    private List<String> imagesList;
    private String userId;
    private String checkInTimestamp;
    private String checkInAddress;
    private Double checkInLatitude;
    private Double checkInLongitude;
    private String type;
    private String videoUrl;

    public PostRequest() {
    }

    public PostRequest(String id, String description, List<String> imagesList, String userId, String checkInTimestamp, String checkInAddress, Double checkInLatitude, Double checkInLongitude, String type, String videoUrl) {
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

    @Override
    public String toString() {
        return "PostRequest{" +
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
