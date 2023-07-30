import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

    public Item(Scanner scanner, List<Integer> initialItemQuantities, List<Integer> itemQuantities,
                List<Double> itemPrices, List<Integer> soldItemQuantities) {
        if(scanner == null || initialItemQuantities == null || itemQuantities == null || itemPrices == null || soldItemQuantities == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        if(initialItemQuantities.size() < SLOT_COUNT || itemQuantities.size() < SLOT_COUNT || itemPrices.size() < SLOT_COUNT || soldItemQuantities.size() < SLOT_COUNT) {
            throw new IllegalArgumentException("Lists must contain at least " + SLOT_COUNT + " elements");
        }

        this.initialItemQuantities = new ArrayList<>(initialItemQuantities);
        this.itemQuantities = itemQuantities; //this.itemQuantities = new ArrayList<>(itemQuantities);
        //this.itemPrices = new ArrayList<>(itemPrices);
        this.soldItemQuantities = new ArrayList<>(soldItemQuantities);
        this.scanner = scanner;
        itemNames = new ArrayList<>();
        itemCalories = new ArrayList<>();

        // Initialize itemPrices list with default prices
        this.itemPrices = new ArrayList<>(Collections.nCopies(SLOT_COUNT, DEFAULT_PRICE));
    }


    public List<Double> getItemPrices () {
        return itemPrices;
    }

    public List<Integer> getSoldItemQuantities() {
        return this.soldItemQuantities;
    }

    public List<Integer> getItemCalories () {
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
        setItemPrices();

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
        System.out.println();
        System.out.println("\t####################################");
        System.out.println("\t------------------------------------");
        System.out.println("\t \u001B[33m|===============================|\u001B[0m");
        System.out.println("\t \u001B[33m|       Set Item Calories       |\u001B[0m");
        System.out.println("\t \u001B[33m|===============================|\u001B[0m");
        System.out.println();
        System.out.println("Enter the calories for the available items:");
        for (int i = 0; i < SLOT_COUNT; i++) {
            String itemName = itemNames.get(i);
            System.out.print("\t\t[" + (i + 1) + "]......" + itemName + ": ");
            try {
                int calories = scanner.nextInt();
                if(calories < 0) {
                    System.out.println("Calories cannot be negative. Please enter a valid number.");
                    i--;
                    continue;
                }
                itemCalories.set(i, calories);
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard invalid token
                i--; // Retry this slot
            }
        }
        System.out.println("\t------------------------------------");
        System.out.println("\t####################################");
        System.out.println();
        System.out.println("<.............................................>");
    }

    public void setItemPrices() {
        System.out.println();
        System.out.println("\t####################################");
        System.out.println("\t------------------------------------");
        System.out.println("\t \u001B[33m|===============================|\u001B[0m");
        System.out.println("\t \u001B[33m|       Set Item Prices         |\u001B[0m");
        System.out.println("\t \u001B[33m|===============================|\u001B[0m");
        System.out.println();
        System.out.println("Enter the prices for available items:");
        for (int i = 0; i < SLOT_COUNT; i++) {
            String itemName = itemNames.get(i);
            System.out.print("\t\t    " + (i + 1) + ". (" + itemName + "): ");
            try {
                double price = scanner.nextDouble();
                if(price < 0) {
                    System.out.println("Price cannot be negative. Please enter a valid number.");
                    i--;
                    continue;
                }
                itemPrices.set(i, price); // setting of item prices
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard invalid token
                i--; // Retry this slot
            }
        }
        System.out.println("\t----------------------------------");
        System.out.println("\t####################################");
        System.out.println();
    }



}
