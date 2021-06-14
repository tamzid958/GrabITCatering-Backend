package com.xilo.grabit.service;

import com.xilo.grabit.model.OrderCollection;
import com.xilo.grabit.respository.FoodRepository;
import com.xilo.grabit.respository.OrderCollectionRepository;
import com.xilo.grabit.respository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCollectionService {
    private final OrderCollectionRepository orderCollectionRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;

    public OrderCollectionService(OrderCollectionRepository orderCollectionRepository, FoodRepository foodRepository, OrderRepository orderRepository) {
        this.orderCollectionRepository = orderCollectionRepository;
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
    }

    public List<OrderCollection> findAll() {
        return orderCollectionRepository.findAll();
    }

    public OrderCollection findById(Long id) {
        return orderCollectionRepository.findById(id).orElse(null);
    }

    public OrderCollection create(OrderCollection newOrderCollection) {
        return foodRepository.findById(newOrderCollection.getFood().getId()).flatMap(
                food ->
                orderRepository.findById(newOrderCollection.getOrder().getId()).map(
                    order -> {
                        OrderCollection orderCollection = new OrderCollection(
                                newOrderCollection.getQuantity(),
                                order,
                                food
                        );
                        orderCollectionRepository.save(orderCollection);
                        return orderCollection;
                    }
                )).orElse(null);

    }

    public OrderCollection update(Long id, OrderCollection updatedOrderCollection) {
        return orderCollectionRepository.findById(id).flatMap(
            orderCollection -> foodRepository.findById(updatedOrderCollection.getFood().getId()).flatMap(
                food -> orderRepository.findById(updatedOrderCollection.getFood().getId()).map(
                     order -> {
                         orderCollection.setQuantity(updatedOrderCollection.getQuantity());
                         orderCollection.setOrder(order);
                         orderCollection.setFood(food);
                         orderCollectionRepository.save(orderCollection);
                         return orderCollection;
                     }
                ))).orElse(null);
    }

    public String deleteById(Long id) {
        orderCollectionRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
