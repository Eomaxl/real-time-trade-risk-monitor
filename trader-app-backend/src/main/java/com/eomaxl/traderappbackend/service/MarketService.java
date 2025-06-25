package com.eomaxl.traderappbackend.service;

public interface MarketService {
    void subscribe(String username, String symbol);
    void unsubscribe(String username, String symbol);
    MarketDataSnapshotDto getSnapshot(String symbol);
}
