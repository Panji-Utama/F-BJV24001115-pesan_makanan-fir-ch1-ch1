package com.example.FBJV24001115synergy7firbinfudch5.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class OrderView {

    public void displayOrderMenu() {
        System.out.println("Order Services:");
        System.out.println("1. Create Order");
        System.out.println("2. Display Orders");
        System.out.println("0. Return to Main Menu");
        System.out.println("\nYour choice: ");
    }

    public int getOrderChoice(Scanner scanner) {
        return scanner.nextInt();
    }
}
