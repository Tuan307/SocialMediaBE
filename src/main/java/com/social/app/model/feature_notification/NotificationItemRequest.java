package com.social.app.model.feature_notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationItemRequest {
    private Boolean isPost;
    private Boolean isInvitation;
    private String text;
    private String ownerId;
    private String postId;
    private String timeStamp;
    private String userId;

    @Override
    public String toString() {
        return "NotificationItemRequest{" +
                "isPost=" + isPost +
                ", isInvitation=" + isInvitation +
                ", text='" + text + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", postId='" + postId + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
