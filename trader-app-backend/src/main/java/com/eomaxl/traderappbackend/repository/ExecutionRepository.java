package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.execution.ExecutionReport;
import com.eomaxl.traderappbackend.entity.order.Order;
import org.apache.maven.plugin.lifecycle.Execution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExecutionRepository extends JpaRepository<ExecutionReport, UUID> {
    List<ExecutionReport> findByOrder(Order order);
}
