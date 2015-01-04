package com.xeiam.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by Yingzhe on 12/30/2014.
 */
public class HuobiTicker {
    private final BigDecimal volume;
    private final BigDecimal last;
    private final BigDecimal sell;
    private final BigDecimal buy;
    private final BigDecimal high;
    private final BigDecimal low;

    public HuobiTicker(@JsonProperty("vol") BigDecimal volume, @JsonProperty("last") BigDecimal last, @JsonProperty("sell") BigDecimal sell, @JsonProperty("buy") BigDecimal buy, @JsonProperty("high") BigDecimal high, @JsonProperty("low") BigDecimal low) {
        this.volume = volume;
        this.last = last;
        this.sell = sell;
        this.buy = buy;
        this.high = high;
        this.low = low;
    }

    public BigDecimal getVolume() {
        return this.volume;
    }

    public BigDecimal getLast() {
        return this.last;
    }

    public BigDecimal getSell() {
        return this.sell;
    }

    public BigDecimal getBuy() {
        return this.buy;
    }

    public BigDecimal getHigh() {
        return this.high;
    }

    public BigDecimal getLow() {
        return this.low;
    }

    @Override
    public String toString() {
        return String.format("HuobiTicker[volume: %s, last: %s, sell: %s, buy: %s, high: %s, low: %s]", volume, last, sell, buy, high, low);
    }
}
