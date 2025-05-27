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

    public void add(Product product){
        order.add(product);
    }

    public double getTotal(){
        return order.stream()
                .mapToDouble(Product::getPrice).sum();
    }

}
