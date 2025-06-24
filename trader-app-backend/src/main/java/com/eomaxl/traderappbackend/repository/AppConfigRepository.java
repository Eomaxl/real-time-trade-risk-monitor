package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.common.AppConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppConfigRepository extends JpaRepository<AppConfig, Long> {}
