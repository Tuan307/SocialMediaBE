package com.social.app.model.feature_dating;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dating_image")
public class DatingImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageLink;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @MapsId
    @JoinColumn(name = "profile_id")
    private DatingUser datingUser;

    public DatingImage() {
    }
    public DatingImage(String imageLink, DatingUser user) {
        this.imageLink = imageLink;
        this.datingUser = user;
    }
    public DatingImage(Long id, String imageLink, DatingUser user) {
        this.id = id;
        this.imageLink = imageLink;
        this.datingUser = user;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public DatingUser getUser() {
        return datingUser;
    }

    public void setUser(DatingUser user) {
        this.datingUser = user;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageLink='" + imageLink + '\'' +
                ", user=" + datingUser +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
