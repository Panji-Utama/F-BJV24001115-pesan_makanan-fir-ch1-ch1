package com.example.FBJV24001115synergy7firbinfudch5.repository;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.OrderDetail;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {

}
