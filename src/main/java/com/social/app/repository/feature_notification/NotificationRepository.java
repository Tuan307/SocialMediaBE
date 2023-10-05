package com.social.app.repository.feature_notification;

import com.social.app.model.feature_notification.NotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
    @Query(value = "SELECT n FROM NotificationModel n WHERE n.notificationOwnerId = ?1")
    Page<NotificationModel> findNotificationModelByOwnerId(String notificationOwnerId, Pageable pageable);
}
