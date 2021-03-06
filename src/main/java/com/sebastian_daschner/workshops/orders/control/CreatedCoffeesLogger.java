package com.sebastian_daschner.workshops.orders.control;

import com.sebastian_daschner.workshops.orders.entity.CoffeeOrder;

import javax.enterprise.event.ObservesAsync;
import java.util.concurrent.locks.LockSupport;

public class CreatedCoffeesLogger {

    public void onCreatedCoffee(@ObservesAsync CoffeeOrder order) {
        LockSupport.parkNanos(2_000_000_000L);
        System.out.println("order has been created = " + order);
    }

}
