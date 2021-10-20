package com.sebastian_daschner.workshops.orders.control;

import com.sebastian_daschner.workshops.orders.entity.CoffeeOrder;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CoffeeOrderRepository implements PanacheRepository<CoffeeOrder> {

    public List<CoffeeOrder> listAllEspressos() {
        return list("type = ?1", CoffeeOrder.OrderType.ESPRESSO);
    }

}
