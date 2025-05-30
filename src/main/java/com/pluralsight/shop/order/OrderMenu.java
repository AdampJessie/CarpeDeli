package com.pluralsight.shop.order;

import com.pluralsight.shop.product.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMenu {

    Scanner scanner = new Scanner(System.in);
    private final String colorReset = "\u001B[0m";
    private final String colorCyan = "\u001B[36m";
    private final String colorGreen = "\u001B[32m";
    private final String colorBlue = "\u001B[34m";
    private final String colorRed = "\u001B[31m";
    private final String textBorder = "-".repeat(50);

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

    public void placeOrder() {
        Order order = new Order("New Order");
        boolean ordering = true;
        while (ordering) {
            System.out.println(colorCyan + textBorder + colorReset);
            System.out.println("1. Add Sandwich\n2. Add Chips\n3. Add Drink\n4. Checkout\n5. Cancel Order");
            System.out.print("Please select an item to add to your order\nIf you are finished, confirm and check out: ");
            int orderChoice = Integer.parseInt(scanner.nextLine().trim());

            switch (orderChoice) {
                case 1:
                    orderSandwich(order);
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
                case 5:
                    order.cancelOrder();
                    ordering = false;
                    break;

            }
        }
    }

    public void orderCheck(Order order) {

        System.out.println(colorCyan + textBorder + colorReset);
        if (order.getOrder().isEmpty()) {
            System.out.println("Nothing to checkout!");
            return;
        }
        System.out.println(order.receipt());

        boolean correct = promptYesNo("Everything accounted for?");

        if (correct) {
            order.receiptToFile();
        } else {
            order.cancelOrder();
            System.out.println(colorCyan + textBorder + colorReset);
            System.out.println("Order cancelled! Try again?");
        }
    }

    public void orderSandwich(Order order) {

        boolean sizing = true;
        int size = 0;
        while (sizing) {
            System.out.println(colorCyan + textBorder + colorReset);
            System.out.println("1. Small (4\")\n2. Medium (8\")\n3. Large (12\")");
            System.out.print("Please select a size for your sandwich: ");
            int sizeChoice = Integer.parseInt(scanner.nextLine().trim());
            if (sizeChoice == 1 || sizeChoice == 2 || sizeChoice == 3) {
                size = sizeChoice;
                sizing = false;
            } else {
                System.out.println(colorCyan + textBorder + colorReset);
                System.out.println("Invalid choice!");
            }

        }

        String breadType = null;
        boolean breading = true;
        while (breading) {
            System.out.println(colorCyan + textBorder + colorReset);
            System.out.println("1. White\n2. Wheat\n3. Rye\n4. Wrap");
            System.out.print("Please select the type of bread: ");
            int breadChoice = Integer.parseInt(scanner.nextLine().trim());
            if (breadChoice >= 1 && breadChoice <= 4) {
                breadType = switch (breadChoice) {
                    case 1 -> "White";
                    case 2 -> "Wheat";
                    case 3 -> "Rye";
                    case 4 -> "Wrap";
                    default -> "";
                };
                System.out.println(colorCyan + textBorder + colorReset);
                System.out.println(breadType + ", great choice!");
                breading = false;
            } else {
                System.out.println(colorCyan + textBorder + colorReset);
                System.out.println("Invalid choice!");
            }
        }

        boolean isToasted = false;

        if (!breadType.equalsIgnoreCase("Wrap")) {
            isToasted = promptYesNo("Would you like that toasted?");
            if (isToasted) {
                System.out.println(colorCyan + textBorder + colorReset);
                System.out.println("Toasted bread, coming right up!");
            }
        }

        List<Topping> meatOptions = getAvailableToppings("Meat");
        List<Topping> sandwichToppings = new ArrayList<>(selectToppings(meatOptions));

        boolean extraMeat = false;
        if (sandwichToppings.stream().anyMatch(Meat -> true))
            extraMeat = promptYesNo("Extra Meat? ($)");

        List<Topping> cheeseOptions = getAvailableToppings("Cheese");
        sandwichToppings.addAll(selectToppings(cheeseOptions));

        boolean extraCheese = false;
        if (sandwichToppings.stream().anyMatch(Cheese -> true))
            extraCheese = promptYesNo("Extra Cheese? ($)");

        List<Topping> regularToppingOptions = getAvailableToppings("regularTopping");
        sandwichToppings.addAll(selectToppings(regularToppingOptions));

        List<Topping> sauceOptions = getAvailableToppings("Sauce");
        sandwichToppings.addAll(selectToppings(sauceOptions));

        order.add(new Sandwich(isToasted, extraMeat, extraCheese, breadType, size, sandwichToppings));

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
            order.add(new Chip(chipFlavor));
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

        System.out.println(colorCyan + textBorder + colorReset);

        if (!drinkFlavor.isEmpty() && !stringSize.isEmpty()) {
            order.add(new Drink(intSize, drinkFlavor));
            System.out.printf("Successfully added a %s %s for $%.2f!\n", stringSize, drinkFlavor, drinkPrice);
        } else System.out.println("Failed to add drink! Please try again.");

    }


    public List<Topping> getAvailableToppings(String topping) {
        List<Topping> availableToppings = null;

        if (topping.equalsIgnoreCase("Meat")) {
            availableToppings = new ArrayList<>(List.of
                    (new Meat("Ham")
                            , new Meat("Turkey")
                            , new Meat("Salami")
                            , new Meat("Roast Beef")
                            , new Meat("Chicken")));
        }
        if (topping.equalsIgnoreCase("Cheese")) {
            availableToppings = new ArrayList<>(List.of
                    (new Cheese("American")
                            , new Cheese("Cheddar")
                            , new Cheese("Provolone")
                            , new Cheese("Swiss")
                            , new Cheese("Mozzarella")));
        }
        if (topping.equalsIgnoreCase("regularTopping")) {
            availableToppings = new ArrayList<>(List.of
                    (new RegularTopping("Lettuce")
                            , new RegularTopping("Onion")
                            , new RegularTopping("Pickle")
                            , new RegularTopping("Peppers")
                            , new RegularTopping("Mushrooms")));
        }
        if (topping.equalsIgnoreCase("Sauce")) {
            availableToppings = new ArrayList<>(List.of
                    (new Sauce("Mayo")
                            , new Sauce("Mustard")
                            , new Sauce("Vinaigrette")
                            , new Sauce("Au Jus")
                            , new Sauce("Guacamole")));
        }
        return availableToppings;
    }

    public List<Topping> selectToppings(List<Topping> toppingsOptions) {

        List<Topping> toppingsSelected = new ArrayList<>();

        boolean selecting = true;
        while (selecting) {
            try {
                System.out.println(colorCyan + textBorder + colorReset);
                for (int i = 0; i < toppingsOptions.size(); i++)
                    System.out.println(i + 1 + ". " + toppingsOptions.get(i));
                System.out.println("0. Finished");
                System.out.print("Please select a topping to add: ");
                int toppingChoice = Integer.parseInt(scanner.nextLine().trim());
                switch (toppingChoice) {
                    case 1:
                        toppingsSelected.add(toppingsOptions.get(0));
                        toppingsOptions.remove(0);
                        break;
                    case 2:
                        toppingsSelected.add(toppingsOptions.get(1));
                        toppingsOptions.remove(1);
                        break;
                    case 3:
                        toppingsSelected.add(toppingsOptions.get(2));
                        toppingsOptions.remove(2);
                        break;
                    case 4:
                        toppingsSelected.add(toppingsOptions.get(3));
                        toppingsOptions.remove(3);
                        break;
                    case 5:
                        toppingsSelected.add(toppingsOptions.get(4));
                        toppingsOptions.remove(4);
                        break;
                    case 0:
                        selecting = false;
                        break;

                    default:
                        System.out.println(colorCyan + textBorder + colorReset);
                        System.out.println("Invalid Choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println(colorCyan + textBorder + colorReset);
                System.out.println("Something went wrong! Please try again.");
            }
        }

        return toppingsSelected;
    }

    public boolean promptYesNo(String promptMessage) {

        boolean asking = true;
        int choice = 0;
        while (asking) {
            System.out.println(colorCyan + textBorder + colorReset);
            System.out.println(promptMessage);
            System.out.print("(1. Yes) (2. No): ");
            choice = Integer.parseInt(scanner.nextLine());

            if (!(choice == 1) && !(choice == 2))
                System.out.println("Invalid option! Please try again.");
            else asking = false;
        }

        return choice == 1;

    }


}