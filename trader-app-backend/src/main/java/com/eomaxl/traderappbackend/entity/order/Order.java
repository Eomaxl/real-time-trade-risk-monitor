package com.eomaxl.traderappbackend.entity.order;

import com.eomaxl.traderappbackend.entity.auth.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import quickfix.field.Side;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private UUID id;
    private String orderId;
    private User user;
    private String symbol;
    private SIDE side;
    private Type type;
    private BigDecimal quantity;
    private BigDecimal price;
    private TimeInForce timeInForce;
    private Status status;
    private Timestamp placedAt;
    private Timestamp updatedAt;
    private Timestamp filledAt;
    private String externalOrderId;
    private String clientIP;
    private String source;
}

enum SIDE {
    BUY, SELL
}

enum Type {
    MARKET, LIMIT, STOP
}

enum TimeInForce {
    GTC,
    FOK,
    IOC
}

enum Status {
    PENDING,
    NEW,
    REJECTED,
    FILLED,
    PARTIALLY_FILLED,
    CANCELLED
}