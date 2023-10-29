package com.social.app.repository.feature_authentication;

import com.social.app.model.feature_authentication.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findNearestUsers(double yourLat, double yourLng);
}
