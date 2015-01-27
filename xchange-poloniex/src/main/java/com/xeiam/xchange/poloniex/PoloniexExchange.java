package com.xeiam.xchange.poloniex;

import com.xeiam.xchange.BaseExchange;
import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.poloniex.service.polling.PoloniexAccountService;
import com.xeiam.xchange.poloniex.service.polling.PoloniexMarketDataService;
import com.xeiam.xchange.poloniex.service.polling.PoloniexTradeService;

/**
 * @author Zach Holmes
 */

public class PoloniexExchange extends BaseExchange implements Exchange {

  @Override
  public void applySpecification(ExchangeSpecification exchangeSpecification) {

    super.applySpecification(exchangeSpecification);

    this.pollingMarketDataService = new PoloniexMarketDataService(this);
    this.pollingAccountService = new PoloniexAccountService(this);
    this.pollingTradeService = new PoloniexTradeService(this);
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://poloniex.com/");
    exchangeSpecification.setHost("poloniex.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("Poloniex");
    exchangeSpecification.setExchangeDescription("Poloniex is a bitcoin and altcoin exchange.");

    return exchangeSpecification;
  }

}
