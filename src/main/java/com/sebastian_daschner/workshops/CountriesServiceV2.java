package com.sebastian_daschner.workshops;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CountriesServiceV2 {

//    @Inject
//    @RestClient
//    CountriesService countriesService;

    public List<String> getCountryNames() {
        // or use JAX-RS client

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://restcountries.com/v3.1/all");
        JsonArray array = target.request(MediaType.APPLICATION_JSON_TYPE).get(JsonArray.class);
        return array.getValuesAs(JsonValue::asJsonObject)
                .stream()
                .map(jsonObject -> jsonObject.getJsonObject("name").getString("common"))
                .collect(Collectors.toList());


        // or this:

//        return countriesService.listCountries().getValuesAs(JsonValue::asJsonObject)
//                .stream()
//                .map(jsonObject -> jsonObject.getJsonObject("name").getString("common"))
//                .collect(Collectors.toList());
    }

}
