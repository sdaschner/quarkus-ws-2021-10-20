package com.sebastian_daschner.workshops;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("coffees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoffeesResource {

    @Inject
    CoffeeShop coffeeShop;

    @GET
    public List<CoffeeOrder> getOrders() {
        return coffeeShop.listOrders();
    }

    // for explicit mapping
//    @Inject
//    Jsonb jsonb;

    @POST
    public void orderCoffee(CoffeeOrder order) {
        coffeeShop.orderCoffee(order);
    }

}
