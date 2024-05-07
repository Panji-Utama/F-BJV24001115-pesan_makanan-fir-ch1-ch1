package com.example.FBJV24001115synergy7firbinfudch4.service;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.OrderDetail;
import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Orders;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Orders createOrder(String destinationAddress, UUID userId, List<OrderDetail> details);
//    Orders updateOrder(Orders order);
//    void deleteOrder(UUID orderId);
//    Orders getOrderById(UUID orderId);
    List<Orders> getAllOrders();
}