import java.util.HashMap;
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

        // Initialize the itemPromotions map to store item promotions.
        itemPromotions = new HashMap<>();
    }

    /**
     * Adds a new item promotion to the vending machine.
     *
     * @param itemName   The name of the item to be promoted.
     * @param promotion  The description of the promotion.
     */
    public void addItemPromotion(String itemName, String promotion) {
        itemPromotions.put(itemName, promotion);
    }

    /**
     * Overrides the printReceipt method to include item promotions in the receipt.
     *
     * @param slot      The slot number of the item purchased.
     * @param quantity  The quantity of the item purchased.
     * @param change    The change amount given to the customer.
     */
    @Override
    protected void printReceipt(int slot, int quantity, double change) {
        // Call the superclass method to print the basic receipt.

        // Check if there is a promotion for the purchased item.
        String itemName = itemNames.get(slot);
        if (itemPromotions.containsKey(itemName)) {
            System.out.println("Promotion: " + itemPromotions.get(itemName));
        }
    }

    // You can add more specialized methods and features for the SpecialVendingMachine as needed.
}
