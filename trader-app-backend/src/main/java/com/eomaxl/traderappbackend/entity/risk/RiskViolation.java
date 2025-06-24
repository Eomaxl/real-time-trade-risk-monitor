package com.eomaxl.traderappbackend.entity.risk;

import com.eomaxl.traderappbackend.entity.auth.User;
import com.eomaxl.traderappbackend.entity.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiskViolation {
    private Long id;
    private User user;
    private Order order;
    private RiskRule rule;
    private VIOLATION_TYPE violationType;
    private String details;
    private Timestamp timestamp;
}

enum VIOLATION_TYPE{
    LIMIT_BREACH, RESTRICTED_SYMBOL
}
