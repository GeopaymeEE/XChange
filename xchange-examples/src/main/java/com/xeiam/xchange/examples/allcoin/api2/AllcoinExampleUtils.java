package com.xeiam.xchange.examples.allcoin.api2;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.allcoin.AllcoinExchange;

public class AllcoinExampleUtils {
	public static Exchange createExchange(){
		ExchangeSpecification exSpec = new ExchangeSpecification(AllcoinExchange.class);
	    exSpec.setApiKey("");
	    exSpec.setSecretKey("");

	    return ExchangeFactory.INSTANCE.createExchange(exSpec);
	}
}
