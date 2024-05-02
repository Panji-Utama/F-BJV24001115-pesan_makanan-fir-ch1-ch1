package com.example.FBJV24001115synergy7firbinfudch4.service;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(UUID orderId);
    List<Order> getAllOrders();
}
