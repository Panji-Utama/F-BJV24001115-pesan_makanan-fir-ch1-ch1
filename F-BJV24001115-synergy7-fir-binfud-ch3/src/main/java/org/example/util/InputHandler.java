package org.example.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    public static int getInputChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();  // Clear the invalid input
            return -1;  // Return -1 to indicate invalid input
        }
    }
}
