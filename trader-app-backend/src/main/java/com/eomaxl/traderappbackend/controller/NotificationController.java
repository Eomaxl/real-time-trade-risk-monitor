package com.eomaxl.traderappbackend.controller;

import com.eomaxl.traderappbackend.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationDto>> list(Principal principal) {
        return ResponseEntity.ok(notificationService.getUserNotifications(principal.getName()));
    }

    @PostMapping("/read/{id}")
    public ResponseEntity<Void> markRead(@PathVariable Long id, Principal principal) {
        notificationService.markAsRead(id, principal.getName());
        return ResponseEntity.ok().build();
    }
}
