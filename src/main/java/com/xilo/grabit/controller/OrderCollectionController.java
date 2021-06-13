package com.xilo.grabit.controller;
import com.xilo.grabit.service.OrderCollectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order_collections/")
public class OrderCollectionController {
    private final OrderCollectionService orderCollectionService;

    public OrderCollectionController(OrderCollectionService orderCollectionService) {
        this.orderCollectionService = orderCollectionService;
    }
}
