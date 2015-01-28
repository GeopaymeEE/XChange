package com.xeiam.xchange.examples.allcoin.api2;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.allcoin.AllcoinExchange;

public class AllcoinExampleUtils {

  public static Exchange createExchange() {

    return ExchangeFactory.INSTANCE.createExchange(AllcoinExchange.class.getName());
  }
}
