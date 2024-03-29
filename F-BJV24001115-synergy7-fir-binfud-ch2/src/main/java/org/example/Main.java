package org.example;

import org.example.controller.MenuController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MenuController menuController = new MenuController(scanner);
            menuController.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
