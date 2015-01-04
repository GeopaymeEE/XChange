package com.xeiam.xchange.huobi;

import com.xeiam.xchange.huobi.dto.marketdata.HuobiTickerReturn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Yingzhe on 12/30/2014.
 */
@Path("staticmarket")
@Produces(MediaType.APPLICATION_JSON)
public interface Huobi {
    @GET
    @Path("ticker_{baseCurrency}_json.js")
    public HuobiTickerReturn getTicker(@PathParam("baseCurrency") String baseCurrency) throws IOException;
}
