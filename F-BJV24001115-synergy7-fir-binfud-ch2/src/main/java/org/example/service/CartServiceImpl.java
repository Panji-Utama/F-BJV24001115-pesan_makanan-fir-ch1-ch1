package org.example.service;

import org.example.model.Cart;
import org.example.model.Items;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CartServiceImpl implements CartService {
    private final Cart cart = new Cart();

    @Override
    public void addFoodToCart(Items item) {
        cart.addItem(item);
    }

    @Override
    public boolean isCartEmpty() {
        return cart.getItemsCart().isEmpty();
    }

    @Override
    public void clearCart() {
        cart.clearCart();
        System.out.println("Isi keranjang sudah dihapus");
    }

    @Override
    public List<Items> getCartItems() {
        return cart.getItemsCart();
    }

    @Override
    public void generateReceipt() {
        if (isCartEmpty()) {
            System.out.println("Tidak ada makanan yang ditambahkan!");
            return;
        }

        try (FileWriter fileWriter = new FileWriter("receipt.txt")) {
            fileWriter.write("""
            ================================================
            PanjiFud
            ================================================
                                    
            Terima kasih sudah memesan. Berikut adalah pesanan anda:
            """);

            int totalQty = 0;
            int totalPrice = 0;
            for (Items item : cart.getItemsCart()) {
<<<<<<< HEAD
                fileWriter.write(String.format("%-15s %-10d %-10d%n", item.getName(), item.getQty(), item.getPrice()));
                totalQty += item.getQty();
                totalPrice += item.getTotalPrice();
=======
                // Adjusted to match the old format: name, quantity, and price per item, not total price.
                fileWriter.write(String.format("%-15s %-10d %-10d%n", item.getName(), item.getQty(), item.getPrice()));
                totalQty += item.getQty();
                totalPrice += item.getTotalPrice(); // Ensure this calculates the total price correctly.
>>>>>>> main
            }

            fileWriter.write("-------------------------------- +\n");
            fileWriter.write(String.format("%-15s %-10d %-10d%n%n", "Total", totalQty, totalPrice));

            fileWriter.write("""
            Pembayaran : Gadai STNK Motor
                                    
            ================================================================
            Simpan struk ini sebagai bukti gadai sah
            ================================================================
            """);
            System.out.println("Struk pembelian sudah tercetak, dan anda akan dikeluarkan dari program ini...");
<<<<<<< HEAD
=======
            // Removed the sleep and exit code for clarity and to focus on the receipt formatting.
>>>>>>> main
        } catch (IOException e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
=======

//        try (FileWriter fileWriter = new FileWriter("receipt.txt")) {
//            fileWriter.write("""
//                    ================================================
//                    PanjiFud
//                    ================================================
//
//                    Terima kasih sudah memesan. Berikut adalah pesanan anda:
//                    """);
//
//            int totalQty = 0;
//            int totalPrice = 0;
//            for (Items item : cart.getItemsCart()) {
//                int itemTotalPrice = item.getTotalPrice();
//                fileWriter.write(item.getName() + "\t" + item.getQty() + " x " + item.getPrice() + " = " + itemTotalPrice + "\n");
//                totalQty += item.getQty();
//                totalPrice += itemTotalPrice;
//            }
//
//            fileWriter.write("--------------------------------\n");
//            fileWriter.write("Total Quantity: " + totalQty + "\n");
//            fileWriter.write("Total Price: " + totalPrice + "\n");
//            System.out.println("Receipt has been generated.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
>>>>>>> main
    }

    @Override
    public void displayCartContents() {
        System.out.println("================================");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("================================\n");

        int allQty = 0;
        int allPrice = 0;
        for (Items item : cart.getItemsCart()) {
            allQty += item.getQty();
            allPrice += item.getTotalPrice();
<<<<<<< HEAD
            System.out.printf("%-15s %-10d %-10d%n", item.getName(), item.getQty(), item.getTotalPrice());
        }
        System.out.println("-------------------------------- +");
        System.out.printf("%-15s %-10d %-10d%n", "Total", allQty, allPrice);
=======
            System.out.printf("%-15s %-10d %-10d\n", item.getName(), item.getQty(), item.getTotalPrice());
        }
        System.out.println("-------------------------------- +");
        System.out.printf("%-15s %-10d %-10d\n", "Total", allQty, allPrice);
>>>>>>> main
    }
}
