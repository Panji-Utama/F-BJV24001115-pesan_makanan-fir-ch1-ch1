package org.example.service;

import org.example.model.entity.Product;
import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product createProduct(String name, double price, UUID merchantId);
    List<Product> getProductsByMerchant(UUID merchantId);
}
