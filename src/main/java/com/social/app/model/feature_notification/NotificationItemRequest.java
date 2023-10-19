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
    private String text;
    private String ownerId;
    private String postId;
    private String timeStamp;
    private String userId;
    private Boolean isInvitation;
    private Boolean isRequest;
    private Long groupId;

    @Override
    public String toString() {
        return "NotificationItemRequest{" +
                "isPost=" + isPost +
                ", text='" + text + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", postId='" + postId + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
