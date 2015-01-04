package com.xeiam.xchange.huobi;

import com.xeiam.xchange.BaseExchange;
import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.huobi.service.polling.HuobiMarketDataService;

/**
 * Created by Yingzhe on 12/30/2014.
 */
public class HuobiExchange extends BaseExchange implements Exchange {
    public HuobiExchange() {

    }

    @Override
    public void applySpecification(ExchangeSpecification exchangeSpecification) {

        super.applySpecification(exchangeSpecification);
        this.pollingMarketDataService = new HuobiMarketDataService(exchangeSpecification);
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {

        ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
        exchangeSpecification.setSslUri("http://api.huobi.com");
        exchangeSpecification.setHost("api.huobi.com");
        exchangeSpecification.setPort(80);
        exchangeSpecification.setExchangeName("Huobi");
        exchangeSpecification.setExchangeDescription("Huobi is a Chinese Bitcoin exchange");
        return exchangeSpecification;
    }
}
