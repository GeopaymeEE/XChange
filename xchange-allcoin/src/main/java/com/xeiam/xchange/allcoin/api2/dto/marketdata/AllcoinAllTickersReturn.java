package com.xeiam.xchange.allcoin.api2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Yingzhe on 12/28/2014.
 */
public class AllcoinAllTickersReturn {
    private final int code;
    private final Map<String, AllcoinTicker> data;

    public AllcoinAllTickersReturn(@JsonProperty("code") int code, @JsonProperty("data") Map<String, AllcoinTicker> data) {

        this.code = code;
        this.data = data;
    }

    public int getCode() {

        return this.code;
    }

    public Map<String, AllcoinTicker> getData() {

        return this.data;
    }

    @Override
    public String toString() {

        return String.format("AllcoinReturn[%s: %s]", code, data);
    }
}
