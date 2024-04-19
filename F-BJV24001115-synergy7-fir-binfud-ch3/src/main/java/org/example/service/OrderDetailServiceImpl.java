package org.example.service;

import org.example.model.entity.OrderDetail;
import org.example.service.OrderDetailService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderDetailServiceImpl implements OrderDetailService {
    private final Map<UUID, List<OrderDetail>> detailsByOrder = new HashMap<>();

    @Override
    public OrderDetail addOrderDetail(UUID orderId, UUID productId, int quantity) {
        double price = 100.0; // Simulate price retrieval
        OrderDetail detail = new OrderDetail(UUID.randomUUID(), orderId, productId, quantity, price * quantity);
        detailsByOrder.computeIfAbsent(orderId, k -> new ArrayList<>()).add(detail);
        return detail;
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrder(UUID orderId) {
        return detailsByOrder.getOrDefault(orderId, new ArrayList<>());
    }
}
