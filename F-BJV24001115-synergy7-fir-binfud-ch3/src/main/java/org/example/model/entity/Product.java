package org.example.model.entity;

import java.util.UUID;

public class Product {
    private UUID id;
    private String productName;
    private Double price;
    private UUID merchantId;

    public Product(UUID id, String productName, Double price, UUID merchantId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.merchantId = merchantId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UUID getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(UUID merchantId) {
        this.merchantId = merchantId;
    }
}
