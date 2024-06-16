package com.binarfud.FBJV24001115synergy7firbinfudch7.repository;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
