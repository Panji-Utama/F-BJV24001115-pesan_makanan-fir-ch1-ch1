package org.example.service;

import org.example.model.entity.Product;
import org.example.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {
    private final Map<UUID, List<Product>> productsByMerchant = new HashMap<>();

    @Override
    public Product createProduct(String name, double price, UUID merchantId) {
        UUID productId = UUID.randomUUID();
        Product product = new Product(productId, name, price, merchantId);
        productsByMerchant.computeIfAbsent(merchantId, k -> new ArrayList<>()).add(product);
        return product;
    }

    @Override
    public List<Product> getProductsByMerchant(UUID merchantId) {
        return productsByMerchant.getOrDefault(merchantId, new ArrayList<>());
    }
}
