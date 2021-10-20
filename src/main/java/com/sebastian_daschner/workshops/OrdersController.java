package com.sebastian_daschner.workshops;

import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("orders.html")
@Produces(MediaType.TEXT_HTML)
public class OrdersController {

    @Location("orders.html")
    Template template;

    @Inject
    CoffeeShop coffeeShop;

    @GET
    public TemplateInstance orders() {
        List<CoffeeOrder> orders = coffeeShop.listOrders();
        return template.data("orders", orders);
    }

}
