package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.fix.FixSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixSessionRepository extends JpaRepository<FixSession, Long> {}
