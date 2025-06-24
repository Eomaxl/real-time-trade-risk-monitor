package com.eomaxl.traderappbackend.entity.order;

import com.eomaxl.traderappbackend.entity.auth.User;
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
@Table( name = "order_audit")
public class OrderAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    private OrderAuditAction action;

    @Lob
    private String before;

    @Lob
    private String after;

    private Instant timestamp;

    @ManyToOne
    @JoinColumn(name = "performed_by")
    private User performedBy;
}
