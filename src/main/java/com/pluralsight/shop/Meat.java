package com.pluralsight.shop;

public class Meat extends Topping {

    private String name;

    public Meat(String type, String name) {
        super(type);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
