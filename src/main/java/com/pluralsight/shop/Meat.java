package com.pluralsight.shop;

public class Meat extends Topping {

    boolean isExtra = false;

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

    public Meat(String name) {
        super(name);
    }
}
