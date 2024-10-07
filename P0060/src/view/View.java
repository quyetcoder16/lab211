/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.WalletController;

/**
 *
 * @author quyet
 */
public class View {

    private WalletController walletController;

    public View() {
        walletController = new WalletController();
    }

    private static void printMenu() {
        System.out.println("======= Shopping program ==========");
    }

    public void run() {
        
        printMenu();
        walletController.shoppingProgram();
    }
}
