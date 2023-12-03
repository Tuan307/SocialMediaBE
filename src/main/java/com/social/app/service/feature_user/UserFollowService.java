package com.social.app.service.feature_user;

import com.social.app.common.CommonUtils;
import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.feature_user.User;
import com.social.app.model.feature_user.UserFollow;
import com.social.app.model.feature_user.request.FollowUserRequest;
import com.social.app.repository.feature_user.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserFollowService {
    @Autowired
    private FollowRepository userFollowRepository;

    public ResponseResult followUser(FollowUserRequest request) {
        User sourceUser = new User(request.getSourceId());
        User targetUser = new User(request.getTargetId());
        UserFollow userFollow = new UserFollow(0L, "follow", request.getCreatedAt(), sourceUser, targetUser);
        UserFollow userFollower = new UserFollow(0L, "follower", request.getCreatedAt(), targetUser, sourceUser);
        UserFollow result = userFollowRepository.save(userFollow);
        userFollowRepository.save(userFollower);
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), result);
    }

    public ResponseResult unfollowUser(FollowUserRequest request) {
        Optional<UserFollow> u = userFollowRepository.findFollowUserByUserId(request.getSourceId(), request.getTargetId(), "follow");
        if (u.isPresent()) {
            Optional<UserFollow> follower = userFollowRepository.findFollowUserByUserId(request.getTargetId(), request.getSourceId(), "follower");
            follower.ifPresent(userFollow -> userFollowRepository.deleteById(userFollow.getId()));
            userFollowRepository.deleteById(u.get().getId());
            return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), true);
        } else {
            return new ResponseResult(new Status(200, CommonUtils.USER_EXIST_ERROR_RESPONSE), false);
        }
    }

    public ResponseResult isFollowingUser(FollowUserRequest request) {
        Optional<UserFollow> u = userFollowRepository.findFollowUserByUserId(request.getSourceId(), request.getTargetId(), "follow");
        if (u.isPresent()) {
            return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), true);
        } else {
            return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), false);
        }
    }

    public ResponseResult getListFollowing(String sourceId, String type) {
        List<UserFollow> list = userFollowRepository.findUserFollow(sourceId, type);
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), list);
    }

}
