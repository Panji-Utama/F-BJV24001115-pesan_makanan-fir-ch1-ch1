package com.example.FBJV24001115synergy7firbinfudch5.repository;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
//    @Query(value = "SELECT p.product_name, m.merchant_name FROM product p INNER JOIN merchant m ON p.merchant_id = m.id WHERE m.merchant_name = :merchantName", nativeQuery = true)

//    @Query(value = "INSERT INTO product (price, product_name, merchant_id) VALUES (:price, :product_name, :merchant_id)", nativeQuery = true)
//    public void createProduct(Double price, String productName, UUID merchantId);
}
