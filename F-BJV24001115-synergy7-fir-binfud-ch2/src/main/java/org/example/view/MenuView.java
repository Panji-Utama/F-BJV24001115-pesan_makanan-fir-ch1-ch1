package org.example.view;

<<<<<<< HEAD
import org.example.model.Drink;
import org.example.model.Food;
import org.example.util.MyInputMismatch;

=======
import org.example.model.Cart;
import org.example.model.Food;

import java.util.List;
>>>>>>> main
import java.util.Scanner;

public class MenuView {

<<<<<<< HEAD
    private MenuView() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    public static void displayMenu() {
        System.out.println("\n\n================================================");
        System.out.println("Selamat datang di BinarFud cabang Firman Panji Utama");
        System.out.println("================================================\n");
        System.out.println("Silahkan pilih makanan:");
=======
    private final Scanner scanner;

    public MenuView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("\n\n================================================");
        System.out.println("Welcome to BinarFud branch of Firman Panji Utama");
        System.out.println("================================================\n");
        System.out.println("Please choose an option:");
>>>>>>> main
        System.out.println("1. Lontong Kari\t\t | 18000");
        System.out.println("2. Bakso\t\t\t | 12000");
        System.out.println("3. Nasi Goreng\t\t | 15000");
        System.out.println("4. Indomie\t\t\t | 8000");
<<<<<<< HEAD
        System.out.println("5. Es Teh\t\t\t | 3000");
        System.out.println("1234. Tampilkan deskripsi setiap item");
        System.out.println("1000. Clear Cart");
=======
>>>>>>> main
        System.out.println("99. Checkout");
        System.out.println("0. Exit");
    }

<<<<<<< HEAD
    public static Food getFoodDetails(int choice, Scanner scanner) {
        String name = "";
        int price = 0;
        switch (choice) {
            case 1:
                name = "Lontong Kari";
                price = 18000;
                break;
            case 2:
                name = "Bakso";
                price = 12000;
                break;
            case 3:
                name = "Nasi Goreng";
                price = 15000;
                break;
            case 4:
                name = "Indomie";
                price = 8000;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return null;
        }
        System.out.print("Jumlah yang ingin dibeli: ");
        int qty = MyInputMismatch.getInputChoice(scanner);
        if (qty <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return null;
        }
        return new Food(name, price, qty);
    }

    public static Drink getDrinkDetails(int choice, Scanner scanner) {
        String name;
        int price;
        if (choice == 5) {
            name = "Es Teh";
            price = 5000;
        } else {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }
        System.out.print("Jumlah yang ingin dibeli: ");
        int qty = MyInputMismatch.getInputChoice(scanner);
        if (qty <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return null;
        }
        return new Drink(name, price, qty);
=======
    public int getFoodQuantityFromUser(String foodName) {
        System.out.printf("Enter quantity for %s: ", foodName);
        return scanner.nextInt();
    }

    public int getQuantityFromUser() {
        System.out.print("Enter quantity: ");
        return scanner.nextInt();
    }


    public void displayAdditionConfirmation(int qty, String itemName) {
        System.out.printf("%d of %s added to cart.%n", qty, itemName);
    }

    public void displayCheckout(Cart cart) {
        System.out.println("Checkout confirmation & Payment\n================================");
        for (Food item : cart.getItems()) {
            System.out.printf("%-15s %-10d %-10d%n", item.getName(), item.getQty(), item.getTotalPrice());
        }
        System.out.println("-------------------------------- +");
        System.out.printf("%-15s %-10d %-10d%n", "Total", cart.getTotalQuantity(), cart.getTotalPrice());
        // Additional checkout messages or prompts can be added here
    }
    public void displayReceipt(Cart cart) {
        System.out.println("\nReceipt\n=================");
        List<Food> items = cart.getItems();
        for (Food item : items) {
            System.out.printf("%-20s x%d\t%d\n", item.getName(), item.getQty(), item.getTotalPrice());
        }
        System.out.println("=================");
        System.out.printf("Total: \t\t\t%d\n", cart.getTotalPrice());
        System.out.println("Thank you for your purchase!");
    }

    public void displayInvalidChoiceMessage() {
        System.out.println("Invalid choice. Please try again.");
    }

    public void displayInputMismatchError() {
        System.out.println("You must enter a number for the choice.");
    }

    public void displayInvalidQuantityMessage() {
        System.out.println("Invalid quantity.");
    }

    public void displayCartEmptyMessage() {
        System.out.println("Your cart is empty.");
    }

    public void displayExitMessage() {
        System.out.println("Exiting application...");
>>>>>>> main
    }
}
