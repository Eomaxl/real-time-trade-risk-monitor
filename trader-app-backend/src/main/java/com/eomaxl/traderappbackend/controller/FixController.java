package com.eomaxl.traderappbackend.controller;

import com.eomaxl.traderappbackend.service.FixService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fix")
@RequiredArgsConstructor
public class FixController {
    private final FixService fixService;

    @GetMapping("/sessions")
    public ResponseEntity<List<FixSessionDto>> listSessions() {
        return ResponseEntity.ok(fixService.getAllSessions());
    }
}
