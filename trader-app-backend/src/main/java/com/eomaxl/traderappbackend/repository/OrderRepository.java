package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.auth.User;
import com.eomaxl.traderappbackend.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order> findByOrderId(String orderId);
    List<Order> findByUser(User user);
}
