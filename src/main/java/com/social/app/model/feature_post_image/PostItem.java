package com.social.app.model.feature_post_image;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.app.model.feature_user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_image")
public class PostItem {
    @Id
    @Column(name = "post_id")
    private String postId;
    private String description;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImages> imagesList;

    @ManyToOne
    @JoinColumn(name = "post_user_id")
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
    @Column(name = "question")
    private String question;
    @OneToMany(mappedBy = "post_saved_id", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SavedPostItem> savedPostItems;

    public PostItem(String postId, String description, List<PostImages> imagesList, User postUserId, String checkInTimestamp, String checkInAddress, Double checkInLatitude, Double checkInLongitude, String type, String videoUrl, String question) {
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
        this.question = question;
    }

    public PostItem(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "PostItem{" +
                "postId='" + postId + '\'' +
                ", description='" + description + '\'' +
                ", imagesList=" + imagesList +
                ", postUserId=" + postUserId +
                ", checkInTimestamp='" + checkInTimestamp + '\'' +
                ", checkInAddress='" + checkInAddress + '\'' +
                ", checkInLatitude=" + checkInLatitude +
                ", checkInLongitude=" + checkInLongitude +
                ", type='" + type + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
