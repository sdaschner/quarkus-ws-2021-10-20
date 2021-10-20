package com.sebastian_daschner.workshops;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonValue;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CoffeeShop {

    @Inject
    CountriesServiceV2 service;

    public void orderCoffee(CoffeeOrder order) {
        // ...
        System.out.println("coffee ordered: " + order.getType());
        System.out.println("order = " + order);

        System.out.println("countryNames = " + service.getCountryNames());
    }

    public List<CoffeeOrder> listOrders() {
        return List.of(new CoffeeOrder(CoffeeOrder.OrderType.ESPRESSO),
                new CoffeeOrder(CoffeeOrder.OrderType.CAPPUCCINO));
    }

}
