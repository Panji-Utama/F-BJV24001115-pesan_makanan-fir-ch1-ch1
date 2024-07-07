package com.example.FBJV24001115synergy7firbinfudch6.repository;

import com.example.FBJV24001115synergy7firbinfudch6.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {

}
