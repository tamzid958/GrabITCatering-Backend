package com.xilo.grabit.model;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Category extends AbstractPersistable<Long> implements Serializable{
    private String img;
    private String title;
    private String subtitle;
    @OneToMany(mappedBy = "category")
    private Collection<Food> food;

    public Category(){}

    public Category(String img, String title, String subtitle, Collection<Food> food) {
        this.img = img;
        this.title = title;
        this.subtitle = subtitle;
        this.food = food;
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
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", food=" + food +
                '}';
    }
}
