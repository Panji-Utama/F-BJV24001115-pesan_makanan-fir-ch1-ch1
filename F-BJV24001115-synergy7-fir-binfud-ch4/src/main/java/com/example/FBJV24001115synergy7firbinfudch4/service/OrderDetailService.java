package com.example.FBJV24001115synergy7firbinfudch4.service;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.OrderDetail;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OrderDetailService {
    OrderDetail addOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(UUID id);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(UUID id);
}
