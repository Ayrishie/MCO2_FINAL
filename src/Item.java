import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {
    private static final int SLOT_COUNT = 8;
    private static final int ITEM_CAPACITY = 10;
    public static final List<String> itemNames;

    static {
        // Initialize the itemNames list in the static block
        itemNames = new ArrayList<>(Arrays.asList(
                "Bread", "Pizza Sauce", "Cheese", "Meat toppings",
                "Vegetable toppings", "Condiments", "Box", "Softdrink"
        ));
    }

    // Map to hold the properties for each item
    private static final Map<String, Item> itemPropertiesMap = new HashMap<>();

    private int quantity;
    private double price;
    private int calories;

    private List<Integer> soldItemQuantities;
    private List<Integer> initialQuantities;

    public Item() {
        this.quantity = quantity;
        this.price = price;
        this.calories = calories;
        soldItemQuantities = new ArrayList<>(SLOT_COUNT);
        initialQuantities = new ArrayList<>(SLOT_COUNT);

        for (int i = 0; i < SLOT_COUNT; i++) {
            soldItemQuantities.add(0);
            initialQuantities.add(10); // Assuming the default capacity is 10 for all slots
        }

        itemPropertiesMap.put(itemNames.get(quantity), this);
    }

    public static List<String> getItemNames() {
        return itemNames;
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

    // Method to get initialQuantities
    public List<Integer> getInitialQuantities() {
        return new ArrayList<>(initialQuantities);
    }

    // Getter for item properties
    public static Item getItemProperties(String itemName) {
        return itemPropertiesMap.get(itemName);
    }
}
