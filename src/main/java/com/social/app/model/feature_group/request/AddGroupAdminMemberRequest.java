package com.social.app.model.feature_group.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddGroupAdminMemberRequest {
    private String userId;
    private Long groupId;
}
