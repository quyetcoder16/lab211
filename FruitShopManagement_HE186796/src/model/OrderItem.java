/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quyet
 */
public class OrderItem {

    Fruit fruit;
    int quantity;

    public OrderItem(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public double getAmount() {
        return fruit.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-10d %-10.2f %-10.2f", fruit.getFruitName(), quantity, fruit.getPrice(), getAmount());
    }
}
