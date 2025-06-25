package com.eomaxl.traderappbackend.service;

import com.eomaxl.traderappbackend.entity.execution.ExecutionReport;
import com.eomaxl.traderappbackend.entity.order.Order;

public interface NotificationService {
    void notifyOrderUpdate(Order order, ExecutionReport report);
    List<NotificationDto> getUserNotifications(String username);
    void markAsRead(Long id, String username);
}
