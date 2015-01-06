package com.xeiam.xchange.huobi;

import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.huobi.dto.marketdata.HuobiTicker;
import com.xeiam.xchange.huobi.dto.marketdata.HuobiTickerReturn;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Yingzhe on 12/30/2014.
 */
public class HuobiAdapters {
    public static Ticker adaptTicker(HuobiTickerReturn tickerReturn, CurrencyPair currencyPair) {

        if (tickerReturn == null || tickerReturn.getTicker() == null) {
            return null;
        }

        HuobiTicker ticker = tickerReturn.getTicker();
        BigDecimal last = ticker.getLast();
        BigDecimal high = ticker.getHigh();
        BigDecimal low = ticker.getLow();
        BigDecimal buy = ticker.getBuy();
        BigDecimal sell = ticker.getSell();
        BigDecimal volume = ticker.getVolume();
        Date date = new Date(tickerReturn.getTimestamp() * 1000);

        return new Ticker.Builder().currencyPair(currencyPair).last(last).high(high).low(low).bid(buy).ask(sell).volume(volume).timestamp(date).build();
    }
}
