/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import model.Fruit;
import model.Order;
import model.OrderItem;
import util.Validate;

/**
 *
 * @author quyet
 */
public class FruitShopController {

    private final ArrayList<Fruit> fruits;
    ;
    private final Validate validate;
    private final Hashtable<Integer, Order> orders = new Hashtable<>();
    int orderCounter = 1;

    Scanner sc = new Scanner(System.in);

    public FruitShopController() {
        this.fruits = new ArrayList<>();
        this.validate = new Validate();

    }

    public FruitShopController(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
        this.validate = new Validate();
    }

    public void createFruit() {
        while (true) {
            System.out.print("Enter Fruit ID: ");
            String fruitId = validate.getFruitId();
            System.out.print("Enter Fruit Name: ");
            String fruitName = validate.getFruitName();
            System.out.print("Enter Price: ");
            double price = validate.getPrice();
            System.out.print("Enter Quantity: ");
            int quantity = validate.getQuantity();

            System.out.print("Enter Origin: ");
            String origin = validate.getOrigin();

            fruits.add(new Fruit(fruitId, fruitName, price, quantity, origin));

            System.out.print("Do you want to continue (Y/N)? ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void viewOrders() {
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }

    public void shopping() {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        while (true) {
            System.out.println("List of Fruit:");
            System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "ID", "Fruit Name", "Origin", "Price", "Quantity");
            for (int i = 0; i < fruits.size(); i++) {
                System.out.printf("%-5d %s\n", (i + 1), fruits.get(i));
            }

            System.out.print("Select Item by number: ");
            int itemIndex = sc.nextInt() - 1;
            Fruit selectedFruit = fruits.get(itemIndex);
            System.out.println("You selected: " + selectedFruit.getFruitName());

            System.out.print("Please input quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // consume newline

            if (quantity <= selectedFruit.getQuantity()) {
                orderItems.add(new OrderItem(selectedFruit, quantity));
                selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            } else {
                System.out.println("Insufficient quantity.");
            }

            System.out.print("Do you want to order now (Y/N)? ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("Input your name: ");
                String customerName = sc.nextLine();
                // Create an Order with a unique ID
                Order order = new Order(orderCounter++, customerName, orderItems);
                orders.put(order.orderId, order);
                break;
            }
        }
    }
}
