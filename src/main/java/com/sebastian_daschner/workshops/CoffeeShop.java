package com.sebastian_daschner.workshops;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CoffeeShop {

    @Inject
    CoffeeOrderRepository orderRepository;

    @Inject
    String somethingElse;

    @Inject
    Event<CoffeeOrder> createdOrders;

    @PostConstruct
    void init() {
        System.out.println("CoffeeShop.init");
        System.out.println(" init: config = " + somethingElse);
    }

    @Transactional
    public void orderCoffee(CoffeeOrder order) {
        orderRepository.persist(order);
        createdOrders.fireAsync(order);
    }

    @Transactional
    public List<CoffeeOrder> listOrders() {

        System.out.println("config = " + somethingElse);

        return orderRepository.listAll();
    }

}
