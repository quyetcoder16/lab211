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

    public int getInt() {
        while (true) {
            try {
               
                String input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }
               

                
                
                
                
                
                long choose = Long.parseLong(input);

                return (int) choose;

            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
