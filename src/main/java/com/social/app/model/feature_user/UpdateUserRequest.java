package com.social.app.model.feature_user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private String userId;
    private String userName;
    private String fullName;
    private String bio;
    private String imageUrl;
    private Double latitude;
    private Double longitude;
}
