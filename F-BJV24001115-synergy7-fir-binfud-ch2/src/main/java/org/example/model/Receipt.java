package org.example.model;

import java.util.List;

public class Receipt {
    private final List<Items> items;
    private final int totalQuantity;
    private final int totalPrice;

    public Receipt(List<Items> foods, int totalQuantity, int totalPrice) {
        this.items = foods;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public List<Items> getItems() {
        return items;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
