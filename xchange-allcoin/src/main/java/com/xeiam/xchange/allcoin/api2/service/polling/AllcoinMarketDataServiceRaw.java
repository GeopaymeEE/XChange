package com.xeiam.xchange.allcoin.api2.service.polling;

import java.io.IOException;

import com.xeiam.xchange.Exchange;
import si.mazi.rescu.SynchronizedValueFactory;

import com.xeiam.xchange.allcoin.Allcoin;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTickerReturn;
import com.xeiam.xchange.currency.CurrencyPair;

public abstract class AllcoinMarketDataServiceRaw extends AllcoinBasePollingService {

  protected AllcoinMarketDataServiceRaw(Exchange exchange, SynchronizedValueFactory<Long> nonceFactory) {

    super(Allcoin.class, exchange, nonceFactory);
  }

  public AllcoinTickerReturn getAllcoinTicker(CurrencyPair currencyPair) throws IOException {

    if (!this.getCurrencyPairMap().containsKey(currencyPair.baseSymbol.toUpperCase() + "_" + currencyPair.counterSymbol.toUpperCase())) {
      return null;
    }
    return allcoin.getAllcoinTicker(currencyPair.baseSymbol.toUpperCase() + "_" + currencyPair.counterSymbol.toString());
  }

}
