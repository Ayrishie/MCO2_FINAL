import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The ItemController class manages interactions and actions related to updating item properties
 * through the InitializeItemsDialog.
 */

public class ItemController {
    private InitializeItemsDialog view;
    private Map<String, Item> items;


    /**
     * Constructs an ItemController instance.
     *
     * @param view   The InitializeItemsDialog associated with this controller.
     * @param items  A map containing existing items and their properties.
     */
    public ItemController(InitializeItemsDialog view, Map<String, Item> items) {
        this.view = view;
        this.items = items;

        this.view.addSubmitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItemProperties();
            }
        });
    }

    /**
     * Updates the properties of existing items based on user input.
     */
    private void updateItemProperties() {
        Map<String, Item> newItemProperties = view.getItemProperties();

        for (String itemName : newItemProperties.keySet()) {
            Item updatedItem = newItemProperties.get(itemName);
            Item existingItem = this.items.get(itemName);

            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setCalories(updatedItem.getCalories());
        }
    }
    /**
     * Displays the associated InitializeItemsDialog view.
     */

    public void displayView() {
        view.display();
    }
}
