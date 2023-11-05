package com.social.app.repository.feature_user;

import com.social.app.model.feature_user.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findNearestUsers(double yourLat, double yourLng);
}
