package com.sebastian_daschner.workshops.orders.boundary;

import com.sebastian_daschner.workshops.orders.entity.CoffeeOrder;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("coffees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class CoffeesResource {

    @Inject
    CoffeeShop coffeeShop;

    @Inject
    String config;

    @GET
    public List<CoffeeOrder> getOrders() {
        System.out.println("config = " + config);
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
