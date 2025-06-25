package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.entity.auth.User;
import com.eomaxl.traderappbackend.entity.order.Order;
import com.eomaxl.traderappbackend.repository.OrderRepository;
import com.eomaxl.traderappbackend.repository.UserRepository;
import com.eomaxl.traderappbackend.service.ExecutionService;
import com.eomaxl.traderappbackend.service.OrderService;
import com.eomaxl.traderappbackend.service.RiskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RiskService riskService;
    private final ExecutionService executionService;

    public OrderDto placeOrder(PlaceOrderRequest req, String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        riskService.preTradeRiskCheck(req, user); // throws if failed

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setUser(user);
        order.setSymbol(req.getSymbol());
        order.setSide(req.getSide());
        order.setType(req.getType());
        order.setQuantity(req.getQuantity());
        order.setPrice(req.getPrice());
        order.setStatus(OrderStatus.PENDING);
        order.setPlacedAt(Instant.now());

        orderRepository.save(order);
        // send to execution via async queue or Feign client to exchange service
        executionService.submitOrder(order);

        return OrderDto.from(order);
    }

    public OrderDto amendOrder(UUID orderId, AmendOrderRequest req, String username) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        // authorization & state check
        // amend fields...
        orderRepository.save(order);
        return OrderDto.from(order);
    }

    public void cancelOrder(UUID orderId, String username) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        // state/authorization check
        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }

    public List<OrderDto> listOrders(String username, String status) {
        User user = userRepository.findByUsername(username).orElseThrow();
        if (status == null) return orderRepository.findByUser(user).stream().map(OrderDto::from).toList();
        return orderRepository.findByUser(user).stream().filter(o -> o.getStatus().name().equals(status)).map(OrderDto::from).toList();
    }

    public OrderDto getOrder(UUID orderId, String username) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return OrderDto.from(order);
    }
}
