package com.example.FBJV24001115synergy7firbinfudch4.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserView {

    public int displayMainMenu(Scanner scanner) {
        System.out.println("\nWelcome to our application");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String[] getRegistrationDetails(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        return new String[]{username, password, email};
    }

    public String[] getLoginDetails(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }

    public void displayLoginSuccess() {
        System.out.println("Login successful.");
    }

    public void displayLoginFailed() {
        System.out.println("Login failed.");
    }

    public void displayInvalidChoice() {
        System.out.println("Invalid choice. Please try again.");
    }

    public void displayWelcome() {
        System.out.println("""
                ================================================
                Selamat datang di Binarfud - Panji
                ================================================
                Silahkan pilih service berdasarkan model:
                
                1. Merchant
                2. Products
                3. Users
                4. Order
                
                Pilihan anda:
                """);
    }

    public void displayUserMenu() {
        System.out.println("User Services:");
        System.out.println("1. Create User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.println("4. Search Username");
        System.out.println("0. Return to Main Menu");
        System.out.println("\nYour choice: ");
    }
}
