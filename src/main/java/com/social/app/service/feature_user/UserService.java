package com.social.app.service.feature_user;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.feature_user.TourInterest;
import com.social.app.model.feature_user.UpdateUserRequest;
import com.social.app.model.feature_user.User;
import com.social.app.model.feature_user.UserInterestProfile;
import com.social.app.model.feature_user.request.UserInterestRequest;
import com.social.app.repository.feature_user.TourInterestRepository;
import com.social.app.repository.feature_user.UserRepository;
import com.social.app.repository.feature_user.UserTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private TourInterestRepository interestRepository;
    @Autowired
    private UserTourRepository userTourRepository;

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
            return new ResponseResult(new Status(200, "Không tìm thấy thông tin của người dùng, vui lòng thử lại "), null);
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
}
