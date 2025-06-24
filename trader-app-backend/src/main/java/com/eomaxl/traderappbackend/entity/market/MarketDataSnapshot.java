package com.eomaxl.traderappbackend.entity.market;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "market_data_snapshots")
public class MarketDataSnapshot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "instrument_id")
    private Instrument instrument;

    @Column(precision = 19, scale = 4)
    private BigDecimal bid;
    @Column(precision = 19, scale = 4)
    private BigDecimal ask;
    @Column(precision = 19, scale = 4)
    private BigDecimal lastPrice;
    @Column(precision = 19, scale = 4)
    private BigDecimal volume;
    private Timestamp timestamp;
}
