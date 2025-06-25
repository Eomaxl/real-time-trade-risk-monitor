package com.eomaxl.traderappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/audit")
@RequiredArgsConstructor
public class AuditController {
    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AuditLogDto>> logs(Principal principal) {
        return ResponseEntity.ok(auditService.getUserLogs(principal.getName()));
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportLogs(Principal principal) {
        return auditService.exportLogs(principal.getName());
    }
}
