package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.service.RiskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiskServiceImpl implements RiskService {
    private final RiskRuleRepository ruleRepo;
    private final RiskViolationRepository violationRepo;

    public void preTradeRiskCheck(PlaceOrderRequest req, User user) {
        // Evaluate rules, throw if violation, log if necessary
    }
    public List<RiskViolationDto> getViolations(String username) {
        // Lookup by user
        return violationRepo.findByUser_Username(username)
                .stream().map(RiskViolationDto::from).toList();
    }
}
