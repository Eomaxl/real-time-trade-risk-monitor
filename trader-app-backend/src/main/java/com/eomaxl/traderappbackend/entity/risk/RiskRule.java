package com.eomaxl.traderappbackend.entity.risk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RiskRule {
    private Long id;
    private String name;
    private String description;
    private RULE_TYPE ruleType;
    private JSON parameters;
    private boolean active;
}

enum RULE_TYPE{
    PRE_TRADE,POST_TRADE
}
