package com.xeiam.xchange.allcoin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTicker;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTickerReturn;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;

public class AllcoinAdapterTest {

  @Test
  public void testTickerAdapter() throws IOException {

    // Read in the JSON from the example resources
    InputStream is = AllcoinAdapterTest.class.getResourceAsStream("/example-pair.json");

    ObjectMapper mapper = new ObjectMapper();
    AllcoinTickerReturn tickerReturn = mapper.readValue(is, AllcoinTickerReturn.class);
    Ticker ticker = AllcoinAdapters.adaptTicker(tickerReturn, CurrencyPair.DOGE_BTC);

    assertThat(ticker.getHigh()).isEqualTo(new BigDecimal("0.00000061"));
    assertThat(ticker.getLow()).isEqualTo(new BigDecimal("0.00000058"));
    assertThat(ticker.getLast()).isEqualTo(new BigDecimal("0.00000059"));
    assertThat(ticker.getVolume()).isEqualTo(new BigDecimal("20595302.55147269"));
    assertThat(ticker.getAsk()).isEqualTo(new BigDecimal("0.00000060"));
    assertThat(ticker.getBid()).isEqualTo(new BigDecimal("0.00000059"));
  }

}
