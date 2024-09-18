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
public class Validation {

    private final Scanner SCANNER = new Scanner(System.in);

    public int validateInputChose() {
        while (true) {
            try {
                System.out.print("Enter your choose: ");
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
                    throw new IllegalArgumentException("Error: choose <1 , please enter choose bettwen 1 to 5!");
                }

                if (choose > 5) {
                    throw new IllegalArgumentException("Error: choose > 5 , please enter choose bettwen 1 to 5!");
                }

                return (int) choose;

            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateStudentName() {
        while (true) {
            try {
                System.out.print("Enter Student Name: ");
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

    public String genarateId(String prefix, int idNumber) {
        return prefix + String.format("%08d", idNumber);
    }

    public String validateCourseName() {
        while (true) {
            try {
                System.out.print("Enter course name: ");
                String input = SCANNER.nextLine();
                input = input.trim();
                if (input == null || input.isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                if (input.equalsIgnoreCase("Java")) {
                    return "Java";
                }

                if (input.equalsIgnoreCase(".net")) {
                    return ".Net";
                }

                if (input.equalsIgnoreCase("C/C++")) {
                    return "C/C++";
                }

                throw new IllegalArgumentException("Course name is not define!");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean validateConfirm() {
        while (true) {
            try {
                System.out.print("Do you Want to continue(Y/N)? Chose Y to continue,N to return main screen!");
                String input = SCANNER.nextLine();
                input = input.trim();
                if (input == null || input.isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                if (input.equalsIgnoreCase("Y")) {
                    return true;
                }

                if (input.equalsIgnoreCase("N")) {
                    return false;
                }

                throw new IllegalArgumentException("Please enter Y or N");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getInt() {
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

                long inputParseInt = Long.parseLong(input);

                if (inputParseInt > Integer.MAX_VALUE || inputParseInt < Integer.MIN_VALUE) {
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

    /**
     *
     * @param minValue
     * @param maxValue
     * @return input between min value and max value
     */
    public int getIntBetween(int minValue, int maxValue) {
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

                long inputParseInt = Long.parseLong(input);

                if (inputParseInt > maxValue || inputParseInt < minValue) {
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

    public String getString() {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                return input;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
