package com.binarfud.FBJV24001115synergy7firbinfudch7.service;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.OrderDetail;

import java.util.List;
import java.util.UUID;

public interface OrderDetailService {
    OrderDetail addOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(UUID id);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(UUID id);
}
