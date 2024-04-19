package org.example.controller;

import org.example.util.InputHandler;
import org.example.view.MenuView;

import java.util.Scanner;
import java.util.UUID;

public class MenuController {

    private final OrderController orderController;
    private final MenuView menuView;
    private final Scanner scanner;

    public MenuController(OrderController orderController, MenuView menuView, Scanner scanner) {
        this.orderController = orderController;
        this.menuView = menuView;
        this.scanner = scanner;
    }

    public void processUserSelection() {
        int choice;
        do {
            menuView.displayMenu();
            choice = InputHandler.getInputChoice(scanner);
            switch (choice) {
                case 1:
                    menuView.promptForOrderDetails();
//                    String userId = scanner.next();
                    UUID userId = UUID.randomUUID();
                    String address = scanner.next();
                    orderController.createOrder(userId, address);
                    break;
                case 99:
                    UUID orderId = UUID.randomUUID();
                    orderController.completeOrder(orderId);
                    break;
                default:
                    menuView.displayInvalidChoiceMessage();
                    break;
            }
        } while (choice != 0);
        menuView.displayExitMessage();
    }
}
