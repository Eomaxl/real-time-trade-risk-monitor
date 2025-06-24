package com.eomaxl.traderappbackend.repository;

import org.apache.maven.plugin.lifecycle.Execution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExecutionRepository extends JpaRepository<Execution, UUID> {
}
