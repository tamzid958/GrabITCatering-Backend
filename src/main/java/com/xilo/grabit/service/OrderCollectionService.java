package com.xilo.grabit.service;
import com.xilo.grabit.respository.OrderCollectionRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class OrderCollectionService {
    private final OrderCollectionRepository orderCollectionRepository;

    public OrderCollectionService(OrderCollectionRepository orderCollectionRepository) {
        this.orderCollectionRepository = orderCollectionRepository;
    }

}
