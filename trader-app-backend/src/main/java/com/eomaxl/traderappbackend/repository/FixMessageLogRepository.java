package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.fix.FixMessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixMessageLogRepository extends JpaRepository<FixMessageLog, Long> {
}
