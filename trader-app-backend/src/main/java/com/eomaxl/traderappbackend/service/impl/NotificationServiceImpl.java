package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.entity.execution.ExecutionReport;
import com.eomaxl.traderappbackend.entity.notification.Notification;
import com.eomaxl.traderappbackend.entity.notification.NotificationStatus;
import com.eomaxl.traderappbackend.entity.order.Order;
import com.eomaxl.traderappbackend.repository.NotificationRepository;
import com.eomaxl.traderappbackend.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repo;

    @Async
    public void notifyOrderUpdate(Order order, ExecutionReport report) {
        // Push notification via WebSocket or save in DB
    }
    public List<NotificationDto> getUserNotifications(String username) {
        return repo.findByUser_Username(username).stream().map(NotificationDto::from).toList();
    }
    public void markAsRead(Long id, String username) {
        Notification notif = repo.findById(id).orElseThrow();
        notif.setStatus(NotificationStatus.READ);
        repo.save(notif);
    }
}
