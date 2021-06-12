package com.xilo.grabit.service;
import com.xilo.grabit.respository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
