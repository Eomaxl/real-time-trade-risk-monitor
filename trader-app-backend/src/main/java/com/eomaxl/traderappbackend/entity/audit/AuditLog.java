package com.eomaxl.traderappbackend.entity.audit;

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
public class AuditLog {
    private Long id;
    private User user;
    private String action;
    private String entityType;
    private String entityId;
    private String details;
    private Timestamp timestamp;
}
