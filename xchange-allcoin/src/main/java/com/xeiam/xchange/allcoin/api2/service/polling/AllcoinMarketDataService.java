package com.xeiam.xchange.allcoin.api2.service.polling;

import java.io.IOException;

import com.xeiam.xchange.Exchange;

import com.xeiam.xchange.allcoin.AllcoinAdapters;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.marketdata.Trades;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotAvailableFromExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.marketdata.PollingMarketDataService;
import si.mazi.rescu.SynchronizedValueFactory;

public class AllcoinMarketDataService extends AllcoinMarketDataServiceRaw implements PollingMarketDataService {

  public AllcoinMarketDataService(Exchange exchange, SynchronizedValueFactory<Long> nonceFactory) {

    super(exchange, nonceFactory);
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    // TODO Auto-generated method stub
    return AllcoinAdapters.adaptTicker(getAllcoinTicker(currencyPair), currencyPair);
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    // TODO Auto-generated method stub
    throw new NotYetImplementedForExchangeException();
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    // TODO Auto-generated method stub
    throw new NotYetImplementedForExchangeException();
  }

}
