package com.example.FBJV24001115synergy7firbinfudch4.controller;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.OrderDetail;
import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Orders;
import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Users;
import com.example.FBJV24001115synergy7firbinfudch4.repository.ProductRepository;
import com.example.FBJV24001115synergy7firbinfudch4.service.OrderService;
import com.example.FBJV24001115synergy7firbinfudch4.service.UserService;
import com.example.FBJV24001115synergy7firbinfudch4.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderView orderView;
    @Autowired
    private ProductRepository productRepository;

    public void manageOrderServices(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            orderView.displayOrderMenu();
            int choice = orderView.getOrderChoice(scanner);
            switch (choice) {
                case 1: // Create Order
                    createOrder(scanner);
                    break;
                case 2: // Display Orders
                    displayOrders();
                    break;
                case 0: // Return to Main Menu
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createOrder(Scanner scanner) {
        System.out.print("Enter destination address: ");
        String destinationAddress = scanner.next();
        scanner.nextLine();
        System.out.print("Enter user ID for the order: ");
        UUID userId = UUID.fromString(scanner.next());
        scanner.nextLine();
        List<OrderDetail> details = new ArrayList<>();

        boolean addingProducts = true;
        while (addingProducts) {
            System.out.print("Enter product ID (or 'done' to finish): ");
            String input = scanner.nextLine();
            if ("done".equalsIgnoreCase(input)) {
                addingProducts = false;
            } else {
                UUID productId = UUID.fromString(input);
                System.out.print("Enter quantity for product: ");
                Integer quantity = scanner.nextInt();
                scanner.nextLine();
                OrderDetail detail = new OrderDetail();
                detail.setProduct(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found")));
                detail.setQuantity(quantity);
                details.add(detail);
            }
        }

        Orders order = orderService.createOrder(destinationAddress, userId, details);
        if (order != null) {
            System.out.println("Order created successfully with ID: " + order.getId());
        } else {
            System.out.println("Failed to create order.");
        }
    }

    private void displayOrders() {
        List<Orders> orders = orderService.getAllOrders();
        orders.forEach(order -> {
            System.out.println("Order ID: " + order.getId());
            order.getOrderDetails().forEach(detail -> {
                System.out.println("Product: " + detail.getProduct().getProductName() + ", Quantity: " + detail.getQuantity());
            });
            System.out.println("----------------------------------------------------");
        });
    }
}
