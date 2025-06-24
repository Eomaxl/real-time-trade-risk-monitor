package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.auth.User;
import com.eomaxl.traderappbackend.entity.order.Order;
import com.eomaxl.traderappbackend.entity.risk.RiskViolation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiskViolationRepository extends JpaRepository<RiskViolation, Long> {
    List<RiskViolation> findByUser(User user);
    List<RiskViolation> findByOrder(Order order);
}
