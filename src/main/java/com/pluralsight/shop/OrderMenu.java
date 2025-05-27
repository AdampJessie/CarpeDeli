package com.pluralsight.shop;

import java.util.Scanner;

public class OrderMenu {

    Scanner scanner = new Scanner(System.in);

    public void display() {


        boolean ordering = true;
        while (ordering) {

            displayStart();
            int userChoice = Integer.parseInt(scanner.nextLine().trim());

            if (userChoice == 0) {
                displayEnd();
                ordering = false;

            } else {
                Order newOrder = placeOrder();
                newOrder.order.forEach(System.out::println);
            }

        }

    }


    private final String colorReset = "\u001B[0m";
    private final String colorCyan = "\u001B[36m";
    private final String colorGreen = "\u001B[32m";
    private final String colorBlue = "\u001B[34m";
    private final String colorRed = "\u001B[31m";
    private final String textBorder = "-".repeat(50);

    public void displayStart() {

        String welcomeMessage = "Welcome to " + colorGreen + "Carpe Deli" + colorReset + "! "
                + colorBlue + "\nSeize the sandwich of your choice!";
        String promptMessage = colorGreen + "1. New order\n" + colorRed + "0. Exit";

        System.out.println(colorCyan + textBorder + colorReset);
        System.out.println(welcomeMessage + colorReset);
        System.out.println(colorCyan + textBorder + colorReset);
        System.out.println(promptMessage + colorReset);
        System.out.println(colorCyan + textBorder + colorReset);
        System.out.print("Please select an option: ");
    }
    public void displayEnd(){
        String endMessage = colorGreen + "Thank you for your business!\n" + colorBlue + "Have a great day!";

        System.out.println(colorCyan + textBorder + colorReset);
        System.out.println(endMessage);
        System.out.println(colorCyan + textBorder + colorReset);


    }

    public Order placeOrder(){
        Order order = new Order("New Order");
        boolean ordering = true;
        while (ordering) {
            System.out.println(textBorder);
            System.out.println("1. Sandwich\n2. Chips\n3. Drink\n4. Finish and Pay");
            System.out.println(textBorder);
            System.out.print("Please select an item to add to your order\nOr if your order is completed, finish and pay: ");
            int orderChoice = Integer.parseInt(scanner.nextLine().trim());

            switch (orderChoice) {
                case 1:
                    orderSandwich();
                    break;
                case 2:
                    orderChips(order);
                    break;
                case 3:
                    orderDrinks(order);
                    break;
                case 4:
                    checkOut();
                    ordering = false;
                    break;
            }
        }
        return order;
    }

    public void orderSandwich() {
    }

    public void orderChips(Order order){
        System.out.println(textBorder);
        System.out.println("1. Potato\n2. Kettle\n3. Buffalo");
        System.out.println(textBorder);
        System.out.print("Please select the chips you would like: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        String chipFlavor = switch (choice) {
            case 1 -> "Potato";
            case 2 -> "Kettle";
            case 3 -> "Buffalo";
            default -> "";
        };

        System.out.println(textBorder);
        if (!chipFlavor.isEmpty()){
            order.add(new Chip(1.50, chipFlavor));
            System.out.println("Added " + chipFlavor + " Chips for $1.50!");
        }else System.out.println("Failed to add chips! Please try again.");


    }
    public void orderDrinks(Order order){
        System.out.println(textBorder);
        System.out.println("1. Small\n2. Medium\n3. Large");
        System.out.println(textBorder);
        System.out.print("Please select a size for your drink: ");
        int intSize = Integer.parseInt(scanner.nextLine().trim());
        String stringSize = switch (intSize) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "";
        };

        double drinkPrice = 1.50 + (.50 * intSize);

        System.out.println(textBorder);
        System.out.println("1. Water\n2. Pepsi\n3. Sprite");
        System.out.println(textBorder);
        System.out.println("Please select the drink you would like: ");
        int drinkChoice = Integer.parseInt(scanner.nextLine().trim());

        String drinkFlavor = "";
        switch (drinkChoice){
            case 1:
                drinkFlavor = "Water";
                drinkPrice = 0;
                break;
            case 2:
                drinkFlavor = "Pepsi";
                break;
            case 3:
                drinkFlavor = "Sprite";
                break;
        }

        System.out.println(textBorder);
        if (!drinkFlavor.isEmpty()) {
            order.add(new Drink(drinkPrice, intSize, drinkFlavor));
            System.out.printf("Successfully added a %s %s for $%.2f!\n", stringSize, drinkFlavor, drinkPrice);
        }else System.out.println("Failed to add drink! Please try again.");

    }

    public void checkOut(){

    }

}