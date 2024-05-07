package com.example.FBJV24001115synergy7firbinfudch4.repository;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.OrderDetail;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
//    List<OrderDetail> findByOrderId(UUID orderId);
}
