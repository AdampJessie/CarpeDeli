package com.pluralsight.shop;

public class Drink extends Product{

    private int size;
    private String flavor;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return super.getPrice()*this.size;
    }

    public Drink(double price, int size, String flavor) {
        super(price);
        this.size = size;
        this.flavor = flavor;
    }
}
