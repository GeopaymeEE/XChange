package com.xeiam.xchange.huobi;

import com.xeiam.xchange.BaseExchange;
import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.huobi.service.polling.HuobiMarketDataService;
import com.xeiam.xchange.utils.nonce.CurrentTimeNonceFactory;
import si.mazi.rescu.SynchronizedValueFactory;

/**
 * Created by Yingzhe on 12/30/2014.
 */
public class HuobiExchange extends BaseExchange {
    private final SynchronizedValueFactory<Long> nonceFactory = new CurrentTimeNonceFactory();

    public HuobiExchange() {

    }

    @Override
    public void applySpecification(ExchangeSpecification exchangeSpecification) {

        super.applySpecification(exchangeSpecification);
        this.pollingMarketDataService = new HuobiMarketDataService(this);
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

    @Override
    public SynchronizedValueFactory<Long> getNonceFactory() {

        return nonceFactory;
    }
}
