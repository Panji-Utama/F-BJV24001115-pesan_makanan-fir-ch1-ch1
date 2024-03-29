package org.example.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyInputMismatchException {
    public static int getInputChoice(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // consume the invalid token
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
