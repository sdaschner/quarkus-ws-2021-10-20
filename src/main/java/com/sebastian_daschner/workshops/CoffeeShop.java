package com.sebastian_daschner.workshops;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CoffeeShop {

    @Inject
    CoffeeOrderRepository orderRepository;

    @Transactional
    public void orderCoffee(CoffeeOrder order) {
        orderRepository.persist(order);
    }

    @Transactional
    public List<CoffeeOrder> listOrders() {
        return orderRepository.listAll();
    }

}
