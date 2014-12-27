package com.xeiam.xchange.allcoin.api2.service.polling;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;
import si.mazi.rescu.SynchronizedValueFactory;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.allcoin.Allcoin;
import com.xeiam.xchange.allcoin.AllcoinAdapters;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.service.BaseExchangeService;
import com.xeiam.xchange.service.polling.BasePollingService;

public class AllcoinBasePollingService<T extends Allcoin> extends BaseExchangeService implements
		BasePollingService {

	protected final SynchronizedValueFactory<Long> valueFactory;

	  protected final T allcoin;
	  protected final String apiKey;
	  protected final ParamsDigest signatureCreator;
	  private final Set<CurrencyPair> currencyPairs;
	
	  /**
	   * Constructor Initialize common properties from the exchange specification
	   * 
	   * @param exchangeSpecification The {@link com.xeiam.xchange.ExchangeSpecification}
	   */
	  protected AllcoinBasePollingService(Class<T> allcoinType, ExchangeSpecification exchangeSpecification, SynchronizedValueFactory<Long> nonceFactory) {

	    super(exchangeSpecification);

	    this.valueFactory = nonceFactory;
	    this.allcoin = RestProxyFactory.createProxy(allcoinType, exchangeSpecification.getSslUri());
	    this.apiKey = exchangeSpecification.getApiKey();
	    String apiKey = exchangeSpecification.getSecretKey();
//	    this.signatureCreator = apiKey != null && !apiKey.isEmpty() ? AllcoinHmacDigest.createInstance(apiKey) : null;
	    this.signatureCreator = null;
	    this.currencyPairs = new HashSet<CurrencyPair>();
	  }

	@Override
	public Collection<CurrencyPair> getExchangeSymbols() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

//	  @Override
//	  public synchronized Collection<CurrencyPair> getExchangeSymbols() throws IOException {
//
//	    if (currencyPairs.isEmpty()) {
//	      currencyPairs.addAll(AllcoinAdapters.adaptCurrencyPairs(allcoin.getSymbols()));
//	    }
//
//	    return currencyPairs;
//	  }

}
