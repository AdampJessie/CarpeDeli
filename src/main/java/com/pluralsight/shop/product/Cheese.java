package com.pluralsight.shop.product;

public class Cheese extends Topping {

    private double price = .75;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cheese(String name) {
        super(name);
    }


}
