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
                placeOrder();
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
        System.out.println("Please select an item to add to your order");
        System.out.println("1. Sandwich\n2. Chips\n3. Drink");

        int orderChoice = Integer.parseInt(scanner.nextLine().trim());

        switch (orderChoice){
            case 1:
                orderSandwich();
            case 2:
                orderChips(order);
            case 3:
                orderDrinks(order);
        }

        return order;
    }

    public void orderSandwich() {

        Sandwich sandwich = new Sandwich();

    }

    public void orderChips(Order order){
        System.out.println("Please select the type of chips you would like");
        System.out.println("1. Potato Chips\n2. Kettle Chips\n3. Sun Chips");
        int chipChoice = Integer.parseInt(scanner.nextLine().trim());
        switch (chipChoice){
            case 1:
                order.orderAdd(new Chip("Potato Chips"));
            case 2:
                order.orderAdd(new Chip("Kettle Chips"));
            case 3:
                order.orderAdd(new Chip("Sun Chips"));
        }
    }
    public void orderDrinks(Order order){
        System.out.println("Please select the type of chips you would like");
        System.out.println("1. Potato Chips\n2. Kettle Chips\n3. Sun Chips");
        int chipChoice = Integer.parseInt(scanner.nextLine().trim());
        switch (chipChoice){
            case 1:
                order.orderAdd(new Chip("Water"));
            case 2:
                order.orderAdd(new Chip("Pepsi"));
            case 3:
                order.orderAdd(new Chip("Sun Chips"));
        }
    }

}