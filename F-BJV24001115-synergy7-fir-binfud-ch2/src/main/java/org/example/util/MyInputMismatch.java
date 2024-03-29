package org.example.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyInputMismatch {
    private MyInputMismatch() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    public static int getInputChoice(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
