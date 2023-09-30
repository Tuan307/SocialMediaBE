package com.social.app.model.feature_post_image;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item_post_image")
public class PostImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JsonIgnore
    @JoinColumn(name = "post_id")
    private PostItem post;

    public PostImages(Long id, String imageUrl, PostItem post) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.post = post;
    }

    public PostImages() {
    }

    @Override
    public String toString() {
        return "PostImages{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", post=" + post +
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
