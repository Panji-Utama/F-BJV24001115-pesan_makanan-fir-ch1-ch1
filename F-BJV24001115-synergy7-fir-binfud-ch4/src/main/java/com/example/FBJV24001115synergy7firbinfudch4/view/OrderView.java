package com.example.FBJV24001115synergy7firbinfudch4.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class OrderView {

    public void displayOrderMenu() {
        System.out.println("Order Services:");
        System.out.println("1. Create Order");
        System.out.println("2. Update Order");
        System.out.println("3. Display Orders");
        System.out.println("0. Return to Main Menu");
    }

    public int getOrderChoice(Scanner scanner) {
        return scanner.nextInt();
    }
}
