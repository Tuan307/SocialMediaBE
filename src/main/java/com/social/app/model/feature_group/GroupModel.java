package com.social.app.model.feature_group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.app.model.feature_authentication.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "group_model")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_description")
    private String groupDescription;
    @Column(name = "group_image")
    private String groupImageUrl;
    @Column(name = "group_created_at")
    private String groupCreatedAt;

    @ManyToOne
    @JoinColumn(name = "group_owner_id")
    private User groupOwner;
    @Column(name = "group_privacy")
    private String groupPrivacy;

    @OneToMany(mappedBy = "groupModelId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<GroupMemberModel> groupMemberModels;

    @OneToMany(mappedBy = "groupPostModelId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<GroupPostItem> groupPostItemList;

    @OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<GroupInvitationModel> groupInvitationModelList;
}
