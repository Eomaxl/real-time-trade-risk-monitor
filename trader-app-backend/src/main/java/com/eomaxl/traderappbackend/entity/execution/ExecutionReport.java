package com.eomaxl.traderappbackend.entity.execution;

import com.eomaxl.traderappbackend.entity.order.Order;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class ExecutionReport {
    private UUID id;
    private Order order;
    private String executionId;
    private EXEC_TYPE execType;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal cumQty;
    private BigDecimal leavesQty;
    private Timestamp transactionTime;
    private String message;
    private String externalExecId;
}

enum EXEC_TYPE{
    NEW, PARTIAL_FILL, FILL, REJECT, CANCEL
}