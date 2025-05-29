package com.pluralsight.shop;

public class Drink extends Product {

    private int size;
    private String flavor;
    private double price;

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
        if (flavor.equalsIgnoreCase("Water"))
            return 0;
        else return 1.50 + (.50 * getSize());
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public Drink(int size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getStringSize() {
        return switch (getSize()) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "";
        };

    }

    @Override
    public String toString() {
        return String.format("Drink - %-6s - %-10s | %-5.2f", flavor, getStringSize(), getPrice());
    }
}
