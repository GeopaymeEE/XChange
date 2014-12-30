package com.xeiam.xchange.allcoin;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinAllTickersReturn;
import com.xeiam.xchange.allcoin.api2.dto.marketdata.AllcoinTickerReturn;

@Path("/api2/")
@Produces(MediaType.APPLICATION_JSON)
public interface Allcoin {

  /**
   * @return Allcoin ticker
   * @throws IOException
   */
  @GET
  @Path("pair/{currencyPair}")
  public AllcoinTickerReturn getAllcoinTicker(@PathParam("currencyPair") String currencyPair) throws IOException;

  /**
   * @return All AllCoin tickers
   * @throws IOException
   */
  @GET
  @Path("pairs")
  public AllcoinAllTickersReturn getAllcoinTickers() throws IOException;

}
