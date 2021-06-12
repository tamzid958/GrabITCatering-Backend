package com.xilo.grabit.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderCollections")
public abstract class OrderCollection implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private int quantity;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Food food;

    public OrderCollection(){}

    public OrderCollection(int quantity) {
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
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderCollection)) return false;

        OrderCollection orderCollection = (OrderCollection) o;

        return getId().equals(orderCollection.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
