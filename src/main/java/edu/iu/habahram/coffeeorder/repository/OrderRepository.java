package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

@Repository
public class OrderRepository {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "db.txt";

    private static void appendToFile(Path path, String content) throws Exception {
        //Write to file
        Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "espresso":
                beverage = new Espresso();
                break;
            case "house blend":
                beverage = new HouseBlend();
                break;
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk": //Milk condiment now wrapped around the beverage
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        //Search through the file and add a unique number to the receipt

        int id = 0; //Increment if the id already exists
        Path path = Paths.get(DATABASE_NAME); //Iterate through the file to find a unique id
        while (Files.exists(path)) {
            String content = Files.readString(path);
            String[] lines = content.split(NEW_LINE);
            boolean exists = false;
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    int currentId = Integer.parseInt(parts[0]);
                    if (currentId == id) {
                        exists = true;
                        break;
                    }
                }
            }
            if (!exists) {
                break;
            }
            id++;
        }

        //Create a new receipt
        Receipt receipt = new Receipt(beverage.getDescription(), beverage.cost(), id); //Invoke cost on outermost object

        //Write to database file
        String data = id + "," + beverage.cost() + "," + beverage.getDescription();
        appendToFile(path, data + NEW_LINE);

        return receipt;
    }
}
