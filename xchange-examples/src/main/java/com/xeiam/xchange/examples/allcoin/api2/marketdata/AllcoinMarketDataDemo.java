package com.xeiam.xchange.examples.allcoin.api2.marketdata;

import java.io.IOException;
import java.util.Collection;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.examples.allcoin.api2.AllcoinExampleUtils;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTicker;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTickerReturn;
import com.xeiam.xchange.allcoin.api2.service.polling.AllcoinMarketDataServiceRaw;
import com.xeiam.xchange.service.polling.PollingMarketDataService;


public class AllcoinMarketDataDemo {
	public static void main(String[] args) throws Exception {

	    Exchange allcoinExchange = AllcoinExampleUtils.createExchange();
	    PollingMarketDataService marketDataService = allcoinExchange.getPollingMarketDataService();

	    generic(marketDataService);
	    raw((AllcoinMarketDataServiceRaw) marketDataService);
	  }
	
	private static void generic(PollingMarketDataService marketDataService) throws IOException {

	    Ticker ticker = marketDataService.getTicker(CurrencyPair.DOGE_BTC);
	    System.out.println(ticker);

	  }

	  private static void raw(AllcoinMarketDataServiceRaw marketDataService) throws IOException {

	    Collection<CurrencyPair> currencyPairs = marketDataService.getExchangeSymbols();
	    System.out.println(currencyPairs);

	    AllcoinTickerReturn ticker = marketDataService.getAllcoinTicker(CurrencyPair.DOGE_BTC);
	    System.out.println(ticker.getData());

	  }
}
