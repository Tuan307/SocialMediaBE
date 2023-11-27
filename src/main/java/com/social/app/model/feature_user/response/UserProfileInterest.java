package com.social.app.model.feature_user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfileInterest {
    private Long id;
    private String name;
    private Boolean hasChosen;
}
