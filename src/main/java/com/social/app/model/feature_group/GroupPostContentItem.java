package com.social.app.model.feature_group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.app.model.feature_post_image.PostItem;
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
@Table(name = "group_post_content_item")
public class GroupPostContentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    @JoinColumn(name = "group_post_id")
    private GroupPostItem groupPostItem;


    @Override
    public String toString() {
        return "GroupPostContentItem{" +
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
