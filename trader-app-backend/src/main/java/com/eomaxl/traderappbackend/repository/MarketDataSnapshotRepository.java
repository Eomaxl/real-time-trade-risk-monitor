package com.eomaxl.traderappbackend.repository;

import com.eomaxl.traderappbackend.entity.market.Instrument;
import com.eomaxl.traderappbackend.entity.market.MarketDataSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketDataSnapshotRepository extends JpaRepository<MarketDataSnapshot, Long> {
    List<MarketDataSnapshot> findByInstrument(Instrument instrument);
}
