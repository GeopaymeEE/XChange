package com.xeiam.xchange.btc38;

import com.xeiam.xchange.BaseExchange;
import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.btc38.service.polling.Btc38MarketDataService;

/**
 * Created by Yingzhe on 12/17/2014.
 */
public class Btc38Exchange extends BaseExchange implements Exchange {
    /**
     * Default constructor for Btc38Exchange
     */
    public Btc38Exchange() {
    }

    @Override
    public void applySpecification(ExchangeSpecification exchangeSpecification) {

        super.applySpecification(exchangeSpecification);

        this.pollingMarketDataService = new Btc38MarketDataService(exchangeSpecification);
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {

        ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
        exchangeSpecification.setSslUri("http://api.btc38.com");
        exchangeSpecification.setHost("api.btc38.com");
        exchangeSpecification.setPort(80);
        exchangeSpecification.setExchangeName("Btc38");
        exchangeSpecification.setExchangeDescription("Btc38 is a Chinese Bitcoin exchange.");

        return exchangeSpecification;
    }
}
