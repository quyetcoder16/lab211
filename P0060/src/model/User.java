/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author quyet
 */
public class User {

    private int wallet;
    private ArrayList<Integer> listOfBill;

    public User() {
        this.listOfBill = new ArrayList<>();
    }

    public User(int wallet, ArrayList<Integer> listOfBill) {
        this.wallet = wallet;
        this.listOfBill = listOfBill;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Integer> getListOfBill() {
        return listOfBill;
    }

    public void setListOfBill(ArrayList<Integer> listOfBill) {
        this.listOfBill = listOfBill;
    }

    public void addNewBill(int value) {
        this.listOfBill.add(value);
    }

    public boolean checkCanBuy() {
        int res = 0;
        for (Integer integer : listOfBill) {
            res += integer;
        }
        return this.wallet >= res;
    }

    public int total() {
        int res = 0;
        for (Integer integer : listOfBill) {
            res += integer;
        }
        return res;
    }

}
