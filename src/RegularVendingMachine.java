import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

/**
 * A class representing a regular vending machine.
 */
public class RegularVendingMachine {
    private static final int SLOT_COUNT = 8;
    private static final int ITEM_CAPACITY = 10;
    private static final int DENOMINATION_COUNT = 9;
    private static final double DEFAULT_PRICE = 0.0;
<<<<<<< Updated upstream
=======
    private final ArrayList<Integer> itemCalories;
    private List<String> itemNames;
>>>>>>> Stashed changes
    private List<Integer> denominationValues;
    private List<String> itemSlots;
    private List<Integer> itemQuantities;
<<<<<<< Updated upstream
    private List<Double> itemPrices;
    private List<Integer> denominationQuantities;
    private List<Integer> itemCalories;  // New list to hold calorie counts
=======
    private Map<String, ItemProperties> itemPropertiesMap; // Map to associate item names with their properties
>>>>>>> Stashed changes
    private double totalSales;
    private int transactionCount;
    private List<Integer> initialItemQuantities;
    private List<Integer> soldItemQuantities;
    private final Scanner scanner;

    private List<String> denominationNames;

    /**
     * Constructs a RegularVendingMachine object and initializes its fields.
     */
    public RegularVendingMachine() {
        itemSlots = new ArrayList<>();
        itemQuantities = new ArrayList<>();
        itemPrices = new ArrayList<>();
        itemCalories = new ArrayList<>();  // Initialize the calorie list
        denominationQuantities = new ArrayList<>();
        totalSales = 0.0;
        transactionCount = 0;
        initialItemQuantities = new ArrayList<>();
        soldItemQuantities = new ArrayList<>();
        for (int i = 0; i < SLOT_COUNT; i++) {
            initialItemQuantities.add(ITEM_CAPACITY);
            soldItemQuantities.add(0);
        }
        scanner = new Scanner(System.in);
<<<<<<< Updated upstream

=======
        items = new ArrayList<>();
        itemQuantities = new ArrayList<>(Collections.nCopies(SLOT_COUNT, ITEM_CAPACITY));
        initialItemQuantities = new ArrayList<>(Collections.nCopies(SLOT_COUNT, ITEM_CAPACITY));
        soldItemQuantities = new ArrayList<>(Collections.nCopies(SLOT_COUNT, 0));
        denominationQuantities = new ArrayList<>(Collections.nCopies(DENOMINATION_COUNT, 0));
        denominationValues = Arrays.asList(1000, 500, 200, 100, 50, 25, 10, 5, 1);
        itemCalories = new ArrayList<>(Collections.nCopies(SLOT_COUNT, 0));

        // Create the item properties map and initialize with default values
        itemPropertiesMap = new HashMap<>();
        itemPropertiesMap.put("Bread", new ItemProperties(ITEM_CAPACITY, DEFAULT_PRICE, 0));
        itemPropertiesMap.put("Pizza Sauce", new ItemProperties(ITEM_CAPACITY, DEFAULT_PRICE, 0));
        itemPropertiesMap.put("Cheese", new ItemProperties(ITEM_CAPACITY, DEFAULT_PRICE, 0));
        itemPropertiesMap.put("Meat toppings", new ItemProperties(ITEM_CAPACITY, DEFAULT_PRICE, 0));
        itemPropertiesMap.put("Vegetable toppings", new ItemProperties(ITEM_CAPACITY, DEFAULT_PRICE, 0));
        itemPropertiesMap.put("Condiments", new ItemProperties(ITEM_CAPACITY, DEFAULT_PRICE, 0));
        itemPropertiesMap.put("Box", new ItemProperties(ITEM_CAPACITY, DEFAULT_PRICE, 0));
        itemPropertiesMap.put("Softdrink", new ItemProperties(ITEM_CAPACITY, DEFAULT_PRICE, 0));

        initializeItems();

        System.out.println("itemQuantities size: " + itemQuantities.size());
        System.out.println("itemPrices size: " + itemPropertiesMap.size());
        System.out.println("itemNames size: " + itemNames.size());
        System.out.println("itemCalories size: " + itemCalories.size());


        List<String> itemNames = Item.getItemNames();
>>>>>>> Stashed changes
        setDenominationValues();
        setItemCalorieAndCapacity();
        setItemSlot();
        initializeDenominationQuantities();
        setDenominationNames();
        setItemCalories();  // Call the method to set calorie counts
        setItemPrices();   // Call the method to set item prices
        setDenominationQuantities();
    }

<<<<<<< Updated upstream
    /**
     * Sets the item slots in the vending machine.
     */
    private void setItemCalorieAndCapacity() {
        itemSlots.add("Bread");
        itemSlots.add("Pizza Sauce");
        itemSlots.add("Cheese");
        itemSlots.add("Meat toppings");
        itemSlots.add("Vegetable toppings");
        itemSlots.add("Condiments");
        itemSlots.add("Box");
        itemSlots.add("Softdrink");
=======

    // Rest of the RegularVendingMachine class

    private static class ItemProperties {
        private int quantity;
        private double price;
        private int calories;

        public ItemProperties(int quantity, double price, int calories) {
            this.quantity = quantity;
            this.price = price;
            this.calories = calories;
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



    private void initializeItems() {
        itemNames = Arrays.asList("Bread", "Pizza Sauce", "Cheese", "Meat toppings", "Vegetable toppings", "Condiments", "Box", "Softdrink");
        List<Integer> itemCalories = new ArrayList<>(Collections.nCopies(SLOT_COUNT, 0));

        // Set the item prices
        System.out.println("Set Item Prices:");
        for (String itemName : itemNames) {
            System.out.print("Enter the price for " + itemName + ": ");
            double price = scanner.nextDouble();
            if (price < 0) {
                System.out.println("Price cannot be negative. Please enter a valid number.");
                continue;
            }

            ItemProperties itemProperties = itemPropertiesMap.get(itemName);
            itemProperties.setPrice(price);
        }

        // Set the item calories
        System.out.println("Set Item Calories:");
        for (String itemName : itemNames) {
            System.out.print("Enter the calories for " + itemName + ": ");
            int calories = scanner.nextInt();
            if (calories < 0) {
                System.out.println("Calories cannot be negative. Please enter a valid number.");
                continue;
            }

            ItemProperties itemProperties = itemPropertiesMap.get(itemName);
            itemProperties.setCalories(calories);
        }
    }

>>>>>>> Stashed changes

        for (int i = 0; i < SLOT_COUNT; i++) {
            itemQuantities.add(ITEM_CAPACITY); // Set initial quantity to 10
            itemCalories.add(0); // Add a default calorie value of 0 for each item
            
        }
    }

    /**
     * Sets the names of the denominations used in the vending machine.
     */
    private void setDenominationNames() {
        denominationNames = new ArrayList<>();
        denominationNames.add("1000");
        denominationNames.add("500");
        denominationNames.add("200");
        denominationNames.add("100");
        denominationNames.add("50");
        denominationNames.add("20");
        denominationNames.add("10");
        denominationNames.add("5");
        denominationNames.add("1");
    }

    /**
     * Sets the values of the denominations used in the vending machine.
     */
    private void setDenominationValues() {
        denominationValues = new ArrayList<>();
        denominationValues.add(1000);
        denominationValues.add(500);
        denominationValues.add(200);
        denominationValues.add(100);
        denominationValues.add(50);
        denominationValues.add(20);
        denominationValues.add(10);
        denominationValues.add(5);
        denominationValues.add(1);
    }

    /**
     * Sets the slots of the items in the vending machine.
     */
    private void setItemSlot() {
        for (int i = 0; i < SLOT_COUNT; i++) {
            itemPrices.add(DEFAULT_PRICE);
            System.out.println(itemPrices + "System.out.println(itemPrices);");
        }

    }

    /**
     * Initializes the quantities of the denominations used in the vending machine.
     */
    private void initializeDenominationQuantities() {
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            denominationQuantities.add(0);
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
            String itemSlot = itemSlots.get(i);
            System.out.print("\t\t[" + (i + 1) + "]......" + itemSlot + ": ");
            int calories = scanner.nextInt();
            itemCalories.set(i, calories);
        }
        System.out.println("\t------------------------------------");
        System.out.println("\t####################################");
        System.out.println();
        System.out.println("<.............................................>");
    }

    /**
     * Displays the item prices and allows the user to set the price for each item.
     */
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
            String itemName = itemSlots.get(i);
            System.out.print("\t\t    " + (i + 1) + ". (" + itemName + "): ");
            double price = scanner.nextDouble();
            itemPrices.set(i, price); // setting of item prices
        }
        System.out.println("\t----------------------------------");
        System.out.println("\t####################################");
        System.out.println();

    }

    /**
     * Displays the denomination quantities and allows the user to set the quantities for each denomination.
     */
    public void setDenominationQuantities() {
        System.out.println();
        System.out.println("\t====================================");
        System.out.println("\t------------------------------------");
        System.out.println("\t \u001B[33m|======================================|\u001B[0m");
        System.out.println("\t \u001B[33m|      Set Denomination Quantities     |\u001B[0m");
        System.out.println("\t \u001B[33m|======================================|\u001B[0m");

        System.out.println();
        System.out.println("Enter the quantities for denominations:");
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            String denominationName = denominationNames.get(i);
            System.out.print("\t\t  [" + (i + 1) + "]......" + denominationName + ": ");
            int quantity = scanner.nextInt();
            denominationQuantities.set(i, quantity);
        }
        System.out.println("\t----------------------------------");
        System.out.println("\t####################################");
        System.out.println();
        System.out.println("<.............................................>");
    }

    /**
     * Displays the items in the vending machine.
     */

    public void displayItems() {
<<<<<<< Updated upstream
=======
        // Print debug information
        System.out.println("Number of items: " + items.size());

>>>>>>> Stashed changes
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\u001B[36m======================================================");
        System.out.println("\u001B[36m|             Vending Machine Items                  |");
        System.out.println("\u001B[36m======================================================");

        System.out.printf("\u001B[36m| \u001B[33m%2s. %-20s%-8s%10s  %s%n", "No", "Item", "Quantity", "Price", "Calories   \u001B[36m|");
        for (int i = 0; i < SLOT_COUNT; i++) {
            String item = itemSlots.get(i);
            int quantity = itemQuantities.get(i);
            double price = itemPrices.get(i);
            int calories = itemCalories.get(i);

<<<<<<< Updated upstream
            System.out.printf("\u001B[36m| \u001B[33m%2d. %-20s%8d%13s  %5d  \u001B[36m |%n\u001B[0m", i + 1, item, quantity, "$" + price, calories);
=======
        for (Item item : items) {
            for (int i = 0; i < SLOT_COUNT; i++) { // use getSlotCount() instead of directly accessing SLOT_COUNT
                String itemName = Item.getItemNames().get(i); // Get the item name from itemNames list
                Item.ItemProperties itemProperties = Item.getItemProperties(itemName); // Get the ItemProperties for this item
                int quantity = item.getQuantity();
                double price = item.getPrice();
                int calories = itemProperties.getCalories(); // Fetch the calories from the ItemProperties

                System.out.printf("\u001B[36m| \u001B[33m%2d. %-20s%8d%13s  %5d  \u001B[36m |%n\u001B[0m", i + 1, itemName, quantity, "$" + price, calories);
            }
>>>>>>> Stashed changes
        }
        System.out.println("\u001B[36m|======================================================|");

    }



    /**
     * Displays the updated denomination quantities in the vending machine.
     */
    public void displayUpdatedDenominationQuantities() {
        System.out.println();
        System.out.println("\u001B[36m|============================================|");
        System.out.println("\u001B[36m|========= Available Bills For Change =======|");
        System.out.println("\u001B[36m|============================================|");
        for (int i = 0; i < denominationQuantities.size(); i++) {
            int denomination = denominationQuantities.get(i);
            System.out.printf("\u001B[33m| %2d.......$%3d: %2d                       \t|%n\u001B[0m", i + 1, denominationValues.get(i), denomination);
        }
        System.out.println("\u001B[36m|============================================|");

    }


    /**
     * Prints the receipt for a transaction.
     *
     * @param slot     the slot number of the item purchased
     * @param quantity the quantity of the item purchased
     * @param change   the change amount given to the customer
     */
    private void printReceipt(int slot, int quantity, double change) {

<<<<<<< Updated upstream
        // ANSI escape code for color formatting
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";
        System.out.println();
        System.out.println(ANSI_RED + "==============================================" + ANSI_RESET);
        System.out.println(ANSI_RED + "|           RAIO  Vending Machine            |" + ANSI_RESET);
        System.out.println(ANSI_RED + "|============================================|" + ANSI_RESET);
        System.out.println(ANSI_RED + "| " + ANSI_YELLOW + " Item purchased: " + itemSlots.get(slot) + ANSI_RED );
        System.out.println(ANSI_RED + "|============================================|" + ANSI_RESET);
        System.out.println(ANSI_RED + "|  " + ANSI_YELLOW + "Before quantity:         " + (quantity + 1) + ANSI_YELLOW );
        System.out.println(ANSI_RED + "|  " + ANSI_YELLOW + "After quantity:          " + quantity +  ANSI_YELLOW );
        System.out.println(ANSI_RED + "|============================================|" + ANSI_RESET);
        System.out.printf(ANSI_RED + "| Total Sales: " + ANSI_YELLOW + "$%.2f             %n" + ANSI_RESET, totalSales);
        System.out.printf(ANSI_RED + "| Total Transactions " + ANSI_YELLOW + "%d                %n", transactionCount);
        if (change >= 0) {
            System.out.printf(ANSI_RED + "|" + ANSI_YELLOW + "Change: $%.2f              %n", change);
=======

        String itemName = itemNames.get(slot);
        ItemProperties itemProperties = itemPropertiesMap.get(itemName);

        System.out.println("[DEBUG] itemNames contents: " + Item.getItemNames());
        System.out.println("[DEBUG] SLOT NUMBER " + slot);

        System.out.println("[DEBUG] printReceipt() called with slot: " + slot + ", quantity: " + quantity + ", and change: " + change);

        if (slot < 1 || slot > SLOT_COUNT) {
            System.out.println("[DEBUG] Invalid slot number: " + slot);
            System.out.println("[DEBUG] Quantity: " + quantity);
            return;
        }

        if (Item.getItemNames().isEmpty()) {
            System.out.println("[DEBUG] Error: itemNames list is empty.");
            return;
        }


        System.out.println("[DEBUG] SA WAKAS.");

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";

        System.out.println("[DEBUG] ANSI codes initialized.");

        System.out.println("\n==============================================");
        System.out.println("|           RAIO  Vending Machine            |");
        System.out.println("|============================================|");
        System.out.println("| Item purchased: " + itemName);
        System.out.println("|============================================|");
        System.out.println("| Before quantity:         " + (quantity + 1));
        System.out.println("| After quantity:          " + quantity);
        System.out.println("|============================================|");
        System.out.printf("| Total Sales: $%.2f             %n", totalSales);
        System.out.printf("| Total Transactions %d                %n", transactionCount);

        if (change >= 0) {
            System.out.printf("| Change: $%.2f              %n", change);
>>>>>>> Stashed changes
        }
        System.out.println(ANSI_RED + "|============================================|" + ANSI_RESET);
        System.out.println("|--------------------------------------------|");
        System.out.println("|============================================|");
        System.out.println("|     Updated Denomination Quantities        |");
        System.out.println("|============================================|");

        for (int i = 0; i < denominationQuantities.size(); i++) {
<<<<<<< Updated upstream
            int denomination = denominationQuantities.get(i);
            System.out.printf("\t\t\u001B[33m %2d.......$%3d: %2d                     %n", i + 1, denominationValues.get(i), denomination);
        }
        System.out.println("\u001B[32m============================================");
=======
            int denominationValue = denominationValues.get(i);
            int denominationQuantity = denominationQuantities.get(i);
            System.out.println("| " + denominationValue + ":\t" + denominationQuantity);
        }

        System.out.println("============================================");
>>>>>>> Stashed changes
    }

    /**
     * The printSummary() function prints a summary of item quantities and sales transactions.
     */
    public void printSummary() {
        System.out.println();
        System.out.println("\u001B[93m====================================");
        System.out.println("|           Item Summary           |");
        System.out.println("====================================");
        for (int i = 0; i < SLOT_COUNT; i++) {
            String item = itemSlots.get(i);
            int initialQuantity = initialItemQuantities.get(i);
            int soldQuantity = soldItemQuantities.get(i);

<<<<<<< Updated upstream
            System.out.println("\u001B[97m| Item: \u001B[92m" + item);
            System.out.println("\u001B[97m| Before Quantity: \u001B[92m" + initialQuantity);
            System.out.println("\u001B[97m| After Quantity: \u001B[92m" + (initialQuantity - soldQuantity));
            System.out.println("\u001B[97m|----------------------------------");
=======
        for (Item item : items) {
            for (int i = 0; i < SLOT_COUNT; i++) {
                Object itemName = Item.getItemNames().get(i);
                int initialQuantity = item.getInitialQuantities().get(i);
                int soldQuantity = soldItemQuantities.get(i);

                System.out.println("\u001B[97m| Item: \u001B[92m" + itemName);
                System.out.println("\u001B[97m| Before Quantity: \u001B[92m" + initialQuantity);
                System.out.println("\u001B[97m| After Quantity: \u001B[92m" + (initialQuantity - soldQuantity));
                System.out.println("\u001B[97m|----------------------------------");
            }
>>>>>>> Stashed changes
        }
        System.out.println("\u001B[97m| Number of transactions: \u001B[92m" + transactionCount);
        System.out.println("\u001B[97m| Total sales: \u001B[92m" + totalSales);
        System.out.println("\u001B[93m|----------------------------------\u001B[0m");
        System.out.println();
    }
<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes
    /**
     * Returns the number of slots in the vending machine.
     *
     * @return the number of slots
     */
    public int getSlotCount() {
        return SLOT_COUNT;
    }


    /**
     * Gives change to the customer for the transaction.
     *
     * @param change the change amount to be given
     */
    private void giveChange(double change) {
        if (change == 0) {
            return;
        }

        int remainingChange = (int) change;

        // Create a copy of the denomination quantities to track the changes
        List<Integer> updatedQuantities = new ArrayList<>(denominationQuantities);

        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
        int amount = (int) change;

        for (int i = 0; i < denominations.length; i++) {
            int denominationValue = denominations[i];

            if (amount >= denominationValue) {
                int denominationQuantity = updatedQuantities.get(i);
                int numBillsToDispense = Math.min(amount / denominationValue, denominationQuantity);

                remainingChange -= numBillsToDispense * denominationValue;
                amount -= numBillsToDispense * denominationValue;
                updatedQuantities.set(i, denominationQuantity - numBillsToDispense);
                System.out.printf("$%d: %d%n", denominationValue, numBillsToDispense);
            }
        }

        if (remainingChange == 0) {
            // Update the original denomination quantities with the updated quantities
            denominationQuantities = updatedQuantities;


        } else {
            System.out.println("Cannot give exact change. Transaction canceled.");

            // Roll back the changes made to the denomination quantities
            denominationQuantities = updatedQuantities;
        }
    }


    /**
     * The function `processTransaction` processes a transaction by checking if the item is available
     * and the payment is sufficient, updating the item quantities and sales, giving change, printing a
     * receipt, and displaying the updated item quantities.
     *
     * @param slot The slot parameter represents the index of the item in the inventory. It is used to
     * retrieve the price and quantity of the item from the itemPrices and itemQuantities lists
     * respectively.
     * @param paymentDenomination The paymentDenomination parameter represents the denomination of the
     * payment made by the customer. It is an integer value that corresponds to the index of the
     * denomination in the denominationValues list.
     * @return The method is returning a boolean value.
     */
    public boolean processTransaction(int slot, int paymentDenomination) throws IllegalArgumentException {
<<<<<<< Updated upstream

        double price = itemPrices.get(slot);
        if (price == DEFAULT_PRICE) {
            System.out.println("Item price not set.");
            return false;
        }

        int quantity = itemQuantities.get(slot);
=======
        // Adjust the index to match the list (0-based index)
        Item item = items.get(slot - 1);

        // Get item properties from the itemPropertiesMap
        String itemName = itemNames.get(slot - 1);
        ItemProperties itemProperties = itemPropertiesMap.get(itemName);

        // Check if the item is available
        int quantity = item.getQuantity();
>>>>>>> Stashed changes
        if (quantity <= 0) {
            System.out.println("Item out of stock.");
            return false;
        }

<<<<<<< Updated upstream
        double paymentAmount = denominationValues.get(paymentDenomination - 1); // Retrieve payment amount based on denomination

        while (paymentAmount < price) {
            System.out.println("Current payment: " + paymentAmount);
            System.out.println("Remaining amount: " + (price - paymentAmount));
            System.out.println("Please enter the additional payment amount:");
=======
        // Check if the payment denomination is valid
        if (paymentDenomination < 1 || paymentDenomination > DENOMINATION_COUNT) {
            System.out.println("Invalid payment denomination.");
            return false;
        }

        // Calculate payment amount based on the payment denomination
        double paymentAmount = denominationValues.get(paymentDenomination - 1);
>>>>>>> Stashed changes

        // Check if payment amount is sufficient
        double price = itemProperties.getPrice();
        if (paymentAmount < price) {
            System.out.println("Insufficient payment. Please add more to the payment or enter 0 to cancel.");
            int additionalPaymentDenomination = scanner.nextInt();

            if (additionalPaymentDenomination == 0) {
                System.out.println("Transaction canceled.");
                return false;
            }

            double additionalPaymentAmount = denominationValues.get(additionalPaymentDenomination - 1);
            paymentAmount += additionalPaymentAmount;

            if (paymentAmount < price) {
                System.out.println("Still insufficient payment. Transaction canceled.");
                return false;
            }
        }

<<<<<<< Updated upstream
        // Update the denomination quantities and calculate the change amount
        giveChange(change);

        itemQuantities.set(slot, quantity - 1);
        transactionCount++;
        totalSales += paymentAmount - change;
        int initialQuantity = initialItemQuantities.get(slot);
        int soldQuantity = soldItemQuantities.get(slot);
        initialItemQuantities.set(slot, initialQuantity - 1);
        soldItemQuantities.set(slot, soldQuantity + 1);

        printReceipt(slot, quantity - 1, change); // Pass the updated quantity of the item
        displayItems(); // Call the displayItems() function to show the updated item quantities

        return true;
    }
=======
        // Calculate change and give change
        double change = paymentAmount - price;
        giveChange(change);

        // Update item quantities and sales
        item.setQuantity(item.getQuantity() - 1);
        transactionCount++;
        totalSales += price;

        // Print receipt and display updated item quantities
        printReceipt(slot - 1, item.getQuantity(), change);
        displayItems();

        return true;
    }

>>>>>>> Stashed changes


    /**
     * The refillItem function refills a specific slot in a vending machine with a specified quantity of
     * items, checking for valid inputs and updating the item quantities accordingly.
     *
     * @param slotNumber The slot number represents the specific slot in a vending machine where an item
     * is stored. It is an integer value that ranges from 1 to the total number of slots in the vending
     * machine.
     * @param quantity The quantity parameter represents the number of items to refill in a specific
     * slot.
     */
    public void refillItem(int slotNumber, int quantity) {
        // Check if the slot number is valid
        if (slotNumber < 1 || slotNumber > SLOT_COUNT) {
            System.out.println("Invalid slot number. Please try again.");
            return;
        }

        // Retrieve the item quantity based on the slot number
        int itemQuantity = itemQuantities.get(slotNumber - 1);

        // Calculate the remaining capacity of the specific slot
        int remainingCapacity = 10 - itemQuantity;

        // Check if the quantity to refill exceeds the remaining capacity of the specific slot
        if (quantity > remainingCapacity) {
            System.out.println("Cannot refill. The slot does not have enough capacity.");
            return;
        }

        if (quantity < 0){
            System.out.println("Invalid input");
            return;
        }

        // Refill the slot with the specified quantity
        itemQuantities.set(slotNumber - 1, itemQuantity + quantity);
        System.out.println("\u001B[33mItem refilled successfully.\u001B[0m");
        resetItemQuantities(); // Reset initial item quantities and sold item quantities
        transactionCount = 0;
        resetTotalSales();
    }

    /**
     * The restockChange function restocks the quantity of a specific denomination of change.
     *
     * @param denominationNumber The denominationNumber parameter represents the number of the
     * denomination that needs to be restocked.
     * @param quantity The quantity parameter represents the number of units of a specific denomination
     * that you want to restock.
     */
    public void restockChange(int denominationNumber, int quantity) {
        // Check if the denomination number is valid
        if (denominationNumber < 1 || denominationNumber > DENOMINATION_COUNT) {
            System.out.println("Invalid denomination number. Please try again.");
            return;
        }

        // Retrieve the denomination quantity based on the denomination number
        int denominationQuantity = denominationQuantities.get(denominationNumber - 1);

        if(quantity < 0){
            System.out.println("Invalid input");
            return;
        }

        // Calculate the new denomination quantity after restocking
        int newQuantity = denominationQuantity + quantity;
        // Update the denomination quantity with the new quantity
        denominationQuantities.set(denominationNumber - 1, newQuantity);

        System.out.println("\u001B[33mChange restocked successfully.\u001B[0m");
    }

    /**
     * The function updates the price of an item in a vending machine given the slot number and the new
     * price.
     *
     * @param slot The slot parameter represents the slot number of the item whose price needs to be
     * updated.
     * @param newPrice The new price that you want to update for the item in the specified slot.
     */
    /**
     * The function updates the price of an item in a vending machine given the slot number and the new
     * price.
     *
     * @param slot     The slot parameter represents the slot number of the item whose price needs to be
     *                updated.
     * @param newPrice The new price that you want to update for the item in the specified slot.
     */
    public void updateItemPrice(int slot, double newPrice) {
        if (slot < 1 || slot > SLOT_COUNT) {
            System.out.println("Invalid slot number. Please try again.");
            return;
        }

        if (newPrice < 0) {
            System.out.println("Invalid input");
            return;
        }

        int index = slot - 1;
        itemPropertiesMap.get(itemNames.get(index)).setPrice(newPrice);

        System.out.println("\u001B[33mItem price updated successfully!\u001B[0m");
    }


    /**
     * The function "resetItemQuantities" creates new ArrayLists to store the initial and sold
     * quantities of items.
     */
    public void resetItemQuantities() {
        initialItemQuantities = new ArrayList<>(itemQuantities);
        soldItemQuantities = new ArrayList<>(Collections.nCopies(SLOT_COUNT, 0));
    }

    /**
     * The function returns the total sales as a double value.
     *
     * @return The method is returning the value of the variable totalSales, which is of type double.
     */
    public double getTotalSales() {
        return totalSales;
    }

    /** The above code is defining a method called "resetTotalSales" in a Java class. This method sets
     * the value of a variable called "totalSales" to 0.0.
     */
    public void resetTotalSales() {
        totalSales = 0.0;
    }
}
