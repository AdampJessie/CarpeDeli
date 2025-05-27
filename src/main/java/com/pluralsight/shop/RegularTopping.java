package com.pluralsight.shop;

public class RegularTopping extends Topping{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegularTopping(String type, String name) {
        super(type);
        this.name = name;
    }
}
