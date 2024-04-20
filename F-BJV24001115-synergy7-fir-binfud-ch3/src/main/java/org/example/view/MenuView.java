package org.example.view;

import org.example.model.Drink;
import org.example.model.Food;
import org.example.util.MyInputMismatch;

import java.util.Optional;
import java.util.Scanner;

public class MenuView {

    private MenuView() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    public static void displayMenu() {
        System.out.println("\n\n================================================");
        System.out.println("Selamat datang di BinarFud cabang Firman Panji Utama");
        System.out.println("================================================\n");
        System.out.println("Silahkan pilih makanan:");
        System.out.println("1. Lontong Kari\t\t | 18000");
        System.out.println("2. Bakso\t\t\t | 12000");
        System.out.println("3. Nasi Goreng\t\t | 15000");
        System.out.println("4. Indomie\t\t\t | 8000");
        System.out.println("5. Es Teh\t\t\t | 3000");
        System.out.println("1234. Tampilkan deskripsi setiap item");
        System.out.println("1000. Clear Cart");
        System.out.println("99. Checkout");
        System.out.println("0. Exit");
    }

    public static Optional<Food> getFoodDetails(int choice, Scanner scanner) {
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
                return Optional.empty();
        }
        System.out.print("Jumlah yang ingin dibeli: ");
        int qty = MyInputMismatch.getInputChoice(scanner);
        if (qty <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return Optional.empty();
        }
        return Optional.of(new Food(name, price, qty));
    }

    public static Optional<Drink> getDrinkDetails(int choice, Scanner scanner) {
        String name;
        int price;
        if (choice == 5) {
            name = "Es Teh";
            price = 5000;
        } else {
            System.out.println("Invalid choice. Please try again.");
            return Optional.empty();
        }
        System.out.print("Jumlah yang ingin dibeli: ");
        int qty = MyInputMismatch.getInputChoice(scanner);
        if (qty <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return Optional.empty();
        }
        return Optional.of(new Drink(name, price, qty));
    }

}
