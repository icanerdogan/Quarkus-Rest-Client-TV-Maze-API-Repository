package org.ibrahimcanerdogan.proxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.ibrahimcanerdogan.model.TvSeries;

@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://api.tvmaze.com/")
public interface TvSeriesProxy {

    @GET
    @Path("/shows")
    TvSeries get(@QueryParam("q") String query);
}