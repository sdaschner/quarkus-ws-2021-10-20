package com.sebastian_daschner.workshops;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "coffee_orders")
public class CoffeeOrder {

    @Id
    @GeneratedValue
    @JsonbTransient
    public long id;

    @Enumerated(EnumType.STRING)
    public OrderType type;

    public Instant created;

    @JsonbTransient
    public int number = 123;

    @PrePersist
    void updateDate() {
        created = Instant.now();
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
