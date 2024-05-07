package com.example.FBJV24001115synergy7firbinfudch5.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductView {

    public void displayProductMenu() {
        System.out.println("Product Services:");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Show Available Products");
        System.out.println("0. Return to Main Menu");
        System.out.println("\nYour choice: ");
    }

    public int getProductChoice(Scanner scanner) {
        return scanner.nextInt();
    }
}
