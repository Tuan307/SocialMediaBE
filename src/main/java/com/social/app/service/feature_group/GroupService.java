package com.social.app.service.feature_group;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.feature_authentication.User;
import com.social.app.model.feature_group.*;
import com.social.app.model.feature_group.request.AddGroupMemberRequest;
import com.social.app.model.feature_group.request.CreateGroupPostItem;
import com.social.app.model.feature_group.request.CreateGroupRequest;
import com.social.app.model.feature_group.request.GroupRequestOrInvite;
import com.social.app.repository.feature_authentication.UserRepository;
import com.social.app.repository.feature_group.GroupInvitationRepository;
import com.social.app.repository.feature_group.GroupMemberRepository;
import com.social.app.repository.feature_group.GroupModelRepository;
import com.social.app.repository.feature_group.GroupPostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupModelRepository groupModelRepository;
    @Autowired
    private GroupInvitationRepository groupInvitationRepository;
    @Autowired
    private GroupPostItemRepository groupPostItemRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseResult createGroup(CreateGroupRequest createGroupRequest) {
        Optional<User> user = userRepository.findUserByUserId(createGroupRequest.getUserId());
        if (user.isPresent()) {
            GroupModel groupModel = new GroupModel();
            groupModel.setGroupCreatedAt(createGroupRequest.getGroupCreatedAt());
            groupModel.setGroupDescription(createGroupRequest.getGroupDescription());
            groupModel.setGroupName(createGroupRequest.getGroupName());
            groupModel.setGroupOwner(user.get());
            groupModel.setGroupPrivacy(createGroupRequest.getPrivacy());
            groupModel.setGroupImageUrl(createGroupRequest.getGroupImage());
            return new ResponseResult(new Status(200, "Successfully"), groupModelRepository.save(groupModel));
        } else {
            return new ResponseResult(new Status(200, "Đã có lỗi xảy ra"), null);
        }
    }

    public ResponseResult inviteMemberToGroup(GroupRequestOrInvite requestOrInvite) {
        Optional<User> user = userRepository.findUserByUserId(requestOrInvite.getUserId());
        Optional<GroupModel> groupModel = groupModelRepository.findById(requestOrInvite.getGroupId());
        if (groupModel.isPresent() && user.isPresent()) {
            GroupInvitationModel groupInvitationModel = new GroupInvitationModel();
            groupInvitationModel.setGroupId(groupModel.get());
            groupInvitationModel.setCreatedAt(requestOrInvite.getCreatedAt());
            groupInvitationModel.setType(requestOrInvite.getType());
            groupInvitationModel.setRequestUserId(user.get());
            return new ResponseResult(new Status(200, "Successfully"), groupInvitationRepository.save(groupInvitationModel));
        } else {
            return new ResponseResult(new Status(200, "Đã có lỗi xảy ra"), null);
        }
    }

    public ResponseResult getAllGroupByOwner(String userId, int pageCount, int pageNumber) {
        return new ResponseResult(new Status(200, "Successfully"), groupModelRepository.findGroupByOwnerId(userId, PageRequest.of(pageNumber, pageCount)));
    }

    public ResponseResult getGroupById(Long groupId) {
        return new ResponseResult(new Status(200, "Successfully"), groupModelRepository.findById(groupId).get());
    }

    public ResponseResult getAllGroupInvitation(String userId, String type) {
        return new ResponseResult(new Status(200, "Successfully"), groupInvitationRepository.findInvitationByUserId(userId, type));
    }

    public ResponseResult getAllMembersOfGroup(Long id) {
        return new ResponseResult(new Status(200, "Successfully"), groupMemberRepository.findMembersByGroupId(id).get());
    }

    public ResponseResult searchAllMembersOfGroup(Long id, String keyword) {
        return new ResponseResult(new Status(200, "Successfully"), groupMemberRepository.searchMemberByName(id, keyword));
    }

    public ResponseResult getAllGroupByUserId(String userId, int pageNumber, int pageCount) {
        return new ResponseResult(new Status(200, "Successfully"), groupMemberRepository.findGroupByUserId(userId, PageRequest.of(pageNumber, pageCount)));
    }

    public ResponseResult deleteInvitation(AddGroupMemberRequest request) {
        Optional<GroupInvitationModel> checkInvitation = groupInvitationRepository.findInvitationByUserIdAndGroupId(request.getUserId(), request.getGroupId());
        if (checkInvitation.isPresent()) {
            groupInvitationRepository.deleteById(checkInvitation.get().getId());
            return new ResponseResult(new Status(200, "Successfully"), null);
        } else {
            return new ResponseResult(new Status(200, "Đã có lỗi xảy ra, vui lòng thử lại sau"), null);
        }
    }

    public ResponseResult checkIfJoinedGroup(String userId, Long groupId) {
        Optional<GroupMemberModel> checkUserExistence = groupMemberRepository.findGroupByUserIdAndGroupId(userId, groupId);
        return checkUserExistence.map(groupMemberModel -> new ResponseResult(new Status(200, "Successfully"), groupMemberModel)).orElseGet(() -> new ResponseResult(new Status(200, "Tài khoản này không phải là thành viên của nhóm, vui lòng thử lại"), null));
    }

    public ResponseResult removeUserFromGroup(String userId, Long groupId) {
        Optional<GroupMemberModel> checkUserExistence = groupMemberRepository.findGroupByUserIdAndGroupId(userId, groupId);
        if (checkUserExistence.isPresent()) {
            groupMemberRepository.deleteById(checkUserExistence.get().getId());
            return new ResponseResult(new Status(200, "Successfully"), null);
        } else {
            return new ResponseResult(new Status(200, "Tài khoản này không phải là thành viên của nhóm, vui lòng thử lại"), null);
        }
    }

    public ResponseResult addUserToGroup(AddGroupMemberRequest addGroupMemberRequest) {
        Optional<User> user = userRepository.findUserByUserId(addGroupMemberRequest.getUserId());
        Optional<GroupModel> groupModel = groupModelRepository.findById(addGroupMemberRequest.getGroupId());
        if (user.isEmpty()) {
            return new ResponseResult(new Status(200, "Tài khoản của bạn không được tìm thấy trong csdl"), null);
        } else if (groupModel.isEmpty()) {
            return new ResponseResult(new Status(200, "Có vẻ như nhóm mà bạn đang muốn tham gia đã giải tán"), null);
        } else {
            Optional<GroupMemberModel> checkExist = groupMemberRepository.findGroupByUserIdAndGroupId(addGroupMemberRequest.getUserId(), addGroupMemberRequest.getGroupId());
            if (checkExist.isPresent()) {
                return new ResponseResult(new Status(200, "Có vẻ như tài khoản đã là thành viên của nhóm rồi"), null);
            } else {
                GroupMemberModel model = new GroupMemberModel();
                model.setGroupModelId(groupModel.get());
                model.setGroupMemberUserId(user.get());
                model.setType("member");
                Optional<GroupInvitationModel> checkInvitation = groupInvitationRepository.findInvitationByUserIdAndGroupId(addGroupMemberRequest.getUserId(), addGroupMemberRequest.getGroupId());
                checkInvitation.ifPresent(groupInvitationModel -> groupInvitationRepository.deleteById(groupInvitationModel.getId()));
                return new ResponseResult(new Status(200, "Successfully"), groupMemberRepository.save(model));
            }
        }
    }

    //Group Post
    public ResponseResult saveGroupPost(CreateGroupPostItem request) {
        GroupPostItem post = new GroupPostItem();
        post.setGroupPostId(request.getId());
        post.setDescription(request.getDescription());
        post.setGroupPostModelId(groupModelRepository.findById(request.getGroupId()).get());
        post.setGroupPostUserId(userRepository.findUserByUserId(request.getUserId()).get());
        post.setQuestion(request.getQuestion());
        post.setType(request.getType());
        post.setCheckInAddress(request.getCheckInAddress());
        post.setCheckInLatitude(request.getCheckInLatitude());
        post.setCreatedAt(request.getCreatedAt());
        post.setCheckInLongitude(request.getCheckInLongitude());
        post.setVideoUrl(request.getVideoUrl());
        post.setGroupPostContentItemList(new ArrayList<>());
        if (request.getType().equals("image")) {
            for (int i = 0; i < request.getImagesList().size(); i++) {
                GroupPostContentItem contentItem = new GroupPostContentItem(null, request.getImagesList().get(i), new GroupPostItem(request.getId()));
                post.getGroupPostContentItemList().add(contentItem);
            }
        }
        GroupPostItem result = groupPostItemRepository.save(post);
        return new ResponseResult(new Status(200, "Yes"), result);
    }

    public ResponseResult getAlLDataByGroup(Long id, int pageCount, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageCount, Sort.by(Sort.Direction.DESC, "createdAt"));
        return new ResponseResult(new Status(200, "Yes"), groupPostItemRepository.findPostByGroupId(id, pageable));
    }

    public ResponseResult getAllPosts(int pageCount, int pageNumber) {
        Page<GroupPostItem> list = groupPostItemRepository.findAll(PageRequest.of(pageNumber, pageCount).withSort(Sort.by("createdAt").descending()));
        return new ResponseResult(new Status(200, "Successfully"), list, pageCount, pageNumber + 1);
    }

    public ResponseResult deletePost(String postId, Long groupId) {
        Optional<GroupPostItem> post = groupPostItemRepository.findPostByGroupIdAndPostId(groupId, postId);
        if (post.isPresent()) {
            groupPostItemRepository.deleteById(postId);
            return new ResponseResult(new Status(200, "Successfully"), null);
        } else {
            return new ResponseResult(new Status(200, "Post does not exist"), null);
        }
    }

    public ResponseResult getDetailPost(String postId, Long groupId) {
        Optional<GroupPostItem> post = groupPostItemRepository.findPostByGroupIdAndPostId(groupId, postId);
        return post.map(postItem -> new ResponseResult(new Status(200, "Successfully"), postItem)).orElseGet(() -> new ResponseResult(new Status(200, "Post does not exist"), null));
    }

    public ResponseResult searchPostWithDescriptionKeyword(Long groupId, String keyword) {
        List<GroupPostItem> post = groupPostItemRepository.searchPostByDescription(groupId, keyword);
        return new ResponseResult(new Status(200, "Successfully"), post);
    }
}
