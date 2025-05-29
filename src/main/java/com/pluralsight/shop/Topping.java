package com.pluralsight.shop;

public abstract class Topping{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Topping(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
