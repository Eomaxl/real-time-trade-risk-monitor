package com.eomaxl.traderappbackend.entity.market;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "instruments")
public class Instrument {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String symbol;

    private String name;
    private String exchange;

    @Column(precision = 19, scale = 4)
    private BigDecimal tickSize;

    private String currency;
    private boolean active;
}
