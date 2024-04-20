package org.example.controller;

import org.example.model.Drink;
import org.example.model.Food;
import org.example.model.Items;
import org.example.service.CartService;
import org.example.service.CartServiceImpl;
import org.example.util.MyInputMismatch;
import org.example.view.MenuView;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    private final CartService cartService;
    private final Scanner scanner;

    public MenuController(Scanner scanner) {
        this.scanner = scanner;
        this.cartService = new CartServiceImpl();
    }

    public void start() {
        while (true) {
            MenuView.displayMenu();
            System.out.print("Masukkan pilihan anda: ");
            int choice = MyInputMismatch.getInputChoice(scanner);

            if (choice == 0) {
                System.out.println("Program selesai!");
                break;
            }

            handleMenuChoice(choice);
        }
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1, 2, 3, 4:
                MenuView.getFoodDetails(choice, scanner)
                        .ifPresent(makanan -> {
                            cartService.addFoodToCart(makanan);
                            System.out.printf("%s ditambahkan ke dalam keranjang sebanyak %d buah dengan satu porsi seharga %d dengan total %d%n",
                                    makanan.getName(), makanan.getQty(), makanan.getPrice(), makanan.getTotalPrice());
                        });
                break;
            case 5:
                MenuView.getDrinkDetails(choice, scanner)
                        .ifPresent(minuman -> {
                            cartService.addFoodToCart(minuman);
                            System.out.printf("%s ditambahkan ke dalam keranjang sebanyak %d buah dengan satu porsi seharga %d dengan total %d%n",
                                    minuman.getName(), minuman.getQty(), minuman.getPrice(), minuman.getTotalPrice());
                        });
                break;
            case 1234:
                displayItemDescriptions();
                break;
            case 1000:
                cartService.clearCart();
                break;
            case 99:
                showCheckoutConfirmation();
                break;
            default:
                System.out.println("Pilihan yang anda masukkan salah!");
                break;
        }
    }

    public void displayItemDescriptions() {
        List<Items> items = cartService.getCartItems();
        for (Items item : items) {
            System.out.println(item.getDescription());
        }
    }



    private void showCheckoutConfirmation() {
        if (cartService.isCartEmpty()) {
            System.out.println("Cart kosong, silahkan tambahkan dulu!");
            return;
        }

        cartService.displayCartContents();

        System.out.println("1. Konfirmasi dan bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.print("Silahkan memilih: ");
        int checkoutChoice = MyInputMismatch.getInputChoice(scanner);

        switch (checkoutChoice) {
            case 1:
                cartService.generateReceipt();
                System.exit(0);
                break;
            case 2:
                break;
            case 0:
                System.out.println("Akan keluar aplikasi!");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan yang anda masukkan salah!");
                break;
        }
    }
}
