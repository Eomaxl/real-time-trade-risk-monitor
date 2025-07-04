package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.market.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrumentRepository  extends JpaRepository<Instrument, Long> {
    Optional<Instrument> findBySymbol(String symbol);
}
