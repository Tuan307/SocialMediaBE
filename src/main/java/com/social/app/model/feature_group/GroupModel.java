package com.social.app.model.feature_group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.app.model.feature_user.User;
import com.social.app.model.feature_notification.NotificationModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "travel_group")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String groupName;
    @Column(name = "description")
    private String groupDescription;
    @Column(name = "image_url")
    private String groupImageUrl;
    @Column(name = "created_at")
    private String groupCreatedAt;
    @ManyToOne
    @JoinColumn(name = "group_owner_id")
    private User groupOwner;
    @Column(name = "privacy")
    private String groupPrivacy;

    @OneToMany(mappedBy = "groupModelId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<GroupMemberModel> groupMemberModels;

    @OneToMany(mappedBy = "groupPostModelId",  cascade =CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<GroupPostItem> groupPostItemList;

    @OneToMany(mappedBy = "groupId",  cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<GroupInvitationModel> groupInvitationModelList;

    @OneToMany(mappedBy = "notificationGroupId",  cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<NotificationModel> notificationModelList;

}
