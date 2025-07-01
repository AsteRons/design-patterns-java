package com.proxy.order;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceProxy implements OrderService {
    private final OrderService realService;
    private final Map<Long, Order> cache = new HashMap<>();

    public OrderServiceProxy(OrderService realService) {
        this.realService = realService;
    }

    @Override
    public Order getOrderById(Long id) {
        System.out.println("[LOG] Requesting order with ID: " + id);

        if (cache.containsKey(id)) {
            System.out.println("[CACHE] Returning cached order.");
            return cache.get(id);
        }

        Order order = realService.getOrderById(id);
        cache.put(id, order);
        return order;
    }
}
