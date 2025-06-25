package com.eomaxl.traderappbackend.controller;

import com.eomaxl.traderappbackend.service.OrderService;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody PlaceOrderRequest request, Principal principal) {
        return ResponseEntity.ok(orderService.placeOrder(req, principal.getName()));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<SpringDataJaxb.OrderDto> amendOrder(@PathVariable UUID orderId, @RequestBody AmendOrder request, Principal principal) {
        return ResponseEntity.ok(orderService.amendOrder(orderId, req, principal.getName()));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> cancelOrder(@PathVariable UUID orderId, Principal principal) {
        orderService.cancelOrder(orderId, principal.getName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all-orders")
    public ResponseEntity<List<OrderDto>> getAllOrders(@RequestParam(required = false) String status,Principal principal) {
        return ResponseEntity.ok(orderService.listOrders(principal.getName(), status));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable UUID orderId, Principal principal) {
        return ResponseEntity.ok(orderService.getOrder(orderId, principal.getName()));
    }

}
