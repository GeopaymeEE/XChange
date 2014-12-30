package com.xeiam.xchange.allcoin.api2.dto.marketdata;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllcoinTicker {

  private final BigDecimal ask;
  private final BigDecimal bid;
  private final BigDecimal last;
  private final BigDecimal low;
  private final BigDecimal high;
  private final BigDecimal volume;
  private final long timetamp;

  /**
   * Constructor
   * 
   * @param ask
   * @param bid
   * @param last
   * @param low
   * @param high
   * @param volume
   * @param timetamp
   */
  public AllcoinTicker(@JsonProperty("top_ask") BigDecimal ask, @JsonProperty("top_bid") BigDecimal bid, @JsonProperty("trade_price") BigDecimal last, @JsonProperty("min_24h_price") BigDecimal low,
      @JsonProperty("max_24h_price") BigDecimal high, @JsonProperty("type_volume") BigDecimal volume, @JsonProperty("min_24h_time") long timetamp) {

    this.ask = ask;
    this.bid = bid;
    this.last = last;
    this.low = low;
    this.high = high;
    this.volume = volume;
    this.timetamp = timetamp;
  }

  public BigDecimal getAsk() {

    return ask;
  }

  public BigDecimal getBid() {

    return bid;
  }

  public BigDecimal getLast() {

    return last;
  }

  public BigDecimal getLow() {

    return low;
  }

  public BigDecimal getHigh() {

    return high;
  }

  public BigDecimal getVolume() {

    return volume;
  }

  public long getTimetamp() {

    return timetamp;
  }

  @Override
  public String toString() {

    return "AllcoinTicker{" + "ask=" + ask + ", bid=" + bid + ", last=" + last + ", low=" + low + ", high=" + high + ", volume=" + volume + ", timetamp=" + timetamp + '}';
  }

}
