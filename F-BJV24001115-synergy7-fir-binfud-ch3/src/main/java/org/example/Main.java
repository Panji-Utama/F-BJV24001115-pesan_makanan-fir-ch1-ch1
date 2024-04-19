package org.example;

import org.example.controller.MenuController;
import org.example.controller.OrderController;
import org.example.service.OrderServiceImpl;
import org.example.view.MenuView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuView menuView = new MenuView(scanner);
        OrderServiceImpl orderService = new OrderServiceImpl();
        OrderController orderController = new OrderController(orderService, menuView);
        MenuController menuController = new MenuController(orderController, menuView, scanner);

        menuController.processUserSelection();
        scanner.close();
    }
}
