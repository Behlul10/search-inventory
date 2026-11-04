package com.pluralsight;

import java.util.ArrayList;
import java.io.*;

public class InventoryIO {
    /**
     * Reads products from a text file and returns them as an ArrayList.
     */

    public static ArrayList<Product> loadProducts(String filePath) {
        ArrayList<Product> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());

                    Product product = new Product(id, name, price);
                    inventory.add(product);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file to be read.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error Loading Inventory: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return inventory;
    }

    /**
     * Saves the list of products to a text file
     */

    public static void saveProducts(ArrayList<Product> inventory, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Product p : inventory) {
                String lineToWrite = p.getId() + "|" + p.getName() + "|" + p.getPrice() + "\n";
                writer.write(lineToWrite);
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }
}
