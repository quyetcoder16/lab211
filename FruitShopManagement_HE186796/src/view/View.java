/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.FruitShopController;
import util.Validate;

/**
 *
 * @author quyet
 */
public class View {

    private final Validate validation;
    private final FruitShopController fruitShopController = new FruitShopController();

    public View() {
        this.validation = new Validate();
    }

    private static void printMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("\t1.Create Fruit");
        System.out.println("\t2.View orders");
        System.out.println("\t3.Shopping (for buyer)");
        System.out.println("\t4. Exit\n");
        System.out.println(" (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program)");
    }

    public void run() {
        int chooseMenu;
        do {
            printMenu();
            chooseMenu = validation.getChoose();
            switch (chooseMenu) {
                case 1:
                    fruitShopController.createFruit();
                    break;
                case 2:
                    fruitShopController.viewOrders();
                    break;
                case 3:
                    fruitShopController.shopping();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option, please choose again.");
            }

        } while (chooseMenu != 4);
    }
}
