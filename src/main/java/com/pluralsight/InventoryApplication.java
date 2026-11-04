package com.pluralsight;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class InventoryApplication {
    public static void main(String[] args) {
        String fileName = "src/main/resources/inventory.csv";

        // load data using new class
        ArrayList<Product> inventory = InventoryIO.loadProducts(fileName); //getInventory();

        //Display current inventory
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("ID:  %d | Name: %s | Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }

        Scanner myScanner = new Scanner(System.in);
        System.out.println("\nEnter new product ID:");
        int id = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter product name:");
        String name = myScanner.nextLine();

        System.out.println("Enter Price:");
        double price = Double.parseDouble(myScanner.nextLine());

        Product newProduct = new Product(id, name, price);
        inventory.add(newProduct);

        //save updated inventory
        InventoryIO.saveProducts(inventory,fileName);
        System.out.println("Inventory saved successfully");

        myScanner.close();
//
//        String lineToWrite;
//
//        try (FileWriter writer = new FileWriter("src/main/resources/inventory.csv", true)){
//            for (int i = 0; i < inventory.size(); i++) {
//                Product p = inventory.get(i);
//
//                lineToWrite = p.getId() + "|" + p.getName() + "|" + p.getPrice() + "\n";
//
//                writer.write(lineToWrite);
//
//                System.out.printf("id: %d %s - Price: $%.2f%n", p.getId(), p.getName(), p.getPrice());
//            }
//            writer.close();
//        } catch(IOException e){
//            System.out.println("ERRORR: Could not write to file.");
//            throw new RuntimeException(e);
//
//        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        //product 1
        Product hammer = new Product(4567, "Hammer 10' 2x4 (grade B)", 9.99);
        inventory.add(hammer);

        //product 2
        Product screw = new Product(4568, "Magic Screw", 0.05);
        inventory.add(screw);

        //product 3
        Product car = new Product(4569, "Chinese EV (No Tariff)", 1_000.00);
        inventory.add(car);

        //product 4
        Product shoes = new Product(4570, "Timmy-Tim's 10.5 Mens", 156.34);
        inventory.add(shoes);

        //product 5
        Product door = new Product(4571, "Titanium Nuclear-Level Door", 1_500);
        inventory.add(door);

        return inventory;
    }

}

