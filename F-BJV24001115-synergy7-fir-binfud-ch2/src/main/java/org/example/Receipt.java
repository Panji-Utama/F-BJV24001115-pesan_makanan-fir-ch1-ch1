package org.example;

import org.example.Food;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Receipt {
    public static void generateReceipt(Cart cart) {

        try (FileWriter fileWriter = new FileWriter("receipt.txt")) {
            fileWriter.write("""
                    ================================================
                    PanjiFud
                    ================================================
                                        
                    Terima kasih sudah memesan. Berikut adalah pesanan anda:
                    """);
            for (Food f : cart.getItems()) {
                fileWriter.write(String.format("%-15s %-10d %-10d\n", f.getName(), f.getQty(), f.getPrice()));
            }
            fileWriter.write("-------------------------------- +\n");
            fileWriter.write((String.format("%-15s %-10d %-10d\n\n", "Total", cart.getTotalQuantity(), cart.getTotalPrice())));
            fileWriter.write("""
                    Pembayaran : Gadai STNK Motor
                                        
                    ================================================================
                    Simpan struk ini sebagai bukti gadai sah
                    ================================================================
                    """);
            fileWriter.close();
            System.out.println("Struk pembelian sudah tercetak, dan anda akan dikeluarkan dari program ini...");
            TimeUnit.SECONDS.sleep(3);
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Terjadi error ketika generate struk belanja.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
