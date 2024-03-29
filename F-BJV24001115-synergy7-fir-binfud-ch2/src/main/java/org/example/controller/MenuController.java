package org.example.controller;

import org.example.model.Cart;
import org.example.view.MenuView;
import org.example.util.InputHandler;

import java.util.Scanner;

public class MenuController {

    private CartController cartController;
    private MenuView menuView;
    private Scanner scanner;

    public MenuController(CartController cartController, MenuView menuView, Scanner scanner) {
        this.cartController = cartController;
        this.menuView = menuView;
        this.scanner = scanner;
    }

    // In MenuController.java
    public void processUserSelection() {
        menuView.displayMenu();
        System.out.print("Masukkan pilihan anda: ");
        int choice = InputHandler.getInputChoice(scanner);

        while (choice != 0) {
            if (choice == -1) {
                menuView.displayInputMismatchError();
            } else {
                int quantity;
                switch (choice) {
                    case 1:
                        quantity = menuView.getQuantityFromUser();
                        cartController.addFoodToCart("Lontong Kari", 18000, quantity);
                        break;
                    case 2:
                        quantity = menuView.getQuantityFromUser();
                        cartController.addFoodToCart("Bakso", 12000, quantity);
                        break;
                    case 3:
                        quantity = menuView.getQuantityFromUser();
                        cartController.addFoodToCart("Nasi Goreng", 15000, quantity);
                        break;
                    case 4:
                        quantity = menuView.getQuantityFromUser();
                        cartController.addFoodToCart("Indomie", 8000, quantity);
                        break;
                    case 99:
                        cartController.checkout();
                        break;
                    default:
                        menuView.displayInvalidChoiceMessage();
                }
            }
            menuView.displayMenu();
            System.out.print("Masukkan pilihan anda: ");
            choice = InputHandler.getInputChoice(scanner);
        }
    }
}
