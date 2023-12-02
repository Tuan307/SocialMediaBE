package com.social.app.model.feature_user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FollowUserRequest {
    private String targetId;
    private String sourceId;
    private String createdAt;
}
