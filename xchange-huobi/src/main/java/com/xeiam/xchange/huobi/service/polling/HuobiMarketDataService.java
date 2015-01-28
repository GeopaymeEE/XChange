package com.xeiam.xchange.huobi.service.polling;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.marketdata.Trades;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotAvailableFromExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.huobi.HuobiAdapters;
import com.xeiam.xchange.huobi.dto.marketdata.HuobiTickerReturn;
import com.xeiam.xchange.service.polling.marketdata.PollingMarketDataService;

import java.io.IOException;

/**
 * Created by Yingzhe on 1/3/2015.
 */
public class HuobiMarketDataService extends HuobiMarketDataServiceRaw implements PollingMarketDataService {
    public HuobiMarketDataService(Exchange exchange) {

        super(exchange);
    }

    @Override
    public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {

        // Request data
        HuobiTickerReturn ticker = getHuobiTickerReturn(currencyPair);

        // Adapt to XChange DTOs
        return HuobiAdapters.adaptTicker(ticker, currencyPair);
    }

    @Override
    public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

        throw new NotYetImplementedForExchangeException();
    }

    @Override
    public Trades getTrades(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

        throw new NotYetImplementedForExchangeException();
    }
}
