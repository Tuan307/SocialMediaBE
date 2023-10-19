package com.social.app.model.feature_group.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequestOrInvite {
    private String createdAt;
    private String message;
    private String type;
    private String userId;
    private Long groupId;
    private String fromInvitedUserId;
}
