package com.pluralsight.shop;

import java.util.List;

public class Cheese extends Topping {

    boolean isExtra;

    public double getPrice(Sandwich sandwich) {
        double price = 1.00 * sandwich.getSize();
        return isExtra ? price : price + (price/2);
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public Cheese(String name) {
        super(name);
    }
}
