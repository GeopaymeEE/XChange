package com.xeiam.xchange.examples.huobi;

import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.huobi.HuobiExchange;
import com.xeiam.xchange.huobi.service.polling.HuobiMarketDataService;

/**
 * Created by Yingzhe on 1/3/2015.
 */
public class HuobiMarketDataDemo {
    public static void main(String[] args) throws Exception {

        HuobiExchange exchange = new HuobiExchange();
        exchange.applySpecification(exchange.getDefaultExchangeSpecification());
        HuobiMarketDataService marketDataService = (HuobiMarketDataService) exchange.getPollingMarketDataService();
        Ticker ticker = marketDataService.getTicker(new CurrencyPair("BTC", "CNY"));
        System.out.println(ticker.toString());
    }
}
