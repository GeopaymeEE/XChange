package com.xeiam.xchange.allcoin;

import si.mazi.rescu.SynchronizedValueFactory;

import com.xeiam.xchange.BaseExchange;
import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.allcoin.api2.service.polling.AllcoinMarketDataService;
import com.xeiam.xchange.service.polling.MarketMetadataService;
import com.xeiam.xchange.service.polling.PollingAccountService;
import com.xeiam.xchange.service.polling.PollingMarketDataService;
import com.xeiam.xchange.service.polling.PollingTradeService;
import com.xeiam.xchange.service.streaming.ExchangeStreamingConfiguration;
import com.xeiam.xchange.service.streaming.StreamingExchangeService;
import com.xeiam.xchange.utils.nonce.LongTimeNonceFactory;

public class AllcoinExchange extends BaseExchange implements Exchange {

	private final SynchronizedValueFactory<Long> nonceFactory = new LongTimeNonceFactory();
	
	@Override
	  public ExchangeSpecification getDefaultExchangeSpecification() {

	    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
	    exchangeSpecification.setSslUri("https://www.allcoin.com");
	    exchangeSpecification.setHost("allcoin.com");
	    exchangeSpecification.setPort(80);
	    exchangeSpecification.setExchangeName("Allcoin");
	    exchangeSpecification.setExchangeDescription("Allcoin is a Bitcoin exchange.");
	    exchangeSpecification.setExchangeSpecificParametersItem("demo-api", "http://demo-api.allcoin.com");

	    return exchangeSpecification;
	  }

	@Override
	public void applySpecification(ExchangeSpecification exchangeSpecification) {
		// TODO Auto-generated method stub
		super.applySpecification(exchangeSpecification);
	    this.pollingMarketDataService = new AllcoinMarketDataService(exchangeSpecification, nonceFactory);
//	    this.pollingTradeService = new HitbtcTradeService(exchangeSpecification, nonceFactory);
//	    this.pollingAccountService = new HitbtcAccountService(exchangeSpecification, nonceFactory);
	}
	
}
