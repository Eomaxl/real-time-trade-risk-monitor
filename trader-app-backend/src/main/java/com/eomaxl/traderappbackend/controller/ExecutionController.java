package com.eomaxl.traderappbackend.controller;

import com.eomaxl.traderappbackend.service.ExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/executions")
@RequiredArgsConstructor
public class ExecutionController {
    private final ExecutionService executionService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<ExecutionReportDto>> executionsByOrder(@PathVariable UUID orderId, Principal principal) {
        return ResponseEntity.ok(executionService.findByOrder(orderId,principal), HttpStatus.OK);
    }

    @PostMapping("/report")
    public ResponseEntity<Void> receiveReport(@RequestBody ExecutionReportRequest req){
        executionService.receiveExecutionReport(req);
        return ResponseEntity.ok().build();
    }
}
