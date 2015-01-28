package com.xeiam.xchange.huobi.service.polling;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.huobi.Huobi;
import com.xeiam.xchange.service.BaseExchangeService;
import com.xeiam.xchange.service.polling.BasePollingService;
import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yingzhe on 1/3/2015.
 */
public class HuobiBasePollingService<T extends Huobi> extends BaseExchangeService implements BasePollingService {
    private static HashMap<String, CurrencyPair> CURRENCY_PAIR_MAP;
    private static List<CurrencyPair> CURRENCY_PAIR_LIST;
    protected final T huobi;

    protected HuobiBasePollingService(Class<T> type, Exchange exchange) {

        super(exchange);
        this.huobi = RestProxyFactory.createProxy(type, exchange.getExchangeSpecification().getSslUri());
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
    public List<CurrencyPair> getExchangeSymbols() throws IOException {

        if (CURRENCY_PAIR_LIST == null) {
            CURRENCY_PAIR_LIST = new ArrayList<CurrencyPair>(this.getCurrencyPairMap().values());
        }

        return CURRENCY_PAIR_LIST;
    }
}
