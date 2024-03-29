package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Food> items = new ArrayList<>();

    public void addItem(Food item) {
        items.add(item);
    }

    public List<Food> getItems() {
        return new ArrayList<>(items);
    }

    public int getTotalQuantity() {
        return items.stream().mapToInt(Food::getQty).sum();
    }

    public int getTotalPrice() {
        return items.stream().mapToInt(Food::getTotalPrice).sum();
    }

    public void clearCart() {
        items.clear();
    }
}
