package org.example.service;

import org.example.model.Items;

import java.util.List;

public interface CartService {
    void addFoodToCart(Items item);
    boolean isCartEmpty();
    void clearCart();
    void generateReceipt();
    void displayCartContents();
    List<Items> getCartItems();
}
