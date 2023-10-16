package com.social.app.model.feature_group;

import com.social.app.model.feature_authentication.User;
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
@Table(name = "group_post_item")
public class GroupPostItem {
    @Id
    @Column(name = "group_post_id")
    private String groupPostId;
    private String description;

    @OneToMany(mappedBy = "groupPostItem", cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<GroupPostContentItem> groupPostContentItemList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_post_user_id")
    private User groupPostUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_post_group_id")
    private GroupModel groupPostModelId;

    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "check_in_address")
    private String checkInAddress;
    @Column(name = "check_in_latitude")
    private Double checkInLatitude;
    @Column(name = "check_in_longitude")
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
