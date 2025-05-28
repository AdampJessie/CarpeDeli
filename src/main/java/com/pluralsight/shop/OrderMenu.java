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

    public void displayEnd() {

        String endMessage = colorGreen + "Thank you for your business!\n" + colorBlue + "Have a great day!";
        System.out.println(colorCyan + textBorder + colorReset);
        System.out.println(endMessage);

    }


    public Order placeOrder() {
        Order order = new Order("New Order");
        boolean ordering = true;
        while (ordering) {
            System.out.println(colorCyan + textBorder + colorReset);

            System.out.println("1. Add Sandwich\n2. Add Chips\n3. Add Drink\n4. Check Out");
            System.out.println(colorCyan + textBorder + colorReset);

            System.out.print("Please select an item to add to your order\nIf you are finished, confirm and check out: ");
            int orderChoice = Integer.parseInt(scanner.nextLine().trim());

            switch (orderChoice) {
                case 1:
                    orderSandwich();
                    break;
                case 2:
                    addChips(order);
                    break;
                case 3:
                    addDrinks(order);
                    break;
                case 4:
                    orderCheck(order);
                    ordering = false;
                    break;
            }
        }
        return order;
    }

    public void orderSandwich() {

        System.out.println("1. Small\n2. Medium\n3. Large");
        System.out.print("Please select a size for your sandwich: ");
        int intSize = Integer.parseInt(scanner.nextLine().trim());
        String size = switch (intSize) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "";
        };

        System.out.println("1. White\n2. Wheat\n3. Rye\n4. Wrap");
        System.out.print("Please select the type of bread: ");
        int breadChoice = Integer.parseInt(scanner.nextLine().trim());
        String breadType = switch (breadChoice) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "";
        };

        System.out.println("1. Yes\n2. No");
        System.out.print("Toasted?: ");
        boolean toasted = (Integer.parseInt(scanner.nextLine().trim()) == 1);
        if (toasted) System.out.println("Toasted bread, coming right up!");

        System.out.println("1. Cheddar\n2. Provolone\n3. Swiss\n4. Mozzarella");
        System.out.print("Please select a cheese to add: ");
        int cheeseChoice = Integer.parseInt(scanner.nextLine().trim());
        String cheeseType = switch (cheeseChoice) {
            case 1 -> "Cheddar";
            case 2 -> "Provolone";
            case 3 -> "Swiss";
            case 4 -> "Mozzarella";
            default -> "";
        };

        System.out.println("1. Yes\n2. No");
        System.out.print("Extra Cheese?: ");
        boolean extraCheese = (Integer.parseInt(scanner.nextLine().trim()) == 1);


        System.out.println("1. Ham\n2. Turkey\n3. Salami\n4. Roast Beef\n5. Chicken");
        System.out.print("Please select a meat to add: ");
        int meatChoice = Integer.parseInt(scanner.nextLine().trim());
        String meatType = switch (meatChoice) {
            case 1 -> "Ham";
            case 2 -> "Turkey";
            case 3 -> "Salami";
            case 4 -> "Roast Beef";
            case 5 -> "Chicken";
            default -> "";
        };


        System.out.println("1. Yes\n2. No");
        System.out.print("Extra Meat?: ");
        boolean extraMeat = (Integer.parseInt(scanner.nextLine().trim()) == 1);

        System.out.println("1. Lettuce\n2. Onion\n3. Pickle\n4. Peppers\n5. Mushrooms");
        System.out.print("Please select a topping to add: ");
        int toppingChoice = Integer.parseInt(scanner.nextLine().trim());
        String topping = switch (toppingChoice) {
            case 1 -> "Lettuce";
            case 2 -> "Onion";
            case 3 -> "Pickle";
            case 4 -> "Peppers";
            case 5 -> "Mushrooms";
            default -> "";
        };
        System.out.println("1. Mayo\n2. Mustard\n3. Vinaigrette\n4. Au Jus\n5. Guacamole");
        System.out.print("Please select a sauce to add: ");
        int sauceChoice = Integer.parseInt(scanner.nextLine().trim());
        String sauce = switch (sauceChoice) {
            case 1 -> "Mayo";
            case 2 -> "Mustard";
            case 3 -> "Vinaigrette";
            case 4 -> "Au Jus";
            case 5 -> "Guacamole";
            default -> "";
        };
    }

    public void addChips(Order order) {
        System.out.println(colorCyan + textBorder + colorReset);

        System.out.println("1. Potato\n2. Kettle\n3. Buffalo");
        System.out.println(colorCyan + textBorder + colorReset);

        System.out.print("Please select the chips you would like: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        String chipFlavor = switch (choice) {
            case 1 -> "Potato";
            case 2 -> "Kettle";
            case 3 -> "Buffalo";
            default -> "";
        };

        System.out.println(colorCyan + textBorder + colorReset);

        if (!chipFlavor.isEmpty()) {
            order.add(new Chip(1.50, chipFlavor));
            System.out.println("Added " + chipFlavor + " Chips for $1.50!");
        } else System.out.println("Failed to add chips! Please try again.");


    }

    public void addDrinks(Order order) {
        System.out.println(colorCyan + textBorder + colorReset);

        System.out.println("1. Small\n2. Medium\n3. Large");
        System.out.println(colorCyan + textBorder + colorReset);

        System.out.print("Please select a size for your drink: ");
        int intSize = Integer.parseInt(scanner.nextLine().trim());
        String stringSize = switch (intSize) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "";
        };

        double drinkPrice = 1.50 + (.50 * intSize);

        System.out.println(colorCyan + textBorder + colorReset);

        System.out.println("1. Water\n2. Pepsi\n3. Sprite");
        System.out.println(colorCyan + textBorder + colorReset);

        System.out.println("Please select the drink you would like: ");
        int drinkChoice = Integer.parseInt(scanner.nextLine().trim());

        String drinkFlavor = switch (drinkChoice) {
            case 1 -> "Water";
            case 2 -> "Pepsi";
            case 3 -> "Sprite";
            default -> "";
        };

        if (drinkFlavor.equalsIgnoreCase("Water"))
            drinkPrice = 0.0;

        System.out.println(colorCyan + textBorder + colorReset);

        if (!drinkFlavor.isEmpty() && !stringSize.isEmpty()) {
            order.add(new Drink(drinkPrice, intSize, drinkFlavor));
            System.out.printf("Successfully added a %s %s for $%.2f!\n", stringSize, drinkFlavor, drinkPrice);
        } else System.out.println("Failed to add drink! Please try again.");

    }

    public void orderCheck(Order order) {

        System.out.println(order.receipt());

        boolean confirming = true;
        while (confirming) {
            System.out.println("Everything accounted for?");
            System.out.println("1. Confirm\n2. Cancel");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                checkOut(order);
                confirming = false;
            } else if (choice == 2) {
                order.cancelOrder();
                System.out.println("Order cancelled! Try again?");
                confirming = false;
            } else System.out.println("Invalid option! Please try again.");
        }


    }

    public void checkOut(Order order) {

        OrderFileManager fileManager = new OrderFileManager();
        fileManager.saveReceipt(order);

        String successMessage = "Sucess! Order confirmed, receipt saved!";
        System.out.println(colorGreen + successMessage + colorReset);
        displayEnd();

    }


}