package com.sebastian_daschner.workshops;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CoffeeShop {

    @Inject
    CountriesServiceV2 service;

    @Inject
    @ConfigProperty(name = "version")
    String version;

    @Inject
    @ConfigProperty(name = "versions")
    List<String> versions;

    public void orderCoffee(CoffeeOrder order) {
        // ...
        System.out.println("coffee ordered: " + order.getType());
        System.out.println("order = " + order);

        System.out.println("countryNames = " + service.getCountryNames());
    }

    public List<CoffeeOrder> listOrders() {
        System.out.println("versions = " + versions);
        String version = ConfigProvider.getConfig().getValue("version", String.class);
        System.out.println("version = " + version);

        return List.of(new CoffeeOrder(CoffeeOrder.OrderType.ESPRESSO),
                new CoffeeOrder(CoffeeOrder.OrderType.CAPPUCCINO));
    }

}
