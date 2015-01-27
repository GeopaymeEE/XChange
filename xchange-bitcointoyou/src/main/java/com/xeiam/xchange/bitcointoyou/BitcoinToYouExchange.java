package com.xeiam.xchange.bitcointoyou;

import com.xeiam.xchange.BaseExchange;
import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.bitcointoyou.service.polling.BitcoinToYouAccountService;
import com.xeiam.xchange.bitcointoyou.service.polling.BitcoinToYouMarketDataService;
import com.xeiam.xchange.bitcointoyou.service.polling.BitcoinToYouTradeService;

/**
 * @author Felipe Micaroni Lalli
 */
public class BitcoinToYouExchange extends BaseExchange implements Exchange {

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://www.bitcointoyou.com");
    exchangeSpecification.setHost("www.bitcointoyou.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("BitcoinToYou");
    exchangeSpecification
    .setExchangeDescription("BitcoinToYou is a Bitcoin and Litecoin exchange registered in Brazil. From site description (in Portuguese): Compre e venda Bitcoin com segurança e facilidade. Somos líderes no Brasil, mais de 7000 clientes!");
    return exchangeSpecification;
  }

  @Override
  public void applySpecification(ExchangeSpecification exchangeSpecification) {

    super.applySpecification(exchangeSpecification);
    this.pollingMarketDataService = new BitcoinToYouMarketDataService(this);
    this.pollingAccountService = new BitcoinToYouAccountService(this);
    this.pollingTradeService = new BitcoinToYouTradeService(this);
  }

}
