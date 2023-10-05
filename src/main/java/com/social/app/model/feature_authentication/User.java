package com.social.app.model.feature_authentication;

import com.social.app.model.feature_notification.NotificationModel;
import com.social.app.model.feature_post_image.PostItem;
import com.social.app.model.feature_post_image.SavedPostItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "bio")
    private String bio;
    @Column(name = "email")
    private String email;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    @OneToMany(mappedBy = "postUserId", cascade = CascadeType.ALL)
    @Transient
    private List<PostItem> postItemList;

    @OneToMany(mappedBy = "user_saved_id", cascade = CascadeType.ALL)
    @Transient
    private List<SavedPostItem> savedPostItems;

    @OneToMany(mappedBy = "notificationUserId", cascade = CascadeType.ALL)
    @Transient
    private List<NotificationModel> notificationModelList;

    public User(String userId, String userName, String fullName, String imageUrl, String bio, String email, Double latitude, Double longitude, List<PostItem> postItemList) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.imageUrl = imageUrl;
        this.bio = bio;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postItemList = postItemList;
    }

    public User(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", bio='" + bio + '\'' +
                ", email='" + email + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", postItemList=" + postItemList +
                '}';
    }
}
