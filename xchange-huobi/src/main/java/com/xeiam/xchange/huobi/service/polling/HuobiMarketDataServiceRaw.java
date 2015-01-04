package com.xeiam.xchange.huobi.service.polling;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.huobi.Huobi;
import com.xeiam.xchange.huobi.dto.marketdata.HuobiTickerReturn;

import java.io.IOException;

/**
 * Created by Yingzhe on 1/3/2015.
 */
public class HuobiMarketDataServiceRaw extends HuobiBasePollingService<Huobi>{
    public HuobiMarketDataServiceRaw(ExchangeSpecification exchangeSpecification) {

        super(Huobi.class, exchangeSpecification);
    }

    public HuobiTickerReturn getHuobiTickerReturn(CurrencyPair currencyPair) throws IOException {

        if (!this.getCurrencyPairMap().containsKey(currencyPair.baseSymbol.toUpperCase() + "_" + currencyPair.counterSymbol.toUpperCase())) {
            return null;
        }

        // Huobi needs this to currency to be in lower case for some reasons
        HuobiTickerReturn tickerReturn = this.huobi.getTicker(currencyPair.baseSymbol.toLowerCase());
        return tickerReturn != null ? tickerReturn : null;
    }
}
