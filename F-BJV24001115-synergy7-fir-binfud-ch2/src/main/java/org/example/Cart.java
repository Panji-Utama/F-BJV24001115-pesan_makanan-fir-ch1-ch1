package org.example;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Food> items;
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

    public ArrayList<Food> getItems() {
        return items;
    }
}
