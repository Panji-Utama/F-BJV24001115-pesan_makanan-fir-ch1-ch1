package org.example.view;

import java.util.Scanner;

public class MenuView {

    private final Scanner scanner;

    public MenuView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Place an order");
        System.out.println("99. Complete an order");
        System.out.println("0. Exit");
    }

    public void displayOrderConfirmation() {
        System.out.println("Order has been placed successfully.");
    }

    public void displayOrderCompletion() {
        System.out.println("Order has been completed successfully.");
    }

    public void displayInvalidChoiceMessage() {
        System.out.println("Invalid choice. Please try again.");
    }

    public void displayExitMessage() {
        System.out.println("Exiting application...");
    }

    public void promptForOrderDetails() {
        System.out.println("Enter user ID and destination address:");
    }
}
