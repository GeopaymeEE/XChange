package com.xeiam.xchange.huobi.service.polling;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.huobi.Huobi;
import com.xeiam.xchange.service.BaseExchangeService;
import com.xeiam.xchange.service.polling.BasePollingService;
import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Yingzhe on 1/3/2015.
 */
public class HuobiBasePollingService<T extends Huobi> extends BaseExchangeService implements BasePollingService {
    private static HashMap<String, CurrencyPair> CURRENCY_PAIR_MAP;
    protected final T huobi;

    protected HuobiBasePollingService(Class<T> type, ExchangeSpecification exchangeSpecification) {

        super(exchangeSpecification);
        this.huobi = RestProxyFactory.createProxy(type, exchangeSpecification.getSslUri());
    }

    protected HashMap<String, CurrencyPair> getCurrencyPairMap() throws IOException {

        if (CURRENCY_PAIR_MAP == null) {
            CURRENCY_PAIR_MAP = new HashMap<String, CurrencyPair>();
            CURRENCY_PAIR_MAP.put("BTC_CNY", new CurrencyPair("BTC", "CNY"));
            CURRENCY_PAIR_MAP.put("LTC_CNY", new CurrencyPair("LTC", "CNY"));
        }

        return CURRENCY_PAIR_MAP;
    }

    @Override
    public Collection<CurrencyPair> getExchangeSymbols() throws IOException {

        return this.getCurrencyPairMap().values();
    }
}
