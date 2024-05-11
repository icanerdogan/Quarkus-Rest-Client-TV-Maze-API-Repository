package org.ibrahimcanerdogan;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.ibrahimcanerdogan.model.Episode;
import org.ibrahimcanerdogan.model.TvSeries;
import org.ibrahimcanerdogan.proxy.EpisodeProxy;
import org.ibrahimcanerdogan.proxy.TvSeriesProxy;

import java.util.ArrayList;
import java.util.List;

@Path("/tvseries")
public class TvMazeResource {

    @RestClient
    TvSeriesProxy proxy;
    @RestClient
    EpisodeProxy episodeProxy;

    private List<TvSeries> tvSeriesList = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title) {
        TvSeries tvSeries = proxy.get(title);
        List<Episode> episodes = episodeProxy.get(tvSeries.getId());
        tvSeriesList.add(tvSeries);
        return Response.ok(episodes).build();
    }
}