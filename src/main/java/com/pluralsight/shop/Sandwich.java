package com.pluralsight.shop;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product{
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

    public List<Meat> getMeatToppings(){
        List<Meat> meats = new ArrayList<>();

        toppings.forEach(topping ->{
            if (topping instanceof Meat meat)
                meats.add(meat);
        });

        return meats;
    }

    public List<Cheese> getCheeseToppings(){
        List<Cheese> cheeses = new ArrayList<>();

        toppings.forEach(topping ->{
            if (topping instanceof Cheese cheese)
                cheeses.add(cheese);
        });

        return cheeses;
    }

    @Override
    public double getPrice() {

        price = 4 + (1.50 * getSize());
        price += getCheeseToppings().size() * (.75 * getSize());
        if (extraCheese) price += .30 * getSize();
        price += getMeatToppings().size() * getSize();
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

        sandwichString.append(String.format("Sandwich - %d\" - %s - %s | %.2f", size, breadType, toasted, getPrice()));
        toppings.forEach(topping ->{
            if (topping instanceof Meat)
                sandwichString.append("\n\t-").append(topping);
            if (topping instanceof Cheese)
                sandwichString.append("\n\t-").append(topping);
            if (topping instanceof RegularTopping)
                sandwichString.append("\n\t-").append(topping);
            if (topping instanceof Sauce)
                sandwichString.append("\n\t-").append(topping);
        });

        return sandwichString.toString();
    }
}
