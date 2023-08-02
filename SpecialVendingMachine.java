import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing a special vending machine that inherits features from RegularVendingMachine.
 */
public class SpecialVendingMachine extends RegularVendingMachine {

    private Map<String, String> itemPromotions;
    private int soldQuantity;


    /**
     * Constructs a SpecialVendingMachine object and initializes its fields.
     */
    public SpecialVendingMachine() {
        // Call the constructor of the superclass (RegularVendingMachine) to initialize its fields.
        super();

    }

    public boolean processTransaction(List<Integer> slots, List<Integer> quantities, int paymentDenomination, int paymentQuantity) {
        double totalCost = 0;
        List<Item> purchasedItems = new ArrayList<>();

        System.out.println("\n===== DEBUG: Vending Machine Items =====");
        System.out.println("| No. | Item              | Quantity | Price | Calories |");
        System.out.println("|-----|-------------------|----------|-------|----------|");

        for (int i = 0; i < itemNames.size(); i++) {
            String itemName = itemNames.get(i);
            Item item = Item.getItemProperties(itemName);

            int slot = i + 1;
            int quantity = item.getQuantity();
            double price = item.getPrice();
            int calories = item.getCalories();

            System.out.printf("| %3d | %-17s | %8d | %5.2f | %8d |%n", slot, itemName, quantity, price, calories);
        }
        System.out.println("=======================================");


        for (int i = 0; i < slots.size(); i++) {
            int slot = slots.get(i);
            int quantity = quantities.get(i);

            // Get the selected item
            slot -= 1; // Subtract 1 from the slot to convert to 0-based index
            String itemName = Item.getItemNames().get(slot);
            Item item = Item.getItemProperties(itemName);

            // Check the available quantity of the item
            int initialQuantity = item.getInitialQuantities().get(slot);
            int soldQuantity = item.getSoldItemQuantities().get(slot);
            int availableQuantity = initialQuantity - soldQuantity;

            if (availableQuantity <= 0) {
                System.out.println("Invalid quantity for item: " + itemName);
                return false;
            } else if (quantity <= 0 || quantity > availableQuantity) {
                System.out.println("Not enough stock for item: " + itemName + ". Available quantity: " + availableQuantity);
                return false;
            }

            // Calculate the total cost of the selected items
            double pricePerItem = item.getPrice();
            totalCost += pricePerItem * quantity;
            // Add the purchased item to the list
            purchasedItems.add(new Item(itemName, quantity, pricePerItem, item.getCalories()));
        }

        // Check the payment denomination
        if (paymentDenomination < 1 || paymentDenomination > DENOMINATION_COUNT) {
            System.out.println("Invalid payment denomination.");
            return false;
        }

        // Calculate the total payment amount
        double paymentAmount = denominationValues.get(paymentDenomination - 1) * paymentQuantity;

        // Check if the payment is enough
        while (paymentAmount < totalCost) {
            System.out.println("Insufficient payment. Total cost: $" + totalCost + ". Please add more payment.");

            // Ask the user for additional payment
            System.out.print("Enter the denomination (1 - " + DENOMINATION_COUNT + ") and quantity of the payment (or -1 to cancel): ");
            int denomination = scanner.nextInt();
            if (denomination == -1) {
                System.out.println("Transaction canceled.");
                return false;
            }

            int quantity = scanner.nextInt();
            // Calculate the additional payment amount and add it to the total payment
            double additionalPayment = denominationValues.get(denomination - 1) * quantity;
            paymentAmount += additionalPayment;
        }

        // Process the transaction for each item
        for (int i = 0; i < slots.size(); i++) {
            int slot = slots.get(i);
            int quantity = quantities.get(i);

            String itemName = Item.getItemNames().get(slot - 1);
            Item item = Item.getItemProperties(itemName);

            transactionCount++;
            totalSales += item.getPrice() * quantity;

            // Update the item quantities
            int soldQuantity = item.getSoldItemQuantities().get(slot - 1) + quantity;
            int updatedQuantity = item.getQuantity() - quantity;

            item.setQuantity(updatedQuantity);
            item.getSoldItemQuantities().set(slot - 1, soldQuantity);
        }

        System.out.println("\n===== DEBUG: Vending Machine Items =====");
        System.out.println("| No. | Item              | Quantity | Price | Calories |");
        System.out.println("|-----|-------------------|----------|-------|----------|");

        for (int i = 0; i < itemNames.size(); i++) {
            String itemName = itemNames.get(i);
            Item item = Item.getItemProperties(itemName);

            int slot = i + 1;
            int quantity = item.getQuantity();
            double price = item.getPrice();
            int calories = item.getCalories();

            System.out.printf("| %3d | %-17s | %8d | %5.2f | %8d |%n", slot, itemName, quantity, price, calories);
        }
        System.out.println("=======================================");
        // Print receipt and display updated item quantities
        printMultipleReceipts(purchasedItems, totalSales, transactionCount, paymentAmount - totalCost, soldQuantity);

        displayItems();

        return true;
    }



    private void printMultipleReceipts(List<Item> purchasedItems,  double totalSales, int transactionCount, double change, int quantity) {
        try {
            System.out.println("\n==============================================");
            System.out.println("|           RAIO  Vending Machine            |");
            System.out.println("|============================================|");
            System.out.println(quantity + "quantity inside the printmultipleRciepts");

            for (Item purchasedItem : purchasedItems) {

                double itemPrice = purchasedItem.getPrice();
                int itemCalories = purchasedItem.getCalories();

                System.out.println("| Item purchased: " + purchasedItem.getItemName());
                System.out.println("| Quantity: " + quantity);
                System.out.println("| Price per item: $" + itemPrice);
                System.out.println("| Total cost for this item: $" + (itemPrice * quantity));
                System.out.println("| Calories per item: " + itemCalories);
                System.out.println("|--------------------------------------------|");
            }

            System.out.printf("| Total Sales: $%.2f             %n", totalSales);
            System.out.printf("| Total Transactions: %d                %n", transactionCount);

            if (change >= 0) {
                System.out.printf("| Change: $%.2f              %n", change);
            }

            System.out.println("|--------------------------------------------|");
            System.out.println("|============================================|");
            System.out.println("|     Updated Denomination Quantities        |");
            System.out.println("|============================================|");

            for (int i = 0; i < denominationQuantities.size(); i++) {
                int denominationValue = denominationValues.get(i);
                int denominationQuantity = denominationQuantities.get(i);
                System.out.println("| " + denominationValue + ":\t" + denominationQuantity);
            }

            System.out.println("============================================");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds. Please enter a valid slot number.");
        } catch (NullPointerException e) {
            System.out.println("Error: Null pointer. Please ensure the itemNames list is not empty.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
