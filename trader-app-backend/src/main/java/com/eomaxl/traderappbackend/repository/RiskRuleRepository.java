package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.risk.RiskRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {
}
