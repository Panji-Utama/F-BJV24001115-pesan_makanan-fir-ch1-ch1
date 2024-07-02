package com.example.FBJV24001115synergy7firbinfudch6.repository;

import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
