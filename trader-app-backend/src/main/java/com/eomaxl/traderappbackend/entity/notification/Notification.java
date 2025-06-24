package com.eomaxl.traderappbackend.entity.notification;

import com.eomaxl.traderappbackend.entity.auth.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private Long id;
    private User user;
    private TYPE type;
    private String content;
    private NOTIFICATION_STATUS status;
    private Timestamp createdAt;
}

enum TYPE {
    ORDER_UPDATE, EXECUTION, RISK_ALERT
}

enum NOTIFICATION_STATUS {
    NEW, READ
}