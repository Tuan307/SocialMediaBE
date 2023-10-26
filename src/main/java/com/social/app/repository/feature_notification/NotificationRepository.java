package com.social.app.repository.feature_notification;

import com.social.app.model.feature_notification.NotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
    @Query(value = "SELECT n FROM NotificationModel n WHERE n.notificationOwnerId = ?1")
    Page<NotificationModel> findNotificationModelByOwnerId(String notificationOwnerId, Pageable pageable);

    @Query(value = "SELECT n FROM NotificationModel n WHERE n.notificationOwnerId = ?1 AND n.notificationUserId.userId = ?2 AND n.isRequest = ?3")
    Optional<NotificationModel> findNotificationModel(String notificationOwnerId, String notificationUserId, Boolean isRequest);
}
