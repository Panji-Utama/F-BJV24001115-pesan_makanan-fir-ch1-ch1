package com.example.FBJV24001115synergy7firbinfudch4.service;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Orders;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Orders createOrder(Orders order);
    Orders updateOrder(Orders order);
    void deleteOrder(UUID orderId);
    Orders getOrderById(UUID orderId);
    List<Orders> getAllOrders();
}