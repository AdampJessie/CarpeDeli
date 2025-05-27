package com.pluralsight.shop;

import java.util.List;

public class Cheese extends Topping {

    private String name;

    public Cheese(String type, String name) {
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
