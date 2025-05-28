package com.pluralsight.shop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderFileManager {

    public void saveReceipt(Order order){

        String fileName = order.getDate()+".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("receipts/"+fileName, true))) {

            bw.write("This is just a test!");

            System.out.println("Receipt saved successfully!");
        } catch (IOException e) {
            System.out.println("Something went wrong!\n"+e);
        }

    }

}
