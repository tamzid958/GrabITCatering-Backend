package com.xilo.grabit.controller;
import com.xilo.grabit.service.OrderCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order_collections/")
public class OrderCollectionController {
    private final OrderCollectionService orderCollectionService;

    @Autowired
    public OrderCollectionController(OrderCollectionService orderCollectionService) {
        this.orderCollectionService = orderCollectionService;
    }
}
