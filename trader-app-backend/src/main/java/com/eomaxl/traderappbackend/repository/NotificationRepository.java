package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {}
