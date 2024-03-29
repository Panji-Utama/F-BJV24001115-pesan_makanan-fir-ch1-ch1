package org.example.controller;

<<<<<<< HEAD
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
        Food makanan;
        switch (choice) {
            case 1, 2, 3, 4:
                makanan = MenuView.getFoodDetails(choice, scanner);
                if (makanan != null) {
                    cartService.addFoodToCart(makanan);
                    System.out.printf("%s ditambahkan ke dalam keranjang sebanyak %d buah dengan satu porsi seharga %d dengan total %d%n", makanan.getName(), makanan.getQty(), makanan.getPrice(), makanan.getTotalPrice());
                }
                break;
            case 5:
                Drink minuman = MenuView.getDrinkDetails(choice, scanner);
                if (minuman != null) {
                    cartService.addFoodToCart(minuman);
                    System.out.printf("%s ditambahkan ke dalam keranjang sebanyak %d buah dengan satu porsi seharga %d dengan total %d%n", minuman.getName(), minuman.getQty(), minuman.getPrice(), minuman.getTotalPrice());
                }
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
=======
import org.example.model.Cart;
import org.example.view.MenuView;
import org.example.util.InputHandler;

import java.util.Scanner;

public class MenuController {

    private CartController cartController;
    private MenuView menuView;
    private Scanner scanner;

    public MenuController(CartController cartController, MenuView menuView, Scanner scanner) {
        this.cartController = cartController;
        this.menuView = menuView;
        this.scanner = scanner;
    }

    // In MenuController.java
    public void processUserSelection() {
        menuView.displayMenu();
        System.out.print("Masukkan pilihan anda: ");
        int choice = InputHandler.getInputChoice(scanner);

        while (choice != 0) {
            if (choice == -1) {
                menuView.displayInputMismatchError();
            } else {
                int quantity;
                switch (choice) {
                    case 1:
                        quantity = menuView.getQuantityFromUser();
                        cartController.addFoodToCart("Lontong Kari", 18000, quantity);
                        break;
                    case 2:
                        quantity = menuView.getQuantityFromUser();
                        cartController.addFoodToCart("Bakso", 12000, quantity);
                        break;
                    case 3:
                        quantity = menuView.getQuantityFromUser();
                        cartController.addFoodToCart("Nasi Goreng", 15000, quantity);
                        break;
                    case 4:
                        quantity = menuView.getQuantityFromUser();
                        cartController.addFoodToCart("Indomie", 8000, quantity);
                        break;
                    case 99:
                        cartController.checkout();
                        break;
                    default:
                        menuView.displayInvalidChoiceMessage();
                }
            }
            menuView.displayMenu();
            System.out.print("Masukkan pilihan anda: ");
            choice = InputHandler.getInputChoice(scanner);
>>>>>>> main
        }
    }
}
