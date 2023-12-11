package com.social.app.model.feature_group;

import com.social.app.model.feature_user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "group_post")
public class GroupPostItem {
    @Id
    @Column(name = "group_post_id")
    private String groupPostId;
    private String description;

    @OneToMany(mappedBy = "groupPostItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupPostImages> groupPostImagesList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User groupPostUserId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupModel groupPostModelId;

    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "check_in_location")
    private String checkInAddress;
    @Column(name = "latitude")
    private Double checkInLatitude;
    @Column(name = "longitude")
    private Double checkInLongitude;
    @Column(name = "type")
    private String type;
    @Column(name = "video_url")
    private String videoUrl;
    @Column(name = "question")
    private String question;

    public GroupPostItem(String groupPostId) {
        this.groupPostId = groupPostId;
    }
}
