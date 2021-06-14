package com.xilo.grabit.service;

import com.xilo.grabit.model.Order;
import com.xilo.grabit.respository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order create(Order newOrder) {
        Order order = new Order(
                newOrder.getFirstName(),
                newOrder.getLastName(),
                newOrder.getCompanyName(),
                newOrder.getStreetAddress(),
                newOrder.getPhone(),
                newOrder.getNotes(),
                newOrder.getPaymentMethod(),
                newOrder.getSubTotal(),
                newOrder.getTransactionId()
        );
        orderRepository.save(order);
        return order;
    }

    public Order update(Long id, Order updatedOrder) {
        return orderRepository.findById(id).map(
            order -> {
                order.setFirstName(updatedOrder.getFirstName());
                order.setLastName(updatedOrder.getLastName());
                order.setCompanyName(updatedOrder.getCompanyName());
                order.setStreetAddress(updatedOrder.getStreetAddress());
                order.setPhone(updatedOrder.getPhone());
                order.setNotes(updatedOrder.getNotes());
                order.setPaymentMethod(updatedOrder.getPaymentMethod());
                order.setSubTotal(updatedOrder.getSubTotal());
                orderRepository.save(order);
                return order;
            }
        ).orElse(null);
    }

    public String deleteById(Long id) {
        orderRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
