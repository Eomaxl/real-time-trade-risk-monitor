package com.eomaxl.traderappbackend.entity.market;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketDataSnapshot {
    private Long id;
    private Instrument instrument;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal lastPrice;
    private BigDecimal volume;
    private Timestamp timestamp;
}
