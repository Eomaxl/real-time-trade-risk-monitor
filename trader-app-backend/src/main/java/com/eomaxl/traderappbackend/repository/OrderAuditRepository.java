package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.order.Order;
import com.eomaxl.traderappbackend.entity.order.OrderAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderAuditRepository extends JpaRepository<OrderAudit, Long> {
    List<OrderAudit> findByOrder(Order order);
}
