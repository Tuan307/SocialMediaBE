package com.social.app.controller.feature_user;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.feature_user.UpdateUserRequest;
import com.social.app.model.feature_user.User;
import com.social.app.model.feature_user.request.FollowUserRequest;
import com.social.app.model.feature_user.request.UpdateBlockRequest;
import com.social.app.model.feature_user.request.UpdateLastOnlineRequest;
import com.social.app.model.feature_user.request.UserInterestRequest;
import com.social.app.service.feature_user.UserFollowService;
import com.social.app.service.feature_user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserFollowService userFollowService;

    @GetMapping("/{id}")
    public ResponseResult getUserProfile(@PathVariable("id") String id) {
        return userService.getUserProfile(id);
    }

    @GetMapping("/nearby")
    public List<User> findNearestUsers(@RequestParam("userId") String userId, @RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude, @RequestParam("limit") int limit) {
        return userService.findNearestUsers(userId, latitude, longitude, limit);
    }

    @PutMapping("/update/profile")
    public ResponseResult updateProfile(@RequestBody UpdateUserRequest request) {
        return userService.updateUserProfile(request);
    }

    @GetMapping("")
    public ResponseResult getAllUsers(@RequestParam("pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return userService.getAllUsers(pageCount, pageNumber - 1);
    }

    @PostMapping("/register")
    public ResponseResult addUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @DeleteMapping("/delete")
    public ResponseResult deleteUser(@RequestParam("userId") String userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("/search")
    public ResponseResult searchUsers(@RequestParam("keyword") String name, @RequestParam("pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return userService.searchUser(name, pageNumber - 1, pageCount);
    }

    @GetMapping("/interest")
    public ResponseResult getAllInterests() {
        return userService.getAllInterests();
    }

    @GetMapping("/interest/check")
    public ResponseResult checkIfUserHasInterest(@RequestParam("userId") String userId) {
        return userService.checkIfUserHasInterest(userId);
    }

    @GetMapping("/interest/get_user_interest")
    public ResponseResult getUserInterest(@RequestParam("userId") String userId) {
        return userService.getUserInterest(userId);
    }

    @PostMapping("/interest/save")
    public ResponseResult saveUserInterest(@RequestBody UserInterestRequest request) {
        return userService.saveUserInterest(request);
    }

    @PostMapping("/interest/update")
    public ResponseResult updateUserInterest(@RequestBody UserInterestRequest request) {
        return userService.updateUserInterest(request);
    }

    @PostMapping("/block")
    public ResponseResult updateUserBlock(@RequestParam("userId") String userId, @RequestBody UpdateBlockRequest request) {
        return userService.blockUser(userId, request);
    }

    @PostMapping("/update/last/online")
    public ResponseResult updateUserLastOnline(@RequestBody UpdateLastOnlineRequest request, @RequestParam("userId") String userId) {
        return userService.updateUserLastOnline(request, userId);
    }

    @PostMapping("/follow")
    public ResponseResult followUser(@RequestBody FollowUserRequest request) {
        return userFollowService.followUser(request);
    }

    @PostMapping("/unfollow")
    public ResponseResult unfollowUser(@RequestBody FollowUserRequest request) {
        return userFollowService.unfollowUser(request);
    }

    @PostMapping("/is_following")
    public ResponseResult checkIfIsFollowing(@RequestBody FollowUserRequest request) {
        return userFollowService.isFollowingUser(request);
    }

    @GetMapping("/follow/list")
    public ResponseResult getListFollowing(@RequestParam("sourceId") String sourceId, @RequestParam("type") String type) {
        return userFollowService.getListFollowing(sourceId, type);
    }
}
