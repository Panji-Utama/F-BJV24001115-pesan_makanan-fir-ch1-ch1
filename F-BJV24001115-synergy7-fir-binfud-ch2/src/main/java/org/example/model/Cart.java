package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Items> itemsCart = new ArrayList<>();

    public void addItem(Items item) {
        itemsCart.add(item);
    }

    public List<Items> getItemsCart() {
        return new ArrayList<>(itemsCart);
    }

    public void clearCart() {
        itemsCart.clear();
    }
}
