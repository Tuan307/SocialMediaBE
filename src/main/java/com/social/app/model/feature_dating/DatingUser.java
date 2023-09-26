package com.social.app.model.feature_dating;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dating_user")
public class DatingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "profile_id")
    private String profileId;
    private String name;
    private LocalDate dateOfBirth;
    private String bio;
    @Transient
    private Integer age;
    private Double latitude;
    private Double longitude;
    @OneToMany(mappedBy = "datingUser", cascade = CascadeType.ALL)
    private List<DatingImage> imagesList;

    public DatingUser(Long id, String profileId, String name, LocalDate dateOfBirth, String bio,  Double latitude, Double longitude, List<DatingImage> imagesList) {
        this.id = id;
        this.profileId = profileId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imagesList = imagesList;
    }

    public DatingUser() {
    }

    public DatingUser(String id) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public List<DatingImage> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<DatingImage> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public String toString() {
        return "DatingUser{" +
                "id='" + id + '\'' +
                ", profileId='" + profileId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", bio='" + bio + '\'' +
                ", age=" + age +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", imagesList=" + imagesList +
                '}';
    }
}
