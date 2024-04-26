package com.social.app.model.feature_story;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.app.model.feature_user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "story_folder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoryFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "folder_avatar")
    private String folderAvatar;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User storyUser;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storyFolder")
    @JsonIgnore
    private List<StoryContent> storyContents;
}
