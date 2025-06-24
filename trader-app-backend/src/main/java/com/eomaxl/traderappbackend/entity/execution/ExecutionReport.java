package com.eomaxl.traderappbackend.entity.execution;

import com.eomaxl.traderappbackend.entity.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "execution_reports" )
public class ExecutionReport {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(unique=true)
    private String executionId;

    @Enumerated(EnumType.STRING)
    private ExecType execType;

    @Column(precision=19, scale=4)
    private BigDecimal quantity;

    @Column(precision=19, scale=4)
    private BigDecimal price;

    @Column(precision=19, scale=4)
    private BigDecimal cumQty;

    @Column(precision=19, scale=4)
    private BigDecimal leavesQty;

    private Instant transactionTime;
    private String message;
    private String externalExecId;
}
