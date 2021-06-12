package com.xilo.grabit.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public abstract class Category implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String img;
    private String title;
    private String subtitle;
    @OneToMany(mappedBy = "category")
    private Collection<Food> food;

    public Category(){}

    public Category(String img, String title, String subtitle) {
        this.img = img;
        this.title = title;
        this.subtitle = subtitle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Collection<Food> getFood() {
        return food;
    }

    public void setFood(Collection<Food> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", food=" + food +
                '}';
    }

    @Override
    public boolean equals(Object c) {
        if (this == c) return true;
        if (!(c instanceof Category that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
