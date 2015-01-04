package com.xeiam.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Yingzhe on 12/30/2014.
 */
public class HuobiTickerReturn {

    private final long timestamp;
    private final HuobiTicker ticker;

    public HuobiTickerReturn(@JsonProperty("time") long timestamp, @JsonProperty("ticker") HuobiTicker ticker) {
        this.timestamp = timestamp;
        this.ticker = ticker;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public HuobiTicker getTicker() {
        return this.ticker;
    }

    @Override
    public String toString() {
        return String.format("HuobiTickeReturn[timestamp: %s, ticker: %s]", timestamp, ticker);
    }
}
