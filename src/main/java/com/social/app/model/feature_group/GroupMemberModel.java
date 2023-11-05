package com.social.app.model.feature_group;

import com.social.app.model.feature_user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "group_member")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupMemberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupModel groupModelId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User groupMemberUserId;

    @Column(name = "user_type")
    private String type;
}
