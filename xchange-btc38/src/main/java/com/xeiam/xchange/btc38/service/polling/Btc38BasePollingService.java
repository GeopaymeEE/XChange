package com.xeiam.xchange.btc38.service.polling;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.btc38.Btc38;
import com.xeiam.xchange.currency.Currencies;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.service.BaseExchangeService;
import com.xeiam.xchange.service.polling.BasePollingService;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;
import si.mazi.rescu.SynchronizedValueFactory;

import java.io.IOException;
import java.util.*;

/**
 * Created by Yingzhe on 12/18/2014.
 */
public class Btc38BasePollingService extends BaseExchangeService implements BasePollingService {
    public static final HashMap<String, CurrencyPair> CURRENCY_PAIR_MAP = new HashMap<String, CurrencyPair>();

    /**
     * Constructor Initialize common properties from the exchange specification
     *
     * @param exchangeSpecification The {@link com.xeiam.xchange.ExchangeSpecification}
     */
    protected Btc38BasePollingService(ExchangeSpecification exchangeSpecification) {
        super(exchangeSpecification);

        CURRENCY_PAIR_MAP.put("LTC_BTC",  new CurrencyPair("LTC", "BTC"));
        CURRENCY_PAIR_MAP.put("DOGE_BTC", new CurrencyPair("DOGE", "BTC"));
        CURRENCY_PAIR_MAP.put("XRP_BTC", new CurrencyPair("XRP", "BTC"));
        CURRENCY_PAIR_MAP.put("BTS_BTC", new CurrencyPair("BTS", "BTC"));
        CURRENCY_PAIR_MAP.put("STR_BTC", new CurrencyPair("STR", "BTC"));
        CURRENCY_PAIR_MAP.put("XCN_BTC", new CurrencyPair("XCN", "BTC"));
        CURRENCY_PAIR_MAP.put("BILS_BTC", new CurrencyPair("BILS", "BTC"));
        CURRENCY_PAIR_MAP.put("BOST_BTC", new CurrencyPair("BOST", "BTC"));
        CURRENCY_PAIR_MAP.put("ANC_BTC", new CurrencyPair("ANC", "BTC"));
        CURRENCY_PAIR_MAP.put("WDC_BTC", new CurrencyPair("WDC", "BTC"));
        CURRENCY_PAIR_MAP.put("NXT_BTC", new CurrencyPair("NXT", "BTC"));
        CURRENCY_PAIR_MAP.put("NAS_BTC", new CurrencyPair("NAS", "BTC"));
        CURRENCY_PAIR_MAP.put("BC_BTC", new CurrencyPair("BC", "BTC"));
        CURRENCY_PAIR_MAP.put("SYS_BTC", new CurrencyPair("SYS", "BTC"));
        CURRENCY_PAIR_MAP.put("NRS_BTC", new CurrencyPair("NRS", "BTC"));
        CURRENCY_PAIR_MAP.put("MED_BTC", new CurrencyPair("MED", "BTC"));
        CURRENCY_PAIR_MAP.put("EAC_BTC", new CurrencyPair("EAC", "BTC"));
        CURRENCY_PAIR_MAP.put("VOOT_BTC", new CurrencyPair("VOOT", "BTC"));
        CURRENCY_PAIR_MAP.put("SYNC_BTC", new CurrencyPair("SYNC", "BTC"));
        CURRENCY_PAIR_MAP.put("TMC_BTC", new CurrencyPair("TMC", "BTC"));
    }

    @Override
    public Collection<CurrencyPair> getExchangeSymbols() throws IOException {
        return CURRENCY_PAIR_MAP.values();
    }
}