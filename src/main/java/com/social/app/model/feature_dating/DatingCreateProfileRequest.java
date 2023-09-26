package com.social.app.model.feature_dating;

import java.util.List;

public class DatingCreateProfileRequest {
    private String profileId;
    private String name;
    private String dateOfBirth;
    private String bio;
    private Double latitude;
    private Double longitude;
    private List<String> imagesList;

    public DatingCreateProfileRequest() {
    }

    public DatingCreateProfileRequest(String profileId, String name, String dateOfBirth, String bio, Double latitude, Double longitude, List<String> imagesList) {
        this.profileId = profileId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imagesList = imagesList;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String id) {
        this.profileId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public String toString() {
        return "DatingCreateProfileRequest{" +
                "id='" + profileId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", bio='" + bio + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", imagesList=" + imagesList +
                '}';
    }
}
