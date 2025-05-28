package com.pluralsight.shop;

public abstract class Topping{

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Topping(String type) {
        this.type = type;
    }
}
