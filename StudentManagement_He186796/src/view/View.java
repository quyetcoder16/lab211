/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.StudentConTroller;
import util.Validation;

/**
 *
 * @author quyet
 */
public class View {

    private final StudentConTroller studentConTroller = new StudentConTroller();
    private final Validation validation = new Validation();

    private static void printMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3.Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit\n");
        System.out.println("(Please chose 1 to create, 2 to find and sort, 3 to Update/delete, 4 to Report and 5 to Exit Program)");
    }

    public void run() {
        int chooseMenu;
        do {
            printMenu();
            chooseMenu = validation.validateInputChose();
            switch (chooseMenu) {
                case 1:
                    studentConTroller.addNewStudent();
                    break;
                case 2:
                    studentConTroller.findAndSort();
                    break;
            }
            studentConTroller.printList();
        } while (chooseMenu != 5);
    }
}
