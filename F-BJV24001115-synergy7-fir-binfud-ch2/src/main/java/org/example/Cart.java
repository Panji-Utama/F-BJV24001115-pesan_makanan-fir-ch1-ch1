package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final ArrayList<Food> items;
    private int totalQuantity;
    private int totalPrice;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Food item) {
        items.add(item);
        totalQuantity += item.getQty();
        totalPrice += item.getTotalPrice();
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Food> getItems() {
        return items;
    }
}
