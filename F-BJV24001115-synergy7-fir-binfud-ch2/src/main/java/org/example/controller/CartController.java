package org.example.controller;

import org.example.model.Cart;
import org.example.service.CartService;
import org.example.view.MenuView;

public class CartController {

    private final Cart cart;
    private final CartService cartService;
    private final MenuView menuView;

    public CartController(Cart cart, CartService cartService, MenuView menuView) {
        this.cart = cart;
        this.cartService = cartService;
        this.menuView = menuView;
    }

    public void addFoodToCart(String name, int price, int qty) {
        cartService.addFoodToCart(cart, name, price, qty);
        if (qty > 0) {
            menuView.displayAdditionConfirmation(qty, name);
        } else {
            menuView.displayInvalidQuantityMessage();
        }
    }

    public void checkout() {
        cartService.checkout(cart);
        // Any post-checkout logic if needed
    }
}
