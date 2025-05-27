package com.pluralsight.shop;

public class Chip extends Product{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Chip(double price, String type) {
        super(price);
        this.type = type;
    }
}
