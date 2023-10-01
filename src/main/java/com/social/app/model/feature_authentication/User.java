package com.social.app.model.feature_authentication;

import com.social.app.model.feature_post_image.PostItem;
import jakarta.persistence.*;

import java.util.List;

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
    private List<PostItem> postItemList;

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

    public List<PostItem> getPostItemList() {
        return postItemList;
    }

    public void setPostItemList(List<PostItem> postItemList) {
        this.postItemList = postItemList;
    }

    public User() {
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", bio='" + bio + '\'' +
                ", email='" + email + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
