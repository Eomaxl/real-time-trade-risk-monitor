package com.eomaxl.traderappbackend.entity.risk;

import com.eomaxl.traderappbackend.entity.auth.User;
import com.eomaxl.traderappbackend.entity.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "risk_violations")
public class RiskViolation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private RiskRule rule;

    @Enumerated(EnumType.STRING)
    private ViolationType  violationType;

    @Lob
    private String details;
    private Instant timestamp;
}
