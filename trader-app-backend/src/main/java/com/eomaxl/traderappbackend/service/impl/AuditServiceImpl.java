package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.repository.AuditLogRepository;
import com.eomaxl.traderappbackend.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {
    private final AuditLogRepository repo;

    public List<AuditLogDto> getUserLogs(String username) {
        return repo.findByUser_Username(username).stream().map(AuditLogDto::from).toList();
    }
    public ResponseEntity<Resource> exportLogs(String username) {
        // Generate CSV, return as file download
        return ResponseEntity.ok().body(new ByteArrayResource(new byte[0]));
    }
}
