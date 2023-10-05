package com.social.app.controller.feature_notification;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.feature_notification.NotificationItemRequest;
import com.social.app.service.feature_notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/add")
    public ResponseResult addNotification(@RequestBody NotificationItemRequest notificationItemRequest) {
        return notificationService.addNotificationItem(notificationItemRequest);
    }

    @GetMapping("")
    public ResponseResult getAllNotification(@RequestParam("ownerId") String ownerId, @RequestParam(value = "pageCount") int pageCount, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return notificationService.getAllNotificationItem(ownerId, pageCount, pageNumber - 1);
    }
}
