package com.example.FBJV24001115synergy7firbinfudch4.repository;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
    List<Merchant> findByOpen(boolean isOpen);
    @Query(value = "SELECT p.product_name, m.merchant_name FROM product p INNER JOIN merchant m ON p.merchant_id = m.id WHERE m.merchant_name = :merchantName", nativeQuery = true)
    List<Object[]> findAllProductsByMerchantName(@Param("merchantName") String merchantName);
}
