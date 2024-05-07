package com.example.FBJV24001115synergy7firbinfudch5.controller;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Merchant;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;
import com.example.FBJV24001115synergy7firbinfudch5.repository.MerchantRepository;
import com.example.FBJV24001115synergy7firbinfudch5.service.ProductService;
import com.example.FBJV24001115synergy7firbinfudch5.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductView productView;

    @Autowired
    private MerchantRepository merchantRepository;

    public void manageProductServices(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            productView.displayProductMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Add Product
                    addProduct(scanner);
                    break;
                case 2: // Update Product
                    updateProduct(scanner);
                    break;
                case 3: // Delete Product
                    deleteProduct(scanner);
                    break;
                case 4:
                    showAvailableProducts();
                    break;
                case 0: // Return to Main Menu
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private void showAvailableProducts() {
        Iterable<Product> products = productService.getAllProducts();
        products.forEach((p -> System.out.println(p.getProductName())));
    }

    private void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        scanner.nextLine();

        System.out.print("Enter price: ");
        Double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter merchant ID:");
        UUID merchantId = UUID.fromString(scanner.nextLine());

        productService.addProduct(price, name, merchantId);
        System.out.println("Product added successfully.");
    }

    private void updateProduct(Scanner scanner) {
        System.out.print("Enter product ID to update: ");
        UUID productId = UUID.fromString(scanner.nextLine());
        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        Product product = productService.getProductById(productId);
        if (product != null) {
            product.setProductName(name);
            product.setPrice(price);
            productService.updateProduct(product);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void deleteProduct(Scanner scanner) {
        System.out.print("Enter product ID to delete: ");
        UUID productId = UUID.fromString(scanner.next());
        scanner.nextLine();
        productService.deleteProduct(productId);
        System.out.println("Product deleted successfully.");
    }
}
