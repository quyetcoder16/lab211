package ultils;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author quyetdx16
 */
public class Validation {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int InputPositiveIntergerValidation() {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }
                if (input.contains(".")) {
                    throw new IllegalArgumentException("Error: Input is floating-point number, please enter a integer!");
                }

                if (!input.matches("\\d+")) {
                    throw new IllegalArgumentException("Error: Input contains letters, please enter a integer!");
                }

                long inputParseInt = Long.parseLong(input);

                if (inputParseInt <= 0) {
                    throw new IllegalArgumentException("Error: The input is not a positive integer!");
                }

                if (inputParseInt > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException("Error: The input exceed Integer!");
                }

                return (int) inputParseInt;

            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
