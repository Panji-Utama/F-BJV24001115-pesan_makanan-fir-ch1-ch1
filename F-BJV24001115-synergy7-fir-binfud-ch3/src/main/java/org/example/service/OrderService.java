package org.example.service;

import org.example.model.entity.Order;
import java.util.UUID;

public interface OrderService {
    Order createOrder(UUID userId, String destinationAddress);
    void completeOrder(UUID orderId);
}
