package com.pluralsight.shop;

import java.util.Scanner;

public class OrderMenu {

    public void display() {

        Scanner scanner = new Scanner(System.in);

        boolean ordering = true;
        while (ordering) {

            displayStart();
            int userChoice = Integer.parseInt(scanner.nextLine().trim());

            if (userChoice == 0) {
                displayEnd();
                ordering = false;

            } else {
                orderSandwich();
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
    public void orderSandwich() {


    }

}