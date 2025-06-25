package com.eomaxl.traderappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/market-data")
@RequiredArgsConstructor
public class MarketDataServiceController {

    private final MarketDataService marketDataService;

    @GetMapping("/subscribe/{symbol}")
    public ResponseEntity<Void> subscribe(@PathVariable String symbol, Principal principal) {
        marketDataService.subscribe(principal.getName(), symbol);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unsubscribe/{symbol}")
    public ResponseEntity<Void> unsubscribe(@PathVariable String symbol, Principal principal) {
        marketDataService.unsubscribe(principal.getName(), symbol);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/snapshot/{symbol}")
    public ResponseEntity<MarketDataSnapshotDto> getSnapshot(@PathVariable String symbol) {
        return ResponseEntity.ok(marketDataService.getSnapshot(symbol));
    }
}
