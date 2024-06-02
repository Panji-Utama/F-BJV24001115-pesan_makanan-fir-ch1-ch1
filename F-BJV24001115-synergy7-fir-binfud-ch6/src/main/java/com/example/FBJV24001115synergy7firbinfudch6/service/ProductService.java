package com.example.FBJV24001115synergy7firbinfudch6.service;

import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(UUID productId);

    Product getProductById(UUID productId);

    List<Product> getAllProducts();
}
