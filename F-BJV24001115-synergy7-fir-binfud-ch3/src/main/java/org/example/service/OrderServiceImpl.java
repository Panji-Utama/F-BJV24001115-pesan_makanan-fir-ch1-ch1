package org.example.service;

import org.example.model.entity.Order;
import org.example.service.OrderService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    private final Map<UUID, Order> orders = new HashMap<>();

    @Override
    public Order createOrder(UUID userId, String destinationAddress) {
        UUID orderId = UUID.randomUUID();
        Order order = new Order(orderId, LocalDateTime.now(), destinationAddress, userId, false);
        orders.put(orderId, order);
        return order;
    }

    @Override
    public void completeOrder(UUID orderId) {
        if (orders.containsKey(orderId)) {
            Order order = orders.get(orderId);
            order.setCompleted(true);
        }
    }
}
