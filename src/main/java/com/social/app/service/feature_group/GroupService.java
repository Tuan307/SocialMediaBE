package com.social.app.service.feature_group;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.feature_group.*;
import com.social.app.model.feature_group.request.*;
import com.social.app.model.feature_notification.NotificationModel;
import com.social.app.model.feature_user.User;
import com.social.app.repository.feature_group.GroupInvitationRepository;
import com.social.app.repository.feature_group.GroupMemberRepository;
import com.social.app.repository.feature_group.GroupModelRepository;
import com.social.app.repository.feature_group.GroupPostItemRepository;
import com.social.app.repository.feature_notification.NotificationRepository;
import com.social.app.repository.feature_user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static com.social.app.common.CommonUtils.GROUP_EXIST_ERROR_RESPONSE;
import static com.social.app.common.CommonUtils.SUCCESSFULLY_RESPONSE;

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
    @Autowired
    private NotificationRepository notificationRepository;

    public ResponseResult checkIfRequestToJoinGroup(String userId, Long groupId) {
        Optional<GroupMemberModel> checkIfJoined = groupMemberRepository.findGroupByUserIdAndGroupId(userId, groupId);
        if (checkIfJoined.isPresent()) {
            return new ResponseResult(new Status(200, "Successfully"), 2);
        } else {
            Optional<GroupInvitationModel> checkExist = groupInvitationRepository.findInvitationByFromUserIdAndGroupId(userId, groupId, "request");
            if (checkExist.isPresent()) {
                return new ResponseResult(new Status(200, "Successfully"), 1);
            } else {
                return new ResponseResult(new Status(200, "Successfully"), 0);
            }
        }
    }

    public ResponseResult removeGroupRequest(String userId, Long groupId) {
        Optional<GroupInvitationModel> checkExist = groupInvitationRepository.findInvitationByFromUserIdAndGroupId(userId, groupId, "request");
        if (checkExist.isPresent()) {
            groupInvitationRepository.deleteById(checkExist.get().getId());
            return new ResponseResult(new Status(200, "Successfully"), true);
        } else {
            return new ResponseResult(new Status(200, "Không tìm thấy yêu cầu"), false);
        }
    }

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
        Optional<User> fromUserInvited = userRepository.findUserByUserId(requestOrInvite.getFromInvitedUserId());
        Optional<GroupModel> groupModel = groupModelRepository.findById(requestOrInvite.getGroupId());
        if (groupModel.isPresent() && user.isPresent()) {
            GroupInvitationModel groupInvitationModel = new GroupInvitationModel();
            groupInvitationModel.setGroupId(groupModel.get());
            groupInvitationModel.setMessage(requestOrInvite.getMessage());
            groupInvitationModel.setCreatedAt(requestOrInvite.getCreatedAt());
            groupInvitationModel.setType(requestOrInvite.getType());
            groupInvitationModel.setFromInvitedUserId(fromUserInvited.get());
            groupInvitationModel.setRequestUserId(user.get());
            var result = groupInvitationRepository.save(groupInvitationModel);
            //notification
            boolean isRequest;
            if (requestOrInvite.getType().equals("invite")) {
                isRequest = true;
            } else {
                isRequest = false;
            }
            Optional<NotificationModel> model = notificationRepository.findNotificationModel(requestOrInvite.getUserId(), fromUserInvited.get().getUserId(), true);
            NotificationModel notificationModel;
            if (model.isEmpty()) {
                notificationModel = new NotificationModel();
            } else {
                notificationModel = model.get();
            }
            notificationModel.setNotificationGroupId(groupModel.get());
            notificationModel.setText(requestOrInvite.getMessage());
            notificationModel.setNotificationTimeStamp(requestOrInvite.getCreatedAt());
            if (requestOrInvite.getType().equals("invite")) {
                notificationModel.setIsInvitation(true);
            } else {
                notificationModel.setIsRequest(true);
            }
            notificationModel.setNotificationUserId(fromUserInvited.get());
            notificationModel.setNotificationOwnerId(requestOrInvite.getUserId());
            notificationRepository.save(notificationModel);
            return new ResponseResult(new Status(200, "Successfully"), result);
        } else {
            return new ResponseResult(new Status(200, "Đã có lỗi xảy ra"), null);
        }
    }

    public ResponseResult getAllGroupByOwner(String userId, int pageCount, int pageNumber) {
        return new ResponseResult(new Status(200, "Successfully"), groupModelRepository.findGroupByOwnerId(userId, PageRequest.of(pageNumber, pageCount)));
    }

    public ResponseResult searchGroup(String groupName, int pageCount, int pageNumber) {
        return new ResponseResult(new Status(200, "Successfully"), groupModelRepository.findGroupByName(groupName, PageRequest.of(pageNumber, pageCount)));
    }

    public ResponseResult getGroupById(Long groupId) {
        Optional<GroupModel> groupModel = groupModelRepository.findById(groupId);
        return groupModel.map(model -> new ResponseResult(new Status(200, SUCCESSFULLY_RESPONSE), model)).orElseGet(() -> new ResponseResult(new Status(200, GROUP_EXIST_ERROR_RESPONSE), null));
    }

    public ResponseResult getAllGroup(String userId, int pageCount, int page) {
        Page<GroupModel> getAllGroup = groupModelRepository.findAll(PageRequest.of(page, pageCount));
        List<GroupModel> resultList = new ArrayList<>();
        System.out.println(getAllGroup.getContent().size());
        for (GroupModel i : getAllGroup.getContent()) {
            Optional<GroupMemberModel> user = groupMemberRepository.findGroupByUserIdAndGroupId(userId, i.getId());
            Optional<GroupInvitationModel> requestUser = groupInvitationRepository.findInvitationByFromUserIdAndGroupId(userId, i.getId(), "request");
            if (user.isEmpty() && requestUser.isEmpty()) {
                resultList.add(i);
            }
        }
        System.out.println(resultList.toString());
        return new ResponseResult(new Status(200, "Successfully"), resultList);
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
        return new ResponseResult(new Status(200, "Successfully"), groupMemberRepository.findGroupByUserId(userId, "member", PageRequest.of(pageNumber, pageCount)));
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

    public ResponseResult addAdminUserToGroup(AddGroupMemberRequest addGroupMemberRequest) {
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
                model.setType("admin");
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
        post.setGroupPostImagesList(new ArrayList<>());
        if (request.getType().equals("image")) {
            for (int i = 0; i < request.getImagesList().size(); i++) {
                GroupPostImages contentItem = new GroupPostImages(null, request.getImagesList().get(i), new GroupPostItem(request.getId()));
                post.getGroupPostImagesList().add(contentItem);
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
            List<GroupPostImages> posts = post.get().getGroupPostImagesList();
            for (Iterator<GroupPostImages> iterator = posts.iterator(); iterator.hasNext(); ) {
                GroupPostImages post1 = iterator.next();
                post1.setGroupPostItem(null);
                iterator.remove(); //remove the child first
            }
            groupPostItemRepository.deleteById(postId);
            return new ResponseResult(new Status(200, "Successfully"), null);
        } else {
            return new ResponseResult(new Status(200, "Post does not exist"), null);
        }
    }

    public ResponseResult deleteGroup(Long groupId) {
        Optional<GroupModel> groupModel = groupModelRepository.findById(groupId);
        if (groupModel.isPresent()) {
            List<GroupMemberModel> posts = groupModel.get().getGroupMemberModels();
            for (Iterator<GroupMemberModel> iterator = posts.iterator(); iterator.hasNext(); ) {
                GroupMemberModel post = iterator.next();
                post.setGroupMemberUserId(null);
                iterator.remove(); //remove the child first
            }
            List<GroupPostItem> posts1 = groupModel.get().getGroupPostItemList();
            for (Iterator<GroupPostItem> iterator = posts1.iterator(); iterator.hasNext(); ) {
                GroupPostItem post = iterator.next();
                post.setGroupPostModelId(null);
                iterator.remove(); //remove the child first
            }

            List<GroupInvitationModel> posts2 = groupModel.get().getGroupInvitationModelList();
            for (Iterator<GroupInvitationModel> iterator = posts2.iterator(); iterator.hasNext(); ) {
                GroupInvitationModel post = iterator.next();
                post.setGroupId(null);
                iterator.remove(); //remove the child first
            }
            groupModelRepository.deleteById(groupModel.get().getId());
            return new ResponseResult(new Status(200, "Successfully"), null);
        } else {
            return new ResponseResult(new Status(300, "Group does not exist"), null);
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

    public ResponseResult getAllRequestInGroup(Long groupId) {
        List<GroupInvitationModel> list = groupInvitationRepository.findInvitationByGroupId(groupId);
        return new ResponseResult(new Status(200, "Successfully"), list);
    }

    public ResponseResult updateDetailGroup(Long groupId, UpdateGroupRequest request) {
        Optional<GroupModel> groupModel = groupModelRepository.findById(groupId);
        if (groupModel.isPresent()) {
            GroupModel updateGroup = groupModel.get();
            if (!request.getGroupName().equals("")) {
                updateGroup.setGroupName(request.getGroupName());
            }
            if (!request.getGroupImage().equals("")) {
                updateGroup.setGroupImageUrl(request.getGroupImage());
            }
            if (!request.getGroupDescription().equals("")) {
                updateGroup.setGroupDescription(request.getGroupDescription());
            }
            if (!request.getPrivacy().equals("")) {
                updateGroup.setGroupPrivacy(request.getPrivacy());
            }
            return new ResponseResult(new Status(200, SUCCESSFULLY_RESPONSE), groupModelRepository.save(updateGroup));
        } else {
            return new ResponseResult(new Status(200, GROUP_EXIST_ERROR_RESPONSE), null);
        }
    }
}
