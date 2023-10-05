package com.social.app.model.feature_notification;

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
@Table(name = "notification_item")
public class NotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_post")
    private Boolean isPost;
    @Column(name = "is_invitation")
    private Boolean isInvitation;
    @Column(name = "text")
    private String text;
    @Column(name = "notification_post_id")
    private String notificationPostId;
    @Column(name = "notification_timestamp")
    private String notificationTimeStamp;
    @Column(name = "notification_owner_id")
    private String notificationOwnerId;
    @ManyToOne
    @JoinColumn(name = "notification_user_id")
    private User notificationUserId;

    @Override
    public String toString() {
        return "NotificationModel{" +
                "id=" + id +
                ", isPost=" + isPost +
                ", isInvitation=" + isInvitation +
                ", text='" + text + '\'' +
                ", notificationPostId='" + notificationPostId + '\'' +
                ", notificationTimeStamp='" + notificationTimeStamp + '\'' +
                ", notificationOwnerId='" + notificationOwnerId + '\'' +
                ", notificationUserId=" + notificationUserId +
                '}';
    }
}
