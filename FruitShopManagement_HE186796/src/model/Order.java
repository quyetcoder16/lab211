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
public class Order {

    public int orderId;
    String customerName;
    ArrayList<OrderItem> orderItems;

    public Order(int orderId, String customerName, ArrayList<OrderItem> orderItems) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderItems = orderItems;
    }

    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getAmount();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Customer: ").append(customerName).append("\n");
        for (OrderItem item : orderItems) {
            sb.append(item).append("\n");
        }
        sb.append("Total: $").append(getTotalAmount()).append("\n");
        return sb.toString();
    }
}
