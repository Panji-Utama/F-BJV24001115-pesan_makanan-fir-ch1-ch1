package com.binarfud.FBJV24001115synergy7firbinfudch7.repository;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Orders, UUID> {

}
