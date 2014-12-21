package com.xeiam.xchange.btc38.service.polling;

import com.xeiam.xchange.ExchangeException;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.NotAvailableFromExchangeException;
import com.xeiam.xchange.NotYetImplementedForExchangeException;
import com.xeiam.xchange.btc38.Btc38Adapters;
import com.xeiam.xchange.btc38.dto.marketdata.Btc38Ticker;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.marketdata.Trades;
import com.xeiam.xchange.service.polling.PollingMarketDataService;

import java.io.IOException;

/**
 * Created by Yingzhe on 12/19/2014.
 */
public class Btc38MarketDataService extends Btc38MarketDataServiceRaw implements PollingMarketDataService {

  public Btc38MarketDataService(ExchangeSpecification exchangeSpecification) {

    super(exchangeSpecification);
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    // Request data
    Btc38Ticker btc38Ticker = getBtc38Ticker(currencyPair.baseSymbol, currencyPair.counterSymbol);

    // Adapt to XChange DTOs
    return Btc38Adapters.adaptTicker(btc38Ticker, currencyPair);
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    return null;
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    return null;
  }
}
