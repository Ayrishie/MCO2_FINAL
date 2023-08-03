import java.util.List;

/**
 * The CustomizableProduct class represents a customizable product that can be prepared
 * based on a list of selected items.
 */
class CustomizableProduct {

    // Method to prepare the customizable product based on selected items

    /**
     * Prepares the customizable product based on the selected items.
     *
     * @param selectedItems The list of selected items.
     */

    public void prepareProduct(List<Item> selectedItems) {
        System.out.println(2);
        System.out.println("==================================");
        System.out.println("Preparing the product...");

        for (Item item : selectedItems) {
            String itemName = item.getItemName(); // Corrected method call

            // Print a message based on the item
            switch (itemName) {
                case "Bread":
                    System.out.println("Heating up the " + itemName);
                    break;
                case "Cheese":
                    System.out.println("Melting the " + itemName);
                    break;
                case "Pizza Sauce":
                    System.out.println("Adding " + itemName);
                    break;
                case "Meat toppings":
                    System.out.println("Adding " + itemName);
                    break;
                case "Vegetable toppings":
                    System.out.println("Adding " + itemName);
                    break;
                case "Condiments":
                    System.out.println("Adding " + itemName);
                    break;
                case "Box":
                    System.out.println("Assembling " + itemName);
                    break;
                case "Softdrink":
                    System.out.println("Pouring " + itemName);
                    break;
                default:
                    // Handle unknown items
                    System.out.println("Preparing " + itemName);
                    break;
            }
        }

        System.out.println("Product is done!");
    }
}
