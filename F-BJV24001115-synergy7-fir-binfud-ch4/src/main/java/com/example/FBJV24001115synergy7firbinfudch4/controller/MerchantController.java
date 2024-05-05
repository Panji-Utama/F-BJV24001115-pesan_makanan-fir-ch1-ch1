package com.example.FBJV24001115synergy7firbinfudch4.controller;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Merchant;
import com.example.FBJV24001115synergy7firbinfudch4.service.MerchantService;
import com.example.FBJV24001115synergy7firbinfudch4.view.MerchantView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Controller
public class MerchantController {

    @Autowired
    private MerchantView merchantView;
    @Autowired
    private MerchantService merchantService;

    public void manageMerchantServices(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            merchantView.displayMerchantMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addMerchant(scanner);
                    break;
                case 2:
                    updateMerchantStatus(scanner);
                    break;
                case 3:
                    showOpenMerchants();
                    break;
                case 4:
                    showProductsByMerchant(scanner);
                    break;
                case 0:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private void showProductsByMerchant(Scanner scanner) {
        System.out.print("Enter merchant name to show products: ");
        String merchantName = scanner.nextLine();
        List<String> products = merchantService.getProductsByMerchantName(merchantName);
        if (products.isEmpty()) {
            System.out.println("No products found for this merchant.");
        } else {
            products.forEach(System.out::println);
        }
    }


    private void addMerchant(Scanner scanner) {
        System.out.print("Enter merchant name: ");
        String name = scanner.nextLine();
        System.out.print("Enter merchant location: ");
        String location = scanner.nextLine();
        Merchant newMerchant = Merchant.builder()
                .merchant_name(name)
                .merchant_location(location)
                .open(true)
                .build();
        merchantService.addMerchant(newMerchant);
        System.out.println("Merchant added successfully.");
    }

    private void updateMerchantStatus(Scanner scanner) {
        System.out.print("Enter merchant ID: ");
        UUID id = UUID.fromString(scanner.next());
        System.out.print("Is the merchant open? (true/false): ");
        boolean isOpen = scanner.nextBoolean();
        merchantService.updateMerchantStatus(id, isOpen);
        System.out.println("Merchant status updated successfully.");
    }

    private void showOpenMerchants() {
        List<Merchant> merchants = merchantService.getOpenMerchants();
        for (Merchant merchant : merchants) {
            System.out.println("ID: " + merchant.getId() + ", Name: " + merchant.getMerchant_name() + ", Location: " + merchant.getMerchant_location());
        }
    }
}
