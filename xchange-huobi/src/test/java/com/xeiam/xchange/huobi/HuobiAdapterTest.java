package com.xeiam.xchange.huobi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.huobi.dto.marketdata.HuobiTickerReturn;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Yingzhe on 1/3/2015.
 */
public class HuobiAdapterTest {
    @Test
    public void testTickerAdapter() throws IOException {

        // Read in the JSON from the example resources
        InputStream is = HuobiAdapterTest.class.getResourceAsStream("/example-ticker-data.json");

        // Use Jackson to parse it
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory t = TypeFactory.defaultInstance();
        HuobiTickerReturn tickerReturn = mapper.readValue(is, HuobiTickerReturn.class);

        Ticker ticker = HuobiAdapters.adaptTicker(tickerReturn, new CurrencyPair("BTC", "CNY"));

        assertThat(ticker.getHigh()).isEqualTo(new BigDecimal("1941.7"));
        assertThat(ticker.getLow()).isEqualTo(new BigDecimal("1909.05"));
        assertThat(ticker.getLast()).isEqualTo(new BigDecimal("1919.2"));
        assertThat(ticker.getVolume()).isEqualTo(new BigDecimal("36707.3776"));
        assertThat(ticker.getAsk()).isEqualTo(new BigDecimal("1919.7"));
        assertThat(ticker.getBid()).isEqualTo(new BigDecimal("1919.2"));
    }
}
