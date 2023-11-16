package com.social.app.model.feature_group.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateGroupRequest {
    private String groupName;
    private String groupDescription;
    private String groupImage;
    private String privacy;
}
