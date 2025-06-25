package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.entity.execution.ExecutionReport;
import com.eomaxl.traderappbackend.entity.order.Order;
import com.eomaxl.traderappbackend.repository.ExecutionRepository;
import com.eomaxl.traderappbackend.repository.OrderRepository;
import com.eomaxl.traderappbackend.service.ExecutionService;
import com.eomaxl.traderappbackend.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExecutionServiceImpl implements ExecutionService {
    private final ExecutionRepository executionRepository;
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    @Async
    public void submitOrder(Order order){

    }

    public void receiveExecutionReport(ExecutionReportRequest req){
        Order order = orderRepository.findByOrderId(req.getOrderId()).orElseThrow();
        ExecutionReport executionReport = new ExecutionReport();
        executionRepository.save(executionReport);
        order.setStatus(req.getOrderStatus());
        orderRepository.save(order);
        notificationService.notifyOrderUpdate(order,executionReport);
    }

    public List<ExecutionReport> findByOrder(UUID orderId, String username) {
        return executionRepository.findByOrder(orderId).stream().map(ExecutionReport::from).toList();
    }
}
