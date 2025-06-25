package com.eomaxl.traderappbackend.service;

import java.util.UUID;

public interface OrderService {
    OrderDto placeOrder(PlaceOrderRequest req, String username);
    OrderDto amendOrder(UUID orderId, AmendOrderRequest req, String username);
    void cancelOrder(UUID orderId, String username);
    List<OrderDto> listOrders(String username, String status);
    OrderDto getOrder(UUID orderId, String username);
}
