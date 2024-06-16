package com.binarfud.FBJV24001115synergy7firbinfudch7.service;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.Orders;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Orders createOrder(Orders order);

    Orders getOrderById(UUID id);
    List<Orders> getAllOrders();
}