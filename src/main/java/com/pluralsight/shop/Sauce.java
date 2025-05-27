package com.pluralsight.shop;

public class Sauce extends Topping{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sauce(String type, String name) {
        super(type);
        this.name = name;
    }
}
