import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing a special vending machine that inherits features from RegularVendingMachine.
 */
public class SpecialVendingMachine extends RegularVendingMachine {

    private Map<String, String> itemPromotions;

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
            } else if (quantity <= 0 || quantity > availableQuantity)  {
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
        if (paymentAmount < totalCost) {
            System.out.println("Insufficient payment. Transaction canceled.");
            return false;
        }

        // Process the transaction for each item
        for (int i = 0; i < slots.size(); i++) {
            int slot = slots.get(i);
            int quantity = quantities.get(i);

            String itemName = Item.getItemNames().get(slot - 1);
            Item item = Item.getItemProperties(itemName);

            transactionCount++;
            totalSales += totalCost;

            // Update the item quantities
            int soldQuantity = item.getSoldItemQuantities().get(slot - 1) - quantity;
            int updatedQuantity = item.getQuantity() - quantity;

            System.out.println(updatedQuantity + "updatedQuantity ");
            System.out.println(soldQuantity + "soldQuantity");

            item.setQuantity(updatedQuantity);
            item.getSoldItemQuantities().set(slot - 1, soldQuantity + quantity);

            // Print receipt and display updated item quantities
            printMultipleReceipts(purchasedItems, quantity, paymentAmount - totalCost);
        }

        displayItems();

        return true;
    }

    private void printMultipleReceipts(List<Item> purchasedItems, double totalCost, double change) {
        try {
            System.out.println("\n==============================================");
            System.out.println("|           RAIO  Vending Machine            |");
            System.out.println("|============================================|");

            for (Item purchasedItem : purchasedItems) {
                int slot = Item.getItemNames().indexOf(purchasedItem.getItemName());
                int quantity = purchasedItem.getQuantity();
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



/**

 public void customizeProduct() {
 boolean continueSelecting = true;

 List<Item> selectedItems = new ArrayList<>();

 while (continueSelecting) {
 // Display the available items to choose from
 displayItems();

 System.out.print("Enter the item number you want to add to the product (1-" + getSlotCount() + "): ");
 int itemNumber = scanner.nextInt();
 scanner.nextLine(); // Consume the newline character

 if (itemNumber < 1 || itemNumber > getSlotCount()) {
 System.out.println("Invalid item number.");
 continue;
 }

 // Get the selected item
 Item item = items.get(itemNumber - 1);
 selectedItems.add(item);

 System.out.print("Do you want to add another item to the product? (Y/N): ");
 String choice = scanner.nextLine().trim().toUpperCase();
 if (!choice.equals("Y")) {
 continueSelecting = false;
 }
 }

 // Calculate the total calories for the product
 int totalCalories = 0;
 for (Item item : selectedItems) {
 totalCalories += item.getCalories();
 }

 // Display the preparation process
 System.out.println("Preparing the product...");
 for (Item item : selectedItems) {
 System.out.println("Adding " + item.getItemName() + "...");
 }
 System.out.println("Product Done!");

 // Display the total calories for the product
 System.out.println("Total Calories for the Product: " + totalCalories);
 }
 */





