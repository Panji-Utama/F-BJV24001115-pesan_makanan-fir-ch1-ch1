package com.example.FBJV24001115synergy7firbinfudch4.controller;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Orders;
import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Users;
import com.example.FBJV24001115synergy7firbinfudch4.service.OrderService;
import com.example.FBJV24001115synergy7firbinfudch4.service.UserService;
import com.example.FBJV24001115synergy7firbinfudch4.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderView orderView;

    public void manageOrderServices(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            orderView.displayOrderMenu();
            int choice = orderView.getOrderChoice(scanner);
            switch (choice) {
                case 1: // Create Order
                    createOrder(scanner);
                    break;
                case 2: // Update Order
                    updateOrder(scanner);
                    break;
                case 3: // Display Orders
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
        System.out.print("Enter user ID for the order: ");
        UUID userId = UUID.fromString(scanner.next());
        scanner.nextLine();
        Users user = userService.getUserById(userId);
        if (user != null) {
            Orders order = new Orders();
            order.setUser(user);
            Orders savedOrder = orderService.createOrder(order);
            if (savedOrder != null) {
                System.out.println("Order created successfully.");
            } else {
                System.out.println("Failed to create order.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    private void updateOrder(Scanner scanner) {
        System.out.print("Enter order ID to update: ");
        UUID orderId = UUID.fromString(scanner.nextLine());
        Orders order = orderService.getOrderById(orderId);
        if (order != null) {
            // Update logic here, assuming updates are done here
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    private void displayOrders() {
        List<Orders> orders = orderService.getAllOrders();
        orders.forEach(order -> System.out.println(order.toString()));
    }
}
