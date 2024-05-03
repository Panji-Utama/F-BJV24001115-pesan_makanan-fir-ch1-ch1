package com.example.FBJV24001115synergy7firbinfudch4.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MerchantView {

    public void displayMerchantMenu() {
        System.out.println("Merchant Services:");
        System.out.println("1. Add Merchant");
        System.out.println("2. Edit Merchant Status");
        System.out.println("3. Show Open Merchants");
        System.out.println("0. Return to Main Menu");
    }

    public int getMerchantChoice(Scanner scanner) {
        return scanner.nextInt();
    }
}
