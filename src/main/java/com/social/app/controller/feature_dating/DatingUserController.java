package com.social.app.controller.feature_dating;

import com.social.app.model.ResponseResult;
import com.social.app.model.feature_dating.DatingCreateProfileRequest;
import com.social.app.model.feature_dating.DatingUser;
import com.social.app.service.feature_dating.DatingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/dating")
public class DatingUserController {

    @Autowired
    private DatingUserService datingUserService;

    @GetMapping()
    public List<DatingUser> getAllUser() {
        return datingUserService.getAllUser();
    }

    @PostMapping(path = "/create/profile")
    public ResponseResult saveDatingProfile(@RequestBody DatingCreateProfileRequest datingUser) {
        return datingUserService.saveDatingProfile(datingUser);
    }

    @GetMapping("/check/exist")
    public ResponseResult checkExistDatingProfile(@RequestParam("id") String id) {
        return datingUserService.checkUserExist(id);
    }
}
