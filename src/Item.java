import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Item {
    private static final int SLOT_COUNT = 8;
    public static final List<String> itemNames;

    static {
        // Initialize the itemNames list in the static block
        itemNames = new ArrayList<>(Arrays.asList(
                "Bread", "Pizza Sauce", "Cheese", "Meat toppings",
                "Vegetable toppings", "Condiments", "Box", "Softdrink"
        ));
    }

    // Inner class to hold the properties for each item
    public static class ItemProperties {
        private int quantity;
        private double price;
        private int calories;

        public ItemProperties(int quantity, double price, int calories) {
            this.quantity = quantity;
            this.price = price;
            this.calories = calories;
        }

        // Getters and Setters for quantity, price, and calories
        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }
    }

    // Map to hold the properties for each item
    private static final Map<String, ItemProperties> itemPropertiesMap = new HashMap<>();

    private List<Integer> soldItemQuantities;
    private List<Integer> initialQuantities;
    private int quantity;
    private double price;
    private int calories;
    private final Scanner scanner;

    public Item(int quantity, double price, int calories) {
        this.quantity = quantity;
        this.price = price;
        this.calories = calories;
        soldItemQuantities = new ArrayList<>(SLOT_COUNT);
        initialQuantities = new ArrayList<>(SLOT_COUNT);
        scanner = new Scanner(System.in);



        for (int i = 0; i < SLOT_COUNT; i++) {
            soldItemQuantities.add(0);
            initialQuantities.add(10); // Assuming the default capacity is 10 for all slots
        }

        // Initialize the item properties for this item
        itemPropertiesMap.put(itemNames.get(quantity - 1), new ItemProperties(quantity, price, calories));
    }

    // Getter and Setter for itemNames
    public static List<String> getItemNames() {
        return itemNames;
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to get initialQuantities
    public List<Integer> getInitialQuantities() {
        return new ArrayList<>(initialQuantities);
    }

    // Method to set a quantity at a specific slot in initialQuantities
    public void setInitialQuantityAtSlot(int slot, int quantity) {
        initialQuantities.set(slot, quantity);
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for calories
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    // Getter for item properties
    public static ItemProperties getItemProperties(String itemName) {
        return itemPropertiesMap.get(itemName);
    }
}
