import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


/**
 * The InitializeItemsDialog class represents a dialog for initializing item properties.
 * Users can input prices and calorie values for each item.
 */

public class InitializeItemsDialog extends JDialog {

    private List<JTextField> priceFields;
    private List<JTextField> calorieFields;
    private Map<String, Item> newItemPropertiesMap;
    private JButton submitButton;
    private List<String> itemNames;


    /**
     * The InitializeItemsDialog class represents a dialog for initializing item properties.
     * Users can input prices and calorie values for each item.
     */
    public InitializeItemsDialog(JFrame owner) {
        super(owner, "Initialize Items", true);
        setSize(300, 400);
        setLayout(new GridLayout(0, 3));

        itemNames = Item.getItemNames();
        priceFields = new ArrayList<>();
        calorieFields = new ArrayList<>();
        newItemPropertiesMap = new HashMap<>();

        // Add labels for headers
        add(new JLabel("Item", SwingConstants.CENTER));
        add(new JLabel("Price", SwingConstants.CENTER));
        add(new JLabel("Calories", SwingConstants.CENTER));

        // Create labels and text fields for items
        for (String itemName : itemNames) {
            add(new JLabel(itemName));
            JTextField priceField = new JTextField();
            priceFields.add(priceField);
            add(priceField);
            JTextField calorieField = new JTextField();
            calorieFields.add(calorieField);
            add(calorieField);
        }

        submitButton = new JButton("Submit");
        add(submitButton);

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    /**
     * Adds a listener for the submit button.
     *
     * @param listenForSubmitButton The ActionListener to be notified when the submit button is clicked.
     */
    public void addSubmitListener(ActionListener listenForSubmitButton) {
        submitButton.addActionListener(listenForSubmitButton);
    }

    /**
     * Handles the submit button action by collecting and validating item properties.
     */
    private void handleSubmit() {
        Map<String, Item> properties = getItemProperties();
        if (properties != null) {
            newItemPropertiesMap = properties;
            this.dispose();
        }
    }

    /**
     * Displays the dialog on the screen.
     */
    public void display() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Retrieves the inputted item properties from the dialog.
     *
     * @return A map of item names to their corresponding Item objects with updated properties.
     */

    public Map<String, Item> getItemProperties() {
        Map<String, Item> newItemProperties = new HashMap<>();

        for (int i = 0; i < itemNames.size(); i++) {
            try {
                String itemName = itemNames.get(i);
                double price = Double.parseDouble(priceFields.get(i).getText());
                int calories = Integer.parseInt(calorieFields.get(i).getText());

                newItemProperties.put(itemName, new Item(itemName, Item.getItemCapacity(), price, calories));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid values for price and calories. Price should be a number and calories should be an integer.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return newItemProperties;
    }
}
