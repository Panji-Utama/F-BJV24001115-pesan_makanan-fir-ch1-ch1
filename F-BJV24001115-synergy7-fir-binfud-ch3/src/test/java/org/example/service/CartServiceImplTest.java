package org.example.service;

import org.example.model.Food;
import org.example.model.Items;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceImplTest {
    private CartService cartService;

    @BeforeEach
    void initCartService() {
        cartService = new CartServiceImpl();
    }

    @Test
    void clearCart_ShouldEmptyCart() {
        Items foodItem = new Food("Test Food", 10, 1);
        cartService.addFoodToCart(foodItem);
        cartService.clearCart();

        assertTrue(cartService.getCartItems().isEmpty(), "Cart should be empty after clearCart is called.");
    }
}