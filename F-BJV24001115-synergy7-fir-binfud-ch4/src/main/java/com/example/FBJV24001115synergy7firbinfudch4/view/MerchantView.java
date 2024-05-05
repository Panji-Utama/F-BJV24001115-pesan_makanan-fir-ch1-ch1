package com.example.FBJV24001115synergy7firbinfudch4.view;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MerchantView {

    public void displayMerchantMenu() {
        System.out.println("Merchant Services:");
        System.out.println("1. Add Merchant");
        System.out.println("2. Edit Merchant Status");
        System.out.println("3. Show Open Merchants");
        System.out.println("4. Show Products of Merchant by Merchant Name");
        System.out.println("0. Return to Main Menu");
    }

    public int getMerchantChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found for this merchant.");
        } else {
            products.forEach(product -> System.out.println(product.getProductName() + " - " + product.getPrice()));
        }
    }
}
