package com.social.app.controller.feature_user;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.feature_user.UpdateUserRequest;
import com.social.app.model.feature_user.User;
import com.social.app.service.feature_user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

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

    @GetMapping("/search")
    public ResponseResult searchUsers(@RequestParam("keyword") String name, @RequestParam("pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return userService.searchUser(name, pageNumber - 1, pageCount);
    }

    @GetMapping("/interest")
    public ResponseResult getAllInterests() {
        return userService.getAllInterests();
    }
}
