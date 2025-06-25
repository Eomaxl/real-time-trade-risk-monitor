package com.eomaxl.traderappbackend.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "externalMarketData", url = "${marketdata.api.url}")
public interface MarketDataFeignClient {
    @GetMapping("/api/live/{symbol}")
    MarketDataSnapshotDto getLiveData(@PathVariable String symbol);
}
