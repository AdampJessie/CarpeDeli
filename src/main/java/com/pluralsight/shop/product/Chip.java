package com.pluralsight.shop.product;

public class Chip extends Product{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Chip(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return String.format("Chips - %-29s | $%-5.2f |", type, getPrice());
    }
}
