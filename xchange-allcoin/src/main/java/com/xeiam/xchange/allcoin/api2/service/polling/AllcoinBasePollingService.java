package com.xeiam.xchange.allcoin.api2.service.polling;

import java.io.IOException;
import java.util.*;

import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinAllTickersReturn;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTicker;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;
import si.mazi.rescu.SynchronizedValueFactory;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.allcoin.Allcoin;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.service.BaseExchangeService;
import com.xeiam.xchange.service.polling.BasePollingService;

public class AllcoinBasePollingService<T extends Allcoin> extends BaseExchangeService implements BasePollingService {

  protected final SynchronizedValueFactory<Long> valueFactory;

  protected final T allcoin;
  protected final String apiKey;
  protected final ParamsDigest signatureCreator;
  private static HashMap<String, CurrencyPair> CURRENCY_PAIR_MAP;

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
    // this.signatureCreator = apiKey != null && !apiKey.isEmpty() ? AllcoinHmacDigest.createInstance(apiKey) : null;
    this.signatureCreator = null;
  }

	protected HashMap<String, CurrencyPair> getCurrencyPairMap() throws IOException {
		if (CURRENCY_PAIR_MAP == null) {
			CURRENCY_PAIR_MAP = new HashMap<String, CurrencyPair>();
			AllcoinAllTickersReturn tickers = this.allcoin.getAllcoinTickers();

			if (tickers != null && tickers.getData() != null) {
				for (String key : tickers.getData().keySet()) {
					String[] keyString = key.split("_");
					if (keyString != null && keyString.length == 2) {
						String base = keyString[0].toUpperCase();
						String target = keyString[1].toUpperCase();
						CURRENCY_PAIR_MAP.put(key.toUpperCase(), new CurrencyPair(base, target));
					}
				}
			}
		}

		return CURRENCY_PAIR_MAP;
	}

  @Override
  public Collection<CurrencyPair> getExchangeSymbols() throws IOException {

    return this.getCurrencyPairMap().values();
  }
}
