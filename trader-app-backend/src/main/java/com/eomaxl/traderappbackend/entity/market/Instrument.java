package com.eomaxl.traderappbackend.entity.market;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instrument {
    private Long id;
    private String symbol;
    private String name;
    private String exchange;
    private BigDecimal tickSize;
    private String currency;
    private boolean active;
}
