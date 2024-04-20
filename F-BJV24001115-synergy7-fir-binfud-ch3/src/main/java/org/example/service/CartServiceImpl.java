package org.example.service;

import org.example.model.Cart;
import org.example.model.Items;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CartServiceImpl implements CartService {
    private final Cart cart = new Cart();
    private Path receiptFilePath = Paths.get("receipt.txt");

    @Override
    public void addFoodToCart(Items item) {
        if (item == null) {
            return;
        }
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

        try (FileWriter fileWriter = new FileWriter(receiptFilePath.toFile())) {
            fileWriter.write("""
            ================================================
            PanjiFud
            ================================================
                                    
            Terima kasih sudah memesan. Berikut adalah pesanan anda:
            """);

            int totalQty = 0;
            int totalPrice = 0;
            for (Items item : cart.getItemsCart()) {
                fileWriter.write(String.format("%-15s %-10d %-10d%n", item.getName(), item.getQty(), item.getPrice()));
                totalQty += item.getQty();
                totalPrice += item.getTotalPrice();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setReceiptFilePath(Path path) {
        this.receiptFilePath = path;
    }

    @Override
    public void displayCartContents() {
        if (isCartEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("================================");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("================================\n");

        int allQty = 0;
        int allPrice = 0;
        for (Items item : cart.getItemsCart()) {
            System.out.printf("%-15s %-10d %-10d%n", item.getName(), item.getQty(), item.getTotalPrice());
            allQty += item.getQty();
            allPrice += item.getTotalPrice();
        }

        System.out.println("-------------------------------- +");
        System.out.printf("%-15s %-10d %-10d%n", "Total", allQty, allPrice);
    }
}
