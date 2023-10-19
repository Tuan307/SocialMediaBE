package com.social.app.model.feature_group;

import com.social.app.model.feature_authentication.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "group_request")
public class GroupInvitationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "type")
    private String type;
    @Column(name = "message")
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User requestUserId;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromInvitedUserId;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupModel groupId;

}
