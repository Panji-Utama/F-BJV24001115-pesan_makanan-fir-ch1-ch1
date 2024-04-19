package org.example.service;

import org.example.model.entity.OrderDetail;

import java.util.List;
import java.util.UUID;

public interface OrderDetailService {
    OrderDetail addOrderDetail(UUID orderId, UUID productId, int quantity);
    List<OrderDetail> getOrderDetailsByOrder(UUID orderId);
}
