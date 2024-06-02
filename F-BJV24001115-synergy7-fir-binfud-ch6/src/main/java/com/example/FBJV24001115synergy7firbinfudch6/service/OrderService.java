package com.example.FBJV24001115synergy7firbinfudch6.service;

import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Orders;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Orders createOrder(Orders order);

    Orders getOrderById(UUID id);
    List<Orders> getAllOrders();
}