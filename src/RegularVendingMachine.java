import java.util.*;

/**
 * A class representing a regular vending machine.
 */
public class RegularVendingMachine {
    private static final int SLOT_COUNT = 8;
    private static final int ITEM_CAPACITY = 10;
    private static final int DENOMINATION_COUNT = 9;
    private static final double DEFAULT_PRICE = 0.0;
    private List<Integer> denominationValues;
    private List<Integer> itemQuantities;
    private List<Double> itemPrices;
    private List<Integer> itemCalories;  // New list to hold calorie counts
    private double totalSales;
    private int transactionCount;
    private List<Integer> initialItemQuantities;
    private List<Integer> soldItemQuantities;
    private final Scanner scanner;

    private List<String> denominationNames;
    private List<Item> items;
    private boolean itemsInitialized = false;

    private List<Integer> denominationQuantities = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
    Item item;





    /**
     * Constructs a RegularVendingMachine object and initializes its fields.
     */
    public RegularVendingMachine() {
        items = new ArrayList<>();
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


        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> quantities = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        ArrayList<Double> prices = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));

        // Instantiate Item object
        this.item = new Item(scanner, quantities, quantities, prices, quantities);

        // Call the setItemCalorieAndCapacity method
        this.item.setItemCalorieAndCapacity();

        setDenominationValues();
        initializeDenominationQuantities();
        setDenominationNames();
        setDenominationQuantities();
        initializeItems();
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
     * Initializes the quantities of the denominations used in the vending machine.
     */
    private void initializeDenominationQuantities() {
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            denominationQuantities.add(0);
        }
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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\u001B[36m======================================================");
        System.out.println("\u001B[36m|             Vending Machine Items                  |");
        System.out.println("\u001B[36m======================================================");
        System.out.printf("\u001B[36m| \u001B[33m%2s. %-20s%-8s%10s  %s%n", "No", "Item", "Quantity", "Price", "Calories   \u001B[36m|");

        for (Item item : items) {
            for (int i = 0; i < item.getSlotCount(); i++) { // use getSlotCount() instead of directly accessing SLOT_COUNT
                String itemName = item.getitemNames().get(i);
                int quantity = item.getItemQuantities().get(i);
                double price = item.getItemPrices().get(i);
                int calories = item.getItemCalories().get(i);

                System.out.printf("\u001B[36m| \u001B[33m%2d. %-20s%8d%13s  %5d  \u001B[36m |%n\u001B[0m", i + 1, itemName, quantity, "$" + price, calories);
            }
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

        item.setItemCalorieAndCapacity();
        System.out.println("[DEBUG] itemNames contents: " + item.getitemNames());
        System.out.println("[DEBUG] SLOT NUMBER " + slot);

        int selectedItemIndex = slot;

        System.out.println("[DEBUG] printReceipt() called with slot: " + slot + ", quantity: " + quantity + ", and change: " + change);

        if (slot < 1 || slot > Item.getSLOT_COUNT()) {
            System.out.println("[DEBUG] Invalid slot number: " + slot);
            System.out.println("[DEBUG] Quantity: " + quantity);
            return;
        }

        if (item.getitemNames().isEmpty()) {
            System.out.println("[DEBUG] Error: itemNames list is empty.");
            return;
        }


        System.out.println("[DEBUG] SA WAKAS.");

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";

        System.out.println("[DEBUG] ANSI codes initialized.");

        System.out.println();
        System.out.println(ANSI_RED + "==============================================");
        System.out.println("|           RAIO  Vending Machine            |");
        System.out.println("|============================================|");
        System.out.println("| " + ANSI_YELLOW + " Item purchased: " + item.getitemNames().get(selectedItemIndex) + ANSI_RED);
        System.out.println("|============================================|");
        System.out.println("|  " + ANSI_YELLOW + "Before quantity:         " + (quantity + 1) + ANSI_YELLOW);
        System.out.println("|  " + ANSI_YELLOW + "After quantity:          " + quantity + ANSI_YELLOW);
        System.out.println("|============================================|");
        System.out.printf("| Total Sales: " + ANSI_YELLOW + "$%.2f             %n" + ANSI_RESET, totalSales);
        System.out.printf("| Total Transactions " + ANSI_YELLOW + "%d                %n", transactionCount);

        System.out.println("[DEBUG] Total sales and transaction count printed.");

        if (change >= 0) {
            System.out.printf("|" + ANSI_YELLOW + "Change: $%.2f              %n", change);
        }

        System.out.println("|============================================|");
        System.out.println("|--------------------------------------------|");
        System.out.println("|============================================|");
        System.out.println("|     Updated Denomination Quantities        |");
        System.out.println("|============================================|");

        for (int i = 0; i < denominationQuantities.size(); i++) {
            int denomination = denominationQuantities.get(i);
            System.out.printf("\t\t\u001B[33m %2d.......$%3d: %2d                     %n", i + 1, denominationValues.get(i), denomination);
        }

        System.out.println("[DEBUG] Denomination quantities printed.");

        System.out.println("\u001B[32m============================================");
    }


    /**
     * The printSummary() function prints a summary of item quantities and sales transactions.
     */
    public void printSummary() {
        System.out.println();
        System.out.println("\u001B[93m====================================");
        System.out.println("|           Item Summary           |");
        System.out.println("====================================");

        for(Item item: items) {
            for (int i = 0; i < item.getSlotCount(); i++) {
                String itemName = item.getitemNames().get(i);
                int initialQuantity = item.getInitialItemQuantities().get(i);
                int soldQuantity = item.getSoldItemQuantities().get(i);

                System.out.println("\u001B[97m| Item: \u001B[92m" + itemName);
                System.out.println("\u001B[97m| Before Quantity: \u001B[92m" + initialQuantity);
                System.out.println("\u001B[97m| After Quantity: \u001B[92m" + (initialQuantity - soldQuantity));
                System.out.println("\u001B[97m|----------------------------------");
            }
        }
        System.out.println("\u001B[97m| Number of transactions: \u001B[92m" + transactionCount);
        System.out.println("\u001B[97m| Total sales: \u001B[92m" + totalSales);
        System.out.println("\u001B[93m|----------------------------------\u001B[0m");
        System.out.println();
    }

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
            denominationQuantities = updatedQuantities;
        }
    }




    private void initializeItems() {
        // Generate lists for initial quantities, current quantities, prices, and sold quantities
        List<Integer> initialItemQuantities = new ArrayList<>(Collections.nCopies(Item.getSLOT_COUNT(), Item.getITEM_CAPACITY()));
        List<Integer> itemQuantities = new ArrayList<>(Collections.nCopies(Item.getSLOT_COUNT(), Item.getITEM_CAPACITY()));
        List<Double> itemPrices = new ArrayList<>(Collections.nCopies(Item.getSLOT_COUNT(), Item.getDEFAULT_PRICE()));
        List<Integer> soldItemQuantities = new ArrayList<>(Collections.nCopies(Item.getSLOT_COUNT(), 0));

        // Create a new instance of Item using these lists
        Item item = new Item(scanner, initialItemQuantities, itemQuantities, itemPrices, soldItemQuantities);

        // Initialize item quantities
        item.initializeItemQuantities();

        // Add the item to the items list
        for (int i = 0; i < 8; i++) {
            items.add(item);
        }


        itemsInitialized = true;
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

        // Adjust the index to match the list (0-based index)
        System.out.println("start");
        Item item = items.get( slot);
        System.out.println("[DEBUG] Item: " + item);
        System.out.println("[DEBUG] Slot: " + slot);
        System.out.println("[DEBUG] Items Size: " + Item.getSLOT_COUNT());
        try {

            System.out.println("[DEBUG] processTransaction() called with slot: " + slot + " and denomination: " + paymentDenomination);
            System.out.println("[DEBUG] Items list size: " + Item.getSLOT_COUNT());
            System.out.println("[DEBUG] DenominationValues list size: " + denominationValues.size());


            if (slot < 0 || slot >= Item.getSLOT_COUNT()) {
                System.out.println("Invalid item slot: " + slot);
                return false;
            }

        // Ensure that the item has valid prices
        List<Double> itemPrices = item.getItemPrices();

            System.out.println("[DEBUG] Item Prices: " + itemPrices);


        if (itemPrices == null || itemPrices.isEmpty()) {
            System.out.println("Item prices not set for slot: " + slot);
            return false;
        }

        // Ensure that the slot is valid for the item's price list
        if (slot < 1 || slot > itemPrices.size()) {
            System.out.println("Invalid slot for item prices: " + slot);
            return false;
        }


        double price = itemPrices.get(slot - 1);

            System.out.println("[DEBUG] Price: " + price);


        if (price == Item.getDEFAULT_PRICE()) {
            System.out.println("Item price not set.");
            return false;
        }

            int quantity = item.getItemQuantities().get(slot - 1);


            if (quantity <= 0) {
            System.out.println("Item out of stock.");
            return false;
        }

        if (items.isEmpty()) {
            System.out.println("No items in the machine.");
            return false;
        }

        double paymentAmount = denominationValues.get(paymentDenomination - 1); // Retrieve payment amount based on denomination

        while (paymentAmount < price) {
            System.out.println("Current payment: " + paymentAmount);
            System.out.println("Remaining amount: " + (price - paymentAmount));
            System.out.println("Please enter the additional payment amount:");

            int additionalPaymentDenomination = scanner.nextInt();

            if (additionalPaymentDenomination == 0) {
                System.out.println("Transaction canceled.");
                return false;
            }

            double additionalPayment = denominationValues.get(additionalPaymentDenomination - 1); // Retrieve payment amount based on additional payment denomination
            paymentAmount += additionalPayment;
        }

        double change = paymentAmount - price; // Calculate the change

        if (change < 0) {
            System.out.println("Insufficient payment. Please add more to the payment or enter 0 to cancel.");
            int additionalPayment = scanner.nextInt();

            if (additionalPayment == 0) {
                System.out.println("Transaction canceled.");
                return false;
            }

            paymentAmount += additionalPayment;
            change = paymentAmount - price;

            if (change < 0) {
                System.out.println("Still insufficient payment. Transaction canceled.");
                return false;
            }
        }

        System.out.println(quantity + "quantity");

        // Update the denomination quantities and calculate the change amount
        giveChange(change);

        // Update quantities in item
        item.getItemQuantities().set(slot - 1, quantity - 1);

        transactionCount++;
        totalSales += paymentAmount - change;
        int initialQuantity = item.getInitialItemQuantities().get(slot);
        int soldQuantity = this.soldItemQuantities.get(slot);  // Changed this line
        item.getInitialItemQuantities().set(slot, initialQuantity - 1);
        this.soldItemQuantities.set(slot, soldQuantity + 1);


        // minus -1
        printReceipt(slot - 1, quantity - 1, change); // Pass the updated quantity of the item
        displayItems(); // Call the displayItems() function to show the updated item quantities

        return true;
    } catch (IndexOutOfBoundsException e) {
            System.out.println("Error at slot: " + slot + ", denomination: " + paymentDenomination);
            System.out.println("Error: " + e.getMessage());
        return false;
    }
}



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
    public void updateItemPrice(int slot, double newPrice) {
        if (slot < 1 || slot > SLOT_COUNT) {
            System.out.println("Invalid slot number. Please try again.");
            return;
        }

        if(newPrice < 0){
            System.out.println("Invalid input");
            return;
        }

        int index = slot - 1;
        itemPrices.set(index, newPrice);

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
