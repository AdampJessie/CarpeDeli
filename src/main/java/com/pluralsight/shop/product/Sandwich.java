package com.pluralsight.shop.product;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private double price = 0;
    private boolean isToasted, extraMeat, extraCheese;
    private String breadType;
    private int size;
    private List<Topping> toppings;

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Meat> getMeatToppings() {
        List<Meat> meats = new ArrayList<>();

        toppings.forEach(topping -> {
            if (topping instanceof Meat meat)
                meats.add(meat);
        });

        return meats;
    }

    public List<Cheese> getCheeseToppings() {
        List<Cheese> cheeses = new ArrayList<>();

        toppings.forEach(topping -> {
            if (topping instanceof Cheese cheese)
                cheeses.add(cheese);
        });

        return cheeses;
    }

    @Override
    public double getPrice() {

        price = 4 + (1.50 * getSize());
        price += getSize() * (getCheeseToppings().stream().mapToDouble(Cheese::getPrice).sum());
        if (extraCheese) price += .30 * getSize();
        price += getSize() * (getMeatToppings().stream().mapToDouble(Meat::getPrice).sum());
        if (extraMeat) price += .50 * getSize();
        return price;
    }

    public Sandwich(boolean isToasted, boolean extraMeat, boolean extraCheese, String breadType, int size, List<Topping> toppings) {
        this.isToasted = isToasted;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.breadType = breadType;
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        String toasted = (isToasted) ? "Toasted" : "Not Toasted";
        StringBuilder sandwichString = new StringBuilder();

        sandwichString.append(String.format("Sandwich - %2d\" - %-5s - %-12s | $%-5.2f |", size * 4, breadType, toasted, getPrice()));


        toppings.forEach(topping -> {
            if (topping instanceof Meat)
                sandwichString.append(String.format("\n|%-46s|", "\t-" + topping));
            if (topping instanceof Cheese)
                sandwichString.append(String.format("\n|%-46s|", "\t-" + topping));
            if (topping instanceof RegularTopping)
                sandwichString.append(String.format("\n|%-46s|", "\t-" + topping));
            if (topping instanceof Sauce)
                sandwichString.append(String.format("\n|%-46s|", "\t-" + topping));
        });

        return sandwichString.toString();
    }
}
