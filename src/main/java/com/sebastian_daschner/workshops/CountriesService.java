package com.sebastian_daschner.workshops;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/v3.1")
@RegisterRestClient(baseUri = "https://restcountries.com/")
public interface CountriesService {

    @GET
    @Path("/all")
    JsonArray listCountries();

}
