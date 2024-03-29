package org.example;

import org.example.controller.CartController;
import org.example.controller.MenuController;
import org.example.model.Cart;
import org.example.service.CartService;
import org.example.view.MenuView;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuView menuView = new MenuView(scanner);

        Cart cart = new Cart(); // The model
        CartService cartService = new CartService(); // The service handling business logic for the cart

        CartController cartController = new CartController(cart, cartService, menuView); // Controller that uses the service

        MenuController menuController = new MenuController(cartController, menuView, scanner); // Controller for handling menu actions

        menuController.processUserSelection(); // Start the interaction process

        scanner.close(); // Cleanup resources
        menuView.displayExitMessage(); // Display exit message
    }
}
