package com.eomaxl.traderappbackend.service;

public interface AuditService {
    List<AuditLogDto> getUserLogs(String username);
    ResponseEntity<Resource> exportLogs(String username);
}
