package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static int allQty = 0;
    static int allPrice = 0;

    // Throws InterruptedException supaya dapat menggunakan function TimeUnit.SECONDS.sleep
    public static void main(String[] args) throws InterruptedException {
        int jumlah;
//        Food makanan;

        Cart cart = new Cart();

        // Menggunakan arraylist supaya tidak perlu memikirkan jumlah pesanan

        menuList();

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan pilihan anda: ");
        int choice = sc.nextInt();
        System.out.println("\n");

        // Switch case untuk memilih menu/makanan
        while (choice != 0) {
            switch (choice) {
                case 1:
                    addFoodToCart(cart, "Lontong Kari", 18000, sc);
                    break;
                case 2:
                    addFoodToCart(cart, "Bakso", 12000, sc);
                    break;
                case 3:
                    addFoodToCart(cart, "Nasi Goreng", 15000, sc);
                    break;
                case 4:
                    addFoodToCart(cart, "Indomie", 8000, sc);
                    break;
                case 99:
                    if (cart.getTotalQuantity() > 0) {
//                        Receipt.generateReceipt(cart);
//                        System.out.println("Receipt has been generated. Exiting program.");
//                        choice = 0; // Exit the loop
                        checkout(cart, sc);
                    } else {
                        System.out.println("Your cart is empty.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            menuList();
            System.out.print("Masukkan pilihan anda: ");
            choice = sc.nextInt();
            System.out.println("\n");
        }

        sc.close();

        System.out.println("Program selesai!");
    }

    // Method
    static void menuList() {
        System.out.println("\n\n================================================");
        System.out.println("Selamat datang di BinarFud cabang Firman Panji Utama");
        System.out.println("================================================\n");
        System.out.println("Silahkan pilih makanan:");
        System.out.println("1. Lontong Kari\t\t | 18000");
        System.out.println("2. Bakso\t\t\t | 12000");
        System.out.println("3. Nasi Goreng\t\t | 15000");
        System.out.println("4. Indomie\t\t\t | 8000");
        System.out.println("99. Checkout");
        System.out.println("0. Exit");
    }

    // Fitur Checkout atau Membayar Makanan
    static void checkout(Cart cart, Scanner sc) { // Scanner passed as parameter
        System.out.println("================================");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("================================\n");

        int allQty = 0;
        int allPrice = 0;

        for (Food f : cart.getItems()) { // Correctly iterate over the items in the cart
            allQty += f.getQty();
            allPrice += f.getTotalPrice();
            System.out.printf("%-15s %-10d %-10d\n", f.getName(), f.getQty(), f.getTotalPrice());
        }
        System.out.println("-------------------------------- +");
        System.out.printf("%-15s %-10d %-10d\n", "Total", allQty, allPrice);

        System.out.println("1. Konfirmasi dan bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.print("Silahkan memilih: ");
        int checkoutChoice = sc.nextInt();

        switch (checkoutChoice) {
            case 1:
                Receipt.generateReceipt(cart); // Assuming this method is adjusted to work correctly
                System.out.println("Receipt has been generated. Thank you for your purchase!");
                break;
            case 2:
                // Implementation for returning to the main menu (likely just breaking out of this method)
                break;
            case 0:
                System.out.println("Exiting application.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice entered. Please try again.");
                break;
        }
    }


    private static void addFoodToCart(Cart cart, String name, int price, Scanner scanner) {
        System.out.printf("Enter quantity for %s: ", name);
        int qty = scanner.nextInt();
        if (qty > 0) {
            Food item = new Food(name, price, qty);
            cart.addItem(item);
            System.out.printf("%d of %s added to cart.\n", qty, name);
        } else {
            System.out.println("Invalid quantity.");
        }
    }
}
