package com.social.app.service.feature_authentication;

import com.social.app.model.ResponseResult;
import com.social.app.model.Status;
import com.social.app.model.feature_authentication.User;
import com.social.app.repository.feature_authentication.UserRepository;
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

    public ResponseResult getUserProfile(String id) {
        Optional<User> user = repository.findUserByUserId(id);
        if (user.isPresent()) {
            return new ResponseResult(new Status(200, "Successfully"), user);
        } else {
            return new ResponseResult(new Status(200, "Can not find user"), null);
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

    public ResponseResult searchUser(String keyword, int pageCount, int pageNumber) {
        Optional<List<User>> list = repository.findByUserNameContaining(keyword, PageRequest.of(pageNumber, pageCount));
        return new ResponseResult(new Status(200, "Successfully"), list);
    }

}
