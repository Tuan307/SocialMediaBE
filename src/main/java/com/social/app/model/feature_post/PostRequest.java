package com.social.app.model.feature_post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String question;

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
