package com.xilo.grabit.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public abstract class OrderCollection implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
                "id=" + id +
                ", order=" + order +
                ", food=" + food +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderCollection that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
