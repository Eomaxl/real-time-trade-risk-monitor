package com.eomaxl.traderappbackend.service;

public interface RiskService {
    void preTradeRiskCheck(PlaceOrderRequest req, User user);
    List<RiskViolationDto> getViolations(String username);
}
