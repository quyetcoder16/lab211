/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import util.Validate;

/**
 *
 * @author quyet
 */
public class WalletController {

    private final User user;
    private final Validate validate;

    public WalletController(User user, Validate validate) {
        this.user = user;
        this.validate = validate;
    }

    public WalletController() {
        this.user = new User();
        this.validate = new Validate();
    }

    public void shoppingProgram() {
        System.out.println("input number of bill:");
        int numberOfBuill = validate.getInt();
        for (int i = 0; i < numberOfBuill; i++) {
            System.out.println("input value of bill " + (i + 1) + " : ");
            int bill = validate.getInt();
            user.addNewBill(bill);
        }

        System.out.println("input value of wallet: ");
        int wallet = validate.getInt();
        user.setWallet(wallet);
        
        System.out.println("this is total of bill: " + user.total());
        if (user.checkCanBuy()) {
            System.out.println("You can buy it");
        } else {
            System.out.println("You can’t buy it");
        }
    }

}
