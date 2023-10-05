package com.social.app.service.feature_notification;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.feature_authentication.User;
import com.social.app.model.feature_notification.NotificationItemRequest;
import com.social.app.model.feature_notification.NotificationModel;
import com.social.app.repository.feature_authentication.UserRepository;
import com.social.app.repository.feature_notification.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseResult getAllNotificationItem(String ownerId, int pageCount, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageCount, Sort.by(Sort.Direction.DESC, "notificationTimeStamp"));
        return new ResponseResult(new Status(200, "Successfully"), notificationRepository.findNotificationModelByOwnerId(ownerId, pageable));
    }

    public ResponseResult addNotificationItem(NotificationItemRequest request) {
        Optional<User> user = userRepository.findUserByUserId(request.getUserId());
        if (user.isPresent()) {
            NotificationModel notificationModel = new NotificationModel();
            notificationModel.setIsPost(request.getIsPost());
            notificationModel.setIsInvitation(request.getIsInvitation());
            notificationModel.setText(request.getText());
            notificationModel.setNotificationTimeStamp(request.getTimeStamp());
            notificationModel.setNotificationPostId(request.getPostId());
            notificationModel.setNotificationOwnerId(request.getOwnerId());
            notificationModel.setNotificationUserId(user.get());
            NotificationModel result = notificationRepository.save(notificationModel);
            return new ResponseResult(new Status(200, "Successfully"), result);
        } else {
            return new ResponseResult(new Status(200, "UnSuccessfully"), null);
        }
    }
}

