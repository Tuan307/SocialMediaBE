package com.social.app.model.feature_group.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateGroupRequest {
    private String groupName;
    private String groupDescription;
    private String groupImage;
    private String groupCreatedAt;
    private String userId;
    private String privacy;
}
