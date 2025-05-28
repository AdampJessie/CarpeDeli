package com.pluralsight.shop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String date, description;

    List<Product> order = new ArrayList<>();

    public Order(String description) {
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"));
        this.description = description;
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

    public void add(Product product){
        order.add(product);
    }

    public void remove(Product product){
        order.remove(product);
    }

    public void cancelOrder(){
        order.clear();
    }

    public double getTotal(){
        return order.stream()
                .mapToDouble(Product::getPrice).sum();
    }

    public void createReceipt(){
        System.out.println("Order #"+this.getDate());


    }

}
