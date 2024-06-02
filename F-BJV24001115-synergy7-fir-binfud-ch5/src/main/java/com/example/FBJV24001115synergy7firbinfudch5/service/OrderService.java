package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.OrdersDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Orders;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrdersDTO createOrder(Orders order);
    List<OrdersDTO> getAllOrders();
    OrdersDTO getOrderById(UUID id);
}
