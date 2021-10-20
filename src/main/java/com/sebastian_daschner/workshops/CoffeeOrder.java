package com.sebastian_daschner.workshops;

import javax.json.bind.annotation.JsonbTransient;
import java.time.Instant;

public class CoffeeOrder {

    private OrderType type;
    private Instant created;
    @JsonbTransient
    private int number = 123;

    public CoffeeOrder() {
    }

    public CoffeeOrder(OrderType type) {
        this.type = type;
        this.created = Instant.now();
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CoffeeOrder{" +
               "type=" + type +
               ", created=" + created +
               ", number=" + number +
               '}';
    }

    public enum OrderType {

        CAPPUCCINO, FILTER, ESPRESSO

    }
}
