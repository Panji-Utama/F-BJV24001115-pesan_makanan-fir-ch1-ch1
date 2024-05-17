package com.example.FBJV24001115synergy7firbinfudch5.repository;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
