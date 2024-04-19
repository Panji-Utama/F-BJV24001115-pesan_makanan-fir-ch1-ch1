package org.example.model.entity;

import java.util.UUID;

public class Merchant {
    private UUID id;
    private String merchantName;
    private String merchantLocation;
    private Boolean open;

    public Merchant(UUID merchantId, String name, String location, boolean isOpen) {
        this.id = merchantId;
        this.merchantName = name;
        this.merchantLocation = location;
        this.open = isOpen;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantLocation() {
        return merchantLocation;
    }

    public void setMerchantLocation(String merchantLocation) {
        this.merchantLocation = merchantLocation;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
