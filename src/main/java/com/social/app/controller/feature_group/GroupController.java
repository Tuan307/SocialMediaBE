package com.social.app.controller.feature_group;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.feature_group.request.AddGroupMemberRequest;
import com.social.app.model.feature_group.request.CreateGroupPostItem;
import com.social.app.model.feature_group.request.CreateGroupRequest;
import com.social.app.model.feature_group.request.GroupRequestOrInvite;
import com.social.app.service.feature_group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public ResponseResult createGroup(@RequestBody CreateGroupRequest request) {
        return groupService.createGroup(request);
    }

    @GetMapping("")
    public ResponseResult getAllGroup() {
        return groupService.getAllGroup();
    }

    @GetMapping("/user")
    public ResponseResult getAllGroupByUserId(@RequestParam("userId") String userId) {
        return groupService.getAllGroupByUserId(userId, 0, 20);
    }

    @GetMapping("/invitation")
    public ResponseResult getAllInvitation(@RequestParam("userId") String userId) {
        return groupService.getAllGroupInvitation(userId, "invite");
    }

    @PostMapping("/invite")
    public ResponseResult inviteMember(@RequestBody GroupRequestOrInvite request) {
        return groupService.inviteMemberToGroup(request);
    }

    @PostMapping("/request")
    public ResponseResult requestInGroup(@RequestBody GroupRequestOrInvite request) {
        return groupService.inviteMemberToGroup(request);
    }

    @PostMapping("/add/member")
    public ResponseResult addMemberToGroup(@RequestBody AddGroupMemberRequest request) {
        return groupService.addUserToGroup(request);
    }

    @PostMapping("/add/post")
    public ResponseResult addGroupPost(@RequestBody CreateGroupPostItem request) {
        return groupService.saveGroupPost(request);
    }

    @PostMapping("/delete/invitation")
    public ResponseResult cancelInvitation(@RequestBody AddGroupMemberRequest request) {
        return groupService.deleteInvitation(request);
    }

    @GetMapping("/member")
    public ResponseResult getAllMembersOfGroup(@RequestParam("groupId") Long groupId) {
        return groupService.getAllMembersOfGroup(groupId);
    }

    @GetMapping("/post/detail")
    public ResponseResult getDetailPost(@RequestParam("postId") String postId,@RequestParam(value = "groupId") Long id) {
        return groupService.getDetailPost(postId,id);
    }

    @GetMapping("/newsfeed")
    public ResponseResult getAllPosts(@RequestParam(value = "pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return groupService.getAllPosts(pageCount, pageNumber - 1);
    }

    @GetMapping("/post")
    public ResponseResult getAllPostsByGroup(@RequestParam(value = "groupId") Long id, @RequestParam(value = "pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return groupService.getAlLDataByGroup(id, pageCount, pageNumber - 1);
    }

    @DeleteMapping("/delete")
    public ResponseResult deletePost(@RequestParam("postId") String postId, @RequestParam("groupId") Long groupId) {
        return groupService.deletePost(postId, groupId);
    }
}
