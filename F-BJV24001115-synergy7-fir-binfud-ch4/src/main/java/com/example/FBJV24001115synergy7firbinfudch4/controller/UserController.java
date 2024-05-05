package com.example.FBJV24001115synergy7firbinfudch4.controller;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Users;
import com.example.FBJV24001115synergy7firbinfudch4.service.UserService;
import com.example.FBJV24001115synergy7firbinfudch4.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserView userView;
    @Autowired
    private UserService userService;
    @Autowired
    private MerchantController merchantController;
    @Autowired
    private OrderController orderController;
    @Autowired
    private ProductController productController;

    public void startApplication() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepRunning = true;

            while (keepRunning) {
                int choice = userView.displayMainMenu(scanner);
                switch (choice) {
                    case 1: // Register
                        registerUser(scanner);
                        break;
                    case 2: // Login
                        if (loginUser(scanner)) {
                            managePostLoginServices(scanner);
                        }
                        break;
                    case 0: // Exit
                        keepRunning = false;
                        System.out.println("Exiting application.");
                        break;
                    default:
                        userView.displayInvalidChoice();
                }
            }
        }
    }

    private void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        userService.registerUser(username, email, password);
        System.out.println("User registered successfully.");
    }

    private boolean loginUser(Scanner scanner) {
        String[] credentials = userView.getLoginDetails(scanner);
        Users user = userService.findByUsername(credentials[0]);
        if (user != null && user.getPassword().equals(credentials[1])) {
            userView.displayLoginSuccess();
            return true;
        } else {
            userView.displayLoginFailed();
            return false;
        }
    }

    private void managePostLoginServices(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            userView.displayWelcome();
            int serviceChoice = scanner.nextInt();
            switch (serviceChoice) {
                case 1:
                    merchantController.manageMerchantServices(scanner);
                    break;
                case 2:
                    productController.manageProductServices(scanner);
                    break;
                case 3:
                    manageUserServices(scanner);
                    break;
                case 4:
                    orderController.manageOrderServices(scanner);
                    break;
                case 0:
                    keepRunning = false;
                    break;
                default:
                    userView.displayInvalidChoice();
            }
        }
    }

    private void manageUserServices(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            userView.displayUserMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Add User
                    registerUser(scanner);
                    break;
                case 2: // Update User
                    updateUser(scanner);
                    break;
                case 3: // Delete User
                    deleteUser(scanner);
                    break;
                case 0: // Return to Main Menu
                    keepRunning = false;
                    break;
                default:
                    userView.displayInvalidChoice();
            }
        }
    }

    private void updateUser(Scanner scanner) {
        System.out.print("Enter the ID of the selected user to update: ");
        UUID id = UUID.fromString(scanner.next());
        System.out.print("Enter new username: ");
        String username = scanner.next();
        System.out.print("Enter new email: ");
        String email = scanner.next();
        System.out.print("Enter new password: ");
        String password = scanner.next();

        userService.updateUser(id, username, email, password);
        System.out.println("User registered successfully.");
    }

    private void deleteUser(Scanner scanner) {
        System.out.print("Enter user ID to delete: ");
        UUID userId = UUID.fromString(scanner.next());
        userService.deleteUser(userId);
        System.out.println("User deleted successfully.");
    }

    public void displayAllUsersByName(Scanner scanner) {
        System.out.println("Enter username to search: ");
        String username = scanner.next();
        System.out.println("Enter page number: ");
        int page = scanner.nextInt();
        System.out.println("Enter page size: ");
        int size = scanner.nextInt();

        // PageRequest is zero-based, so subtract 1 from the user's input (assuming user input is 1-based)
        Page<Users> usersPage = userService.findAllUsersByName(username, PageRequest.of(page - 1, size));
        if (usersPage.hasContent()) {
            usersPage.forEach(user -> System.out.println(user.toString()));
        } else {
            System.out.println("No users found with the given username.");
        }
    }
}
