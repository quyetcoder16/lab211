/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author quyet
 */
public class Validate {

    private final Scanner SCANNER = new Scanner(System.in);

    public String getFruitId() {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                input = input.trim();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                if (!input.matches("FR[0-9]{6}")) {
                    throw new IllegalArgumentException("error: format FRxxxxxx");
                }

                return input;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getFruitName() {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                input = input.trim();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                if (!input.matches("[A-Za-z ]+")) {
                    throw new IllegalArgumentException("Error: Input contains specific character!");
                }

                return input;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double getPrice() {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                if (!input.matches("-?[0-9]?.[0-9]")) {
                    throw new IllegalArgumentException("Error: Input contains letters, please enter a integer!");
                }

                double price = Double.parseDouble(input);

                if (price < 0) {
                    throw new IllegalArgumentException("Error: price <0");
                }

                return price;

            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getQuantity() {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }
                if (input.contains(".")) {
                    throw new IllegalArgumentException("Error: Input is floating-point number!");
                }

                if (!input.matches("-?[0-9]+")) {
                    throw new IllegalArgumentException("Error: Input contains letters, please enter a integer!");
                }

                long quantity = Long.parseLong(input);

                if (quantity < 0) {
                    throw new IllegalArgumentException("Error: choose <0");
                }

                return (int) quantity;

            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getOrigin() {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                input = input.trim();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                if (!input.matches("[A-Za-z ]+")) {
                    throw new IllegalArgumentException("Error: Input contains specific character!");
                }

                return input;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getChoose() {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }
                if (input.contains(".")) {
                    throw new IllegalArgumentException("Error: Input is floating-point number!");
                }

                if (!input.matches("-?[0-9]+")) {
                    throw new IllegalArgumentException("Error: Input contains letters, please enter a integer!");
                }

                long choose = Long.parseLong(input);

                if (choose < 1) {
                    throw new IllegalArgumentException("Error: choose <1 , please enter choose bettwen 1 to 4!");
                }

                if (choose > 4) {
                    throw new IllegalArgumentException("Error: choose > 4 , please enter choose bettwen 1 to 4!");
                }

                return (int) choose;

            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
