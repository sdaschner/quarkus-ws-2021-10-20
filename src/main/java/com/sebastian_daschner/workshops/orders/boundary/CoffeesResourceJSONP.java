package com.sebastian_daschner.workshops.orders.boundary;

import com.sebastian_daschner.workshops.orders.entity.CoffeeOrder;
import com.sebastian_daschner.workshops.orders.boundary.CoffeeShop;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("coffees/jsonp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoffeesResourceJSONP {

    @Inject
    CoffeeShop coffeeShop;

    @GET
    public JsonArray getOrders() {
        List<CoffeeOrder> coffeeOrders = coffeeShop.listOrders();

        return coffeeOrders.stream()
                .map(o -> Json.createObjectBuilder()
                        .add("type", o.type.name())
                        .add("created", o.created.toString())
                        .add("number", Json.createObjectBuilder()
                                .add("number", o.number))
                        .add("_self", "http://localhost:8080/coffees/123")
                        .build())
                .collect(JsonCollectors.toJsonArray());
    }

}
