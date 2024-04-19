package org.example.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private UUID id;
    private LocalDateTime orderTime;
    private String destinationAddress;
    private UUID userId;
    private Boolean completed;

    public Order(UUID id, LocalDateTime orderTime, String destinationAddress, UUID userId, Boolean completed) {
        this.id = id;
        this.orderTime = orderTime;
        this.destinationAddress = destinationAddress;
        this.userId = userId;
        this.completed = completed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
