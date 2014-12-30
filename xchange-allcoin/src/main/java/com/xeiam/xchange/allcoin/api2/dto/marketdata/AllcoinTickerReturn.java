package com.xeiam.xchange.allcoin.api2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllcoinTickerReturn<V> {

  private final int code;
  private final AllcoinTicker data;

  public AllcoinTickerReturn(@JsonProperty("code") int code, @JsonProperty("data") AllcoinTicker data) {

    this.code = code;
    this.data = data;
  }

  public int getCode() {

    return this.code;
  }

  public AllcoinTicker getData() {

    return this.data;
  }

  @Override
  public String toString() {

    return String.format("AllcoinReturn[%s: %s]", code, data);
  }

}
