package com.social.app.controller.feature_authentication;

import com.social.app.model.ResponseResult;
import com.social.app.model.feature_authentication.User;
import com.social.app.service.feature_authentication.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseResult getUserProfile(@PathVariable("id") String id) {
        return userService.getUserProfile(id);
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
    public ResponseResult searchUsers(@RequestParam("name") String name, @RequestParam("pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return userService.searchUser(name, pageCount, pageNumber - 1);
    }
}
