package com.social.app.model.feature_user.request;

import com.social.app.model.feature_user.TourInterest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInterestRequest {
    private String userId;
    private List<TourInterest> interests;
}
