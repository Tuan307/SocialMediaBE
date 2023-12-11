package com.social.app.model.feature_post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_images")
public class PostImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image_url")
    private String imageUrl;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "post_id")
    private PostItem post;
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
