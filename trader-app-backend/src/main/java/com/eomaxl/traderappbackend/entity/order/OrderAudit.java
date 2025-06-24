package com.eomaxl.traderappbackend.entity.order;

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
public class OrderAudit {
    private Long id;
    private Order order;
    private Optional<JSON> before;
    private JSON after;
    private Timestamp timestamp;
    private User performedBy;
}
