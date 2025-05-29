package com.pluralsight.shop;

import java.util.List;

public class Sandwich extends Product{

    private boolean isToasted;
    private int breadType, size;
    private List<Topping> toppings;

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public int getBreadType() {
        return breadType;
    }

    public void setBreadType(int breadType) {
        this.breadType = breadType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public void removeTopping(Topping topping){

    }

    public Sandwich(double price, boolean isToasted, int breadType, int size, List<Topping> toppings) {
        super(price);
        this.isToasted = isToasted;
        this.breadType = breadType;
        this.size = size;
        this.toppings = toppings;
    }
}
