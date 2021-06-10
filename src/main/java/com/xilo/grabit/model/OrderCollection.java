package com.xilo.grabit.model;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderCollection extends AbstractPersistable<Long> implements Serializable{
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Order order;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Food food;
    private int quantity;

    public OrderCollection(){}

    public OrderCollection(Order order, Food food, int quantity) {
        this.order = order;
        this.food = food;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderCollection{" +
                ", order=" + order +
                ", food=" + food +
                ", quantity=" + quantity +
                '}';
    }
}
