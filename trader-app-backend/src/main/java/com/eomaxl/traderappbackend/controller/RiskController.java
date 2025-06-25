package com.eomaxl.traderappbackend.controller;

import com.eomaxl.traderappbackend.service.RiskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/risk")
@RequiredArgsConstructor
public class RiskController {

    private final RiskService riskService;

    @GetMapping("/violations")
    public ResponseEntity<List<RiskViolationDto>> violations(Principal principal) {
        return ResponseEntity.ok(riskService.getViolations(principal.getName()));
    }
}
