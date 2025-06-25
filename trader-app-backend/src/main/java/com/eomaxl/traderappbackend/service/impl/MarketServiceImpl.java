package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.entity.market.MarketDataSnapshot;
import com.eomaxl.traderappbackend.repository.InstrumentRepository;
import com.eomaxl.traderappbackend.repository.MarketDataSnapshotRepository;
import com.eomaxl.traderappbackend.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService {
    private final MarketDataSnapshotRepository snapshotRepo;
    private final InstrumentRepository instrumentRepo;
    // Possibly a WebSocket broadcaster...

    public void subscribe(String username, String symbol) {
        // Register the user for push updates (could be in-memory, cache, or DB)
    }
    public void unsubscribe(String username, String symbol) { }
    public MarketDataSnapshotDto getSnapshot(String symbol) {
        MarketDataSnapshot snap = snapshotRepo.findTopByInstrument_SymbolOrderByTimestampDesc(symbol)
                .orElseThrow();
        return MarketDataSnapshotDto.from(snap);
    }
}
