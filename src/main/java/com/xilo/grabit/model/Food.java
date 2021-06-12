package com.xilo.grabit.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foods")
public abstract class Food implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String img;
    private String title;
    private double price;
    private int avgReview;
    private boolean available;
    private String description;
    @ManyToOne
    private Category category;
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Set<OrderCollection> orderCollections = new HashSet<>();

    public Food(){}

    public Food(String img, String title, double price, int avgReview, boolean available, String description) {
        this.img = img;
        this.title = title;
        this.price = price;
        this.avgReview = avgReview;
        this.available = available;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvgReview() {
        return avgReview;
    }

    public void setAvgReview(int avgReview) {
        this.avgReview = avgReview;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderCollection> getOrderCollections() {
        return orderCollections;
    }

    public void setOrderCollections(Set<OrderCollection> orderCollections) {
        this.orderCollections = orderCollections;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", avgReview=" + avgReview +
                ", available=" + available +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;

        Food food = (Food) o;

        return getId().equals(food.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
