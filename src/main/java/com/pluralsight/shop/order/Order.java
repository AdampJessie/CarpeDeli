package com.pluralsight.shop.order;

import com.pluralsight.shop.product.Chip;
import com.pluralsight.shop.product.Drink;
import com.pluralsight.shop.product.Product;
import com.pluralsight.shop.product.Sandwich;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String date, description;

    private List<Product> order = new ArrayList<>();

    public Order(String description) {
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"));
        this.description = description;
    }

    public List<Product> getOrder() {
        return order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void add(Product product) {
        order.add(product);
    }

    public void remove(Product product) {
        order.remove(product);
    }

    public void cancelOrder() {
        order.clear();
    }

    public double getTotal() {
        return order.stream()
                .mapToDouble(Product::getPrice).sum();
    }

    public Order(List<Product> order) {
        this.order = order;
    }

    public String receipt() {

        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("\n").append("+").append("-".repeat(48)).append("+")
                .append(String.format("\n| %-46s |", "Carpe Deli - Seize the Treat!"));
        receiptBuilder.append(String.format("\n| %-46s |", "Order #"+getDate()))
                .append("\n").append("+").append("-".repeat(48)).append("+");
        order.forEach(product -> {
            if (product instanceof Sandwich)
                receiptBuilder.append("\n| ").append(product);
        });
        order.forEach(product -> {
            if (product instanceof Chip) receiptBuilder.append("\n| ").append(product);

        });
        order.forEach(product -> {
            if (product instanceof Drink) receiptBuilder.append("\n| ").append(product);
        });
        receiptBuilder.append("\n").append("+").append("-".repeat(48)).append("+");
        receiptBuilder.append(String.format("\n| %-46s |", String.format("Total Due - %.2f", getTotal())))
                .append("\n").append("+").append("-".repeat(48)).append("+");



        return receiptBuilder.toString();
    }

    public void receiptToFile(){
        OrderFileManager fileManager = new OrderFileManager();
        fileManager.saveReceipt(this);
    }

}
