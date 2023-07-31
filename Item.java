import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class Item {
    private static final int SLOT_COUNT = 8;
    private static final double DEFAULT_PRICE = 0.0;
    private static final int ITEM_CAPACITY = 10;
    private final List<Integer> soldItemQuantities;
    private final List<Integer> initialItemQuantities;
    private final List<String> itemNames;
    private List<Integer> itemQuantities;
    private final List<Double> itemPrices;
    private final List<Integer> itemCalories;
    private final Scanner scanner;

    public Item() {
        this.soldItemQuantities = new ArrayList<>(Collections.nCopies(SLOT_COUNT, 0));
        this.initialItemQuantities = new ArrayList<>(Collections.nCopies(SLOT_COUNT, ITEM_CAPACITY));
        this.itemNames = new ArrayList<>();
        this.itemQuantities = new ArrayList<>(Collections.nCopies(SLOT_COUNT, ITEM_CAPACITY));
        this.itemPrices = new ArrayList<>(Collections.nCopies(SLOT_COUNT, DEFAULT_PRICE));
        this.itemCalories = new ArrayList<>(Collections.nCopies(SLOT_COUNT, 0));
        this.scanner = new Scanner(System.in);

        setItemCalorieAndCapacity();
    }


    public List<Double> getItemPrices() {
        return itemPrices;
    }

    public List<Integer> getSoldItemQuantities() {
        return this.soldItemQuantities;
    }

    public List<Integer> getItemCalories() {
        return itemCalories;
    }

    public List<Integer> getInitialItemQuantities() {
        return initialItemQuantities;
    }

    public int getSlotCount() {
        return SLOT_COUNT;
    }

    public int getItemCapacity() {
        return ITEM_CAPACITY;
    }

    public double getDefaultPrice() {
        return DEFAULT_PRICE;
    }

    public List<String> getitemNames() {
        return itemNames;
    }

    public List<Integer> getItemQuantities() {
        return itemQuantities;
    }

    public static int getSLOT_COUNT() {
        return SLOT_COUNT;
    }

    public static int getITEM_CAPACITY() {
        return ITEM_CAPACITY;
    }

    public static double getDEFAULT_PRICE() {
        return DEFAULT_PRICE;
    }


    //baka magamit

    //public List<Integer> getSoldItemQuantities() { return soldItemQuantities;}
    //public List<Integer> getDenominationQuantities() {
    // return itemQuantities;
    //}

    //public List<Integer> getDenominationQuantities() {
    //  return denominationQuantities;
    //}


    public void initializeItemQuantities() {
        initialItemQuantities.clear();
        soldItemQuantities.clear();
        itemCalories.clear();
        setItemCalorieAndCapacity();
        setItemCalories();
        JFrame parentFrame = new JFrame(); // Create a new JFrame
        setItemPrices(parentFrame);  // Pass the JFrame as an argument

        // Initialize itemQuantities list with the default capacity
        itemQuantities = new ArrayList<>(Collections.nCopies(SLOT_COUNT, ITEM_CAPACITY));

        for (int i = 0; i < SLOT_COUNT; i++) {
            initialItemQuantities.add(ITEM_CAPACITY);
            soldItemQuantities.add(0);
            itemCalories.add(0); // Add a default calorie value of 0 for each item
        }
    }


    /**
     * Sets the item slots in the vending machine.
     */
    public void setItemCalorieAndCapacity() {
        itemNames.add("Bread");
        itemNames.add("Pizza Sauce");
        itemNames.add("Cheese");
        itemNames.add("Meat toppings");
        itemNames.add("Vegetable toppings");
        itemNames.add("Condiments");
        itemNames.add("Box");
        itemNames.add("Softdrink");

        for (int i = 0; i < SLOT_COUNT; i++) {
            itemQuantities.add(ITEM_CAPACITY); // Set initial quantity to 10
            itemCalories.add(0); // Add a default calorie value of 0 for each item
        }

    }

    /**
     * Displays the item calories and allows the user to set the calorie count for each item.
     */
    public void setItemCalories() {
        ItemCaloriesGUI gui = new ItemCaloriesGUI(this);
    }

    public void setItemPrices(JFrame parentFrame) {
        new ItemPricesGUI(this, parentFrame);
    }
}

