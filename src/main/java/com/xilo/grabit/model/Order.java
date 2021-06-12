package com.xilo.grabit.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public abstract class Order implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String streetAddress;
    private String phone;
    private String notes;
    private String paymentMethod;
    private double subTotal;
    private String transactionId;
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Set<OrderCollection> orderCollections = new HashSet<>();

    public Order(){}

    public Order(String firstName, String lastName, String companyName, String streetAddress, String phone, String notes, String paymentMethod, double subTotal, String transactionId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.streetAddress = streetAddress;
        this.phone = phone;
        this.notes = notes;
        this.paymentMethod = paymentMethod;
        this.subTotal = subTotal;
        this.transactionId = transactionId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Set<OrderCollection> getOrderCollections() {
        return orderCollections;
    }

    public void setOrderCollections(Set<OrderCollection> orderCollections) {
        this.orderCollections = orderCollections;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", notes='" + notes + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", subTotal=" + subTotal +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
