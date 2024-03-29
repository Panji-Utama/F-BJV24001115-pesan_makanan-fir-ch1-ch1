package org.example.service;

import org.example.model.Cart;
import org.example.model.Food;

import java.io.FileWriter;
import java.io.IOException;

public class CartService {

    public void addFoodToCart(Cart cart, String name, int price, int qty) {
        if (qty > 0) {
            Food food = new Food(name, price, qty);
            cart.addItem(food);
        }
        // Optionally, include other business logic here, such as validation
    }

    public void checkout(Cart cart) {
        if (!cart.getItems()
                .isEmpty()) {
            generateReceipt(cart);
            cart.clearCart(); // Clear the cart after generating the receipt
        }
    }

    private void generateReceipt(Cart cart) {
        try (FileWriter fileWriter = new FileWriter("receipt.txt")) {
            fileWriter.write("""
                    ================================================
                    PanjiFud
                    ================================================
                                        
                    Terima kasih sudah memesan. Berikut adalah pesanan anda:
                    """);
            for (Food f : cart.getItems()) {
                fileWriter.write(String.format("%-15s %-10d %-10d%n", f.getName(), f.getQty(), f.getTotalPrice()));
            }
            fileWriter.write("-------------------------------- +\n");
            fileWriter.write(String.format("%-15s %-10d %-10d%n%n", "Total", cart.getTotalQuantity(), cart.getTotalPrice()));
            fileWriter.write("""
                    Pembayaran : Gadai STNK Motor
                                        
                    =================================================================
                    Simpan struk ini sebagai bukti gadai sah
                    =================================================================
                    """);
            System.out.println("Struk pembelian sudah tercetak, dan anda akan dikeluarkan dari program ini...");
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Terjadi error ketika generate struk belanja.");
            e.printStackTrace();
        }
    }
}
