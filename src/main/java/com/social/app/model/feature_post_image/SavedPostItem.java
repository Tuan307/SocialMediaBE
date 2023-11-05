package com.social.app.model.feature_post_image;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.app.model.feature_user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "saved_post")
public class SavedPostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_saved_id")
    private PostItem post_saved_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_saved_id")
    private User user_saved_id;

}
