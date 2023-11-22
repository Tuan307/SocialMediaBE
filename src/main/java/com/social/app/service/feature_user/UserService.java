package com.social.app.service.feature_user;

import com.social.app.common.CommonUtils;
import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.feature_group.GroupInvitationModel;
import com.social.app.model.feature_group.GroupMemberModel;
import com.social.app.model.feature_group.GroupModel;
import com.social.app.model.feature_group.GroupPostItem;
import com.social.app.model.feature_notification.NotificationModel;
import com.social.app.model.feature_post_image.PostItem;
import com.social.app.model.feature_post_image.SavedPostItem;
import com.social.app.model.feature_user.TourInterest;
import com.social.app.model.feature_user.UpdateUserRequest;
import com.social.app.model.feature_user.User;
import com.social.app.model.feature_user.UserInterestProfile;
import com.social.app.model.feature_user.request.UpdateBlockRequest;
import com.social.app.model.feature_user.request.UpdateLastOnlineRequest;
import com.social.app.model.feature_user.request.UserInterestRequest;
import com.social.app.repository.feature_group.GroupInvitationRepository;
import com.social.app.repository.feature_group.GroupMemberRepository;
import com.social.app.repository.feature_group.GroupModelRepository;
import com.social.app.repository.feature_group.GroupPostItemRepository;
import com.social.app.repository.feature_notification.NotificationRepository;
import com.social.app.repository.feature_post_image.PostRepository;
import com.social.app.repository.feature_post_image.SavedPostRepository;
import com.social.app.repository.feature_user.TourInterestRepository;
import com.social.app.repository.feature_user.UserRepository;
import com.social.app.repository.feature_user.UserTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SavedPostRepository savedPostRepository;
    @Autowired
    private TourInterestRepository interestRepository;
    @Autowired
    private UserTourRepository userTourRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private GroupPostItemRepository groupPostItemRepository;
    @Autowired
    private GroupModelRepository groupModelRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;
    @Autowired
    private GroupInvitationRepository groupInvitationRepository;

    public List<User> findNearestUsers(String yourUserId, double yourLat, double yourLng, long limit) {
        List<User> list = repository.findNearestUsers(yourLat, yourLng, limit);
        for (User u : list) {
            if (u.getUserId().equals(yourUserId)) {
                list.remove(u);
                break;
            }
        }
        return list;
    }

    public ResponseResult getUserProfile(String id) {
        Optional<User> user = repository.findUserByUserId(id);
        if (user.isPresent()) {
            return new ResponseResult(new Status(200, "Successfully"), user);
        } else {
            return new ResponseResult(new Status(200, "Can not find user"), null);
        }
    }

    public ResponseResult updateUserProfile(UpdateUserRequest request) {
        Optional<User> user = repository.findUserByUserId(request.getUserId());
        if (user.isPresent()) {
            User model = user.get();
            if (!request.getBio().equals("")) {
                model.setBio(request.getBio());
            }
            if (!request.getUserName().equals("")) {
                model.setUserName(request.getUserName());
            }
            if (!request.getFullName().equals("")) {
                model.setFullName(request.getFullName());
            }
            if (request.getLatitude() != null) {
                model.setLatitude(request.getLatitude());
            }
            if (request.getLongitude() != null) {
                model.setLongitude(request.getLongitude());
            }
            if (!request.getImageUrl().equals("")) {
                model.setImageUrl(request.getImageUrl());
            }
            return new ResponseResult(new Status(200, "Successfully"), repository.save(model));
        } else {
            return new ResponseResult(new Status(200, CommonUtils.USER_EXIST_ERROR_RESPONSE), null);
        }
    }

    public ResponseResult registerUser(User user) {
        Optional<User> checkExistence = repository.findUserByUserId(user.getUserId());
        if (checkExistence.isPresent()) {
            return new ResponseResult(new Status(200, "User has been already registered"), null);
        } else {
            repository.save(user);
            return new ResponseResult(new Status(200, "Successfully"), user);
        }
    }

    public ResponseResult getAllUsers(int pageCount, int pageNumber) {
        Page<User> users = repository.findAll(PageRequest.of(pageNumber, pageCount));
        return new ResponseResult(new Status(HttpStatus.OK.value(), "Successfully"), users, pageCount, pageNumber + 1);
    }

    public ResponseResult deleteUser(String userId) {
        Optional<User> user = repository.findUserByUserId(userId);
        if (user.isPresent()) {
            List<SavedPostItem> posts = user.get().getSavedPostItems();
            for (Iterator<SavedPostItem> iterator = posts.iterator(); iterator.hasNext(); ) {
                SavedPostItem post = iterator.next();
                post.setUser_saved_id(null);
                iterator.remove(); //remove the child first
            }
            List<PostItem> postItems = user.get().getPostItemList();
            for (Iterator<PostItem> iterator = postItems.iterator(); iterator.hasNext(); ) {
                PostItem post = iterator.next();
                post.setPostUserId(null);
                iterator.remove(); //remove the child first
            }

            List<GroupPostItem> groupPostItems = user.get().getGroupPostItemList();
            for (Iterator<GroupPostItem> iterator = groupPostItems.iterator(); iterator.hasNext(); ) {
                GroupPostItem post = iterator.next();
                post.setGroupPostUserId(null);
                iterator.remove(); //remove the child first
            }
            List<NotificationModel> notificationModels = user.get().getNotificationModelList();
            for (Iterator<NotificationModel> iterator = notificationModels.iterator(); iterator.hasNext(); ) {
                NotificationModel post = iterator.next();
                post.setNotificationUserId(null);
                iterator.remove(); //remove the child first
            }

            List<GroupModel> groupModels = user.get().getGroupModelOwner();
            for (Iterator<GroupModel> iterator = groupModels.iterator(); iterator.hasNext(); ) {
                GroupModel post = iterator.next();
                post.setGroupOwner(null);
                iterator.remove(); //remove the child first
            }
            List<GroupMemberModel> groupMemberModels = user.get().getGroupMemberModelList();
            for (Iterator<GroupMemberModel> iterator = groupMemberModels.iterator(); iterator.hasNext(); ) {
                GroupMemberModel post = iterator.next();
                post.setGroupMemberUserId(null);
                iterator.remove(); //remove the child first
            }
            List<GroupInvitationModel> groupInvitationModelList = user.get().getGroupInvitationModelList();
            for (Iterator<GroupInvitationModel> iterator = groupInvitationModelList.iterator(); iterator.hasNext(); ) {
                GroupInvitationModel post = iterator.next();
                post.setRequestUserId(null);
                iterator.remove(); //remove the child first
            }
            List<GroupInvitationModel> groupInvitationMadeModelList = user.get().getGroupInvitationMadeModelList();
            for (Iterator<GroupInvitationModel> iterator = groupInvitationMadeModelList.iterator(); iterator.hasNext(); ) {
                GroupInvitationModel post = iterator.next();
                post.setFromInvitedUserId(null);
                iterator.remove(); //remove the child first
            }
            List<UserInterestProfile> userInterestProfiles = user.get().getUserInterestProfiles();
            for (Iterator<UserInterestProfile> iterator = userInterestProfiles.iterator(); iterator.hasNext(); ) {
                UserInterestProfile post = iterator.next();
                post.setUserInterest(null);
                iterator.remove(); //remove the child first
            }

            repository.deleteUserByUserId(user.get().getUserId());
            return new ResponseResult(new Status(HttpStatus.OK.value(), CommonUtils.SUCCESSFULLY_RESPONSE), null);
        } else {
            return new ResponseResult(new Status(HttpStatus.OK.value(), CommonUtils.USER_EXIST_ERROR_RESPONSE), null);
        }
    }

    public ResponseResult blockUser(String userId, UpdateBlockRequest request) {
        Optional<User> user = repository.findUserByUserId(userId);
        if (user.isPresent()) {
            User model = user.get();
            model.setIsBlock(request.isBlockUser());
            return new ResponseResult(new Status(HttpStatus.OK.value(), CommonUtils.SUCCESSFULLY_RESPONSE), repository.save(model));
        } else {
            return new ResponseResult(new Status(HttpStatus.OK.value(), CommonUtils.USER_EXIST_ERROR_RESPONSE), null);
        }
    }

    public ResponseResult searchUser(String keyword, int pageNumber, int pageCount) {
        List<User> list = repository.searchUserByUserName(keyword, PageRequest.of(pageNumber, pageCount));
        return new ResponseResult(new Status(200, "Successfully"), list);
    }

    public ResponseResult getAllInterests() {
        return new ResponseResult(new Status(200, "Successfully"), interestRepository.findAll());
    }

    public ResponseResult saveUserInterest(UserInterestRequest request) {
        for (int i = 0; i < request.getInterests().size(); i++) {
            TourInterest tour = request.getInterests().get(i);
            UserInterestProfile userInterestProfile = new UserInterestProfile(0L, new User(request.getUserId()), tour);
            userTourRepository.save(userInterestProfile);
        }
        return new ResponseResult(new Status(200, "Successfully"), userTourRepository.findByUserId(request.getUserId()));
    }

    public ResponseResult updateUserInterest(UserInterestRequest request) {
        userTourRepository.deleteInterestByUserId(request.getUserId());
        for (int i = 0; i < request.getInterests().size(); i++) {
            TourInterest tour = request.getInterests().get(i);
            UserInterestProfile userInterestProfile = new UserInterestProfile(0L, new User(request.getUserId()), tour);
            userTourRepository.save(userInterestProfile);
        }
        return new ResponseResult(new Status(200, "Successfully"), userTourRepository.findByUserId(request.getUserId()));
    }

    public ResponseResult checkIfUserHasInterest(String userId) {
        List<UserInterestProfile> list = userTourRepository.findByUserId(userId);
        if (list.isEmpty()) {
            return new ResponseResult(new Status(200, "Successfully"), false);
        } else {
            return new ResponseResult(new Status(200, "Successfully"), true);
        }
    }

    public ResponseResult updateUserLastOnline(UpdateLastOnlineRequest request, String userId) {
        Optional<User> user = repository.findUserByUserId(userId);
        if (user.isPresent()) {
            User model = user.get();
            if (!request.getLastOnline().equals("")) {
                model.setLastOnline(request.getLastOnline());
            }
            return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), repository.save(model));
        } else {
            return new ResponseResult(new Status(200, CommonUtils.USER_EXIST_ERROR_RESPONSE), null);
        }
    }
}
