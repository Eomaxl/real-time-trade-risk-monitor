package com.eomaxl.traderappbackend.service;

import com.eomaxl.traderappbackend.entity.execution.ExecutionReport;
import com.eomaxl.traderappbackend.entity.order.Order;

import java.util.UUID;

public interface ExecutionService {
    void submitOrder(Order order);
    void receiveExecutionReport(ExecutionReportRequest req);
    List<ExecutionReportDto> findByOrder(UUID orderId, String username);
}
