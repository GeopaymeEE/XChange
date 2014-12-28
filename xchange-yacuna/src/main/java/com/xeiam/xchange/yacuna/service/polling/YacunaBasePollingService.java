package com.xeiam.xchange.yacuna.service.polling;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.service.BaseExchangeService;
import com.xeiam.xchange.service.polling.BasePollingService;
import com.xeiam.xchange.yacuna.Yacuna;
import com.xeiam.xchange.yacuna.dto.marketdata.YacunaTicker;
import com.xeiam.xchange.yacuna.dto.marketdata.YacunaTickerReturn;
import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Yingzhe on 12/27/2014.
 */
public class YacunaBasePollingService<T extends Yacuna> extends BaseExchangeService implements BasePollingService {

  private static HashMap<String, CurrencyPair> CURRENCY_PAIR_MAP;
  protected final T yacuna;

  protected YacunaBasePollingService(Class<T> type, ExchangeSpecification exchangeSpecification) {

    super(exchangeSpecification);
    this.yacuna = RestProxyFactory.createProxy(type, (String) exchangeSpecification.getSslUri());
  }

  protected HashMap<String, CurrencyPair> getCurrencyPairMap() throws IOException {

    if (CURRENCY_PAIR_MAP == null) {
      CURRENCY_PAIR_MAP = new HashMap<String, CurrencyPair>();
      YacunaTickerReturn tickers = this.yacuna.getTickers();

      if (tickers != null && tickers.getTickerList() != null) {
        for (YacunaTicker yt : tickers.getTickerList()) {
          String base = yt.getBaseCurrency().toUpperCase();
          String target = yt.getTargetCurrency().toUpperCase();
          CURRENCY_PAIR_MAP.put(base + "_" + target, new CurrencyPair(base, target));
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
