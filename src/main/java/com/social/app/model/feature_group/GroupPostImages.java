package com.social.app.model.feature_group;

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
@Table(name = "group_post_images")
public class GroupPostImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image_url")
    private String imageUrl;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "group_post_id")
    private GroupPostItem groupPostItem;


    @Override
    public String toString() {
        return "GroupPostImages{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", post=" + groupPostItem +
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
