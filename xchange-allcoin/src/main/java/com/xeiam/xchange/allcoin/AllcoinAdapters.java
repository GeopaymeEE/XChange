package com.xeiam.xchange.allcoin;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTicker;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTickerReturn;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;

public class AllcoinAdapters {
	
	private AllcoinAdapters(){
		
	}
	
	public static Ticker adaptTicker(AllcoinTickerReturn allcoinTickerReturnData, CurrencyPair currencyPair){
		
		AllcoinTicker data = allcoinTickerReturnData.getData();
		
		BigDecimal bid = data.getBid();
    BigDecimal ask = data.getAsk();
    BigDecimal high = data.getHigh();
    BigDecimal low = data.getLow();
    BigDecimal last = data.getLast();
    BigDecimal volume = data.getVolume();
    Date timestamp = new Date();

    return new Ticker.Builder().currencyPair(currencyPair).last(last).bid(bid).ask(ask).high(high).low(low).volume(volume).timestamp(timestamp).build();
	}
	
	
}
