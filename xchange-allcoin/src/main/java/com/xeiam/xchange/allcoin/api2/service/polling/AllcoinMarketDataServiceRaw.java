package com.xeiam.xchange.allcoin.api2.service.polling;

import java.io.IOException;

import si.mazi.rescu.SynchronizedValueFactory;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.allcoin.Allcoin;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTicker;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTickerReturn;
import com.xeiam.xchange.currency.CurrencyPair;


public abstract class AllcoinMarketDataServiceRaw extends AllcoinBasePollingService {
	
	protected AllcoinMarketDataServiceRaw(ExchangeSpecification exchangeSpecification, SynchronizedValueFactory<Long> nonceFactory) {
		super(Allcoin.class, exchangeSpecification, nonceFactory);
	}

  public AllcoinTickerReturn getAllcoinTicker(CurrencyPair currencyPair) throws IOException {
    return allcoin.getAllcoinTicker(currencyPair.baseSymbol.toUpperCase() + "_" + currencyPair.counterSymbol.toString());
  }
	
	
}
