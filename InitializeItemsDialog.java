import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class InitializeItemsDialog extends JDialog {

    private List<JTextField> priceFields;
    private List<JTextField> calorieFields;
    private Map<String, Item> newItemPropertiesMap;
    private JButton submitButton;
    private List<String> itemNames;

    public InitializeItemsDialog(JFrame owner) {
        super(owner, "Initialize Items", true);
        setSize(300, 400);
        setLayout(new GridLayout(0, 3));

        itemNames = Item.getItemNames();
        priceFields = new ArrayList<>();
        calorieFields = new ArrayList<>();
        newItemPropertiesMap = new HashMap<>();

        // Add labels for headers
        add(new JLabel("Item", SwingConstants.CENTER)); // Centered header for better appearance
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

    public Map<String, Item> getItemProperties() {
        Map<String, Item> newItemProperties = new HashMap<>();

        for (int i = 0; i < itemNames.size(); i++) {
            String itemName = itemNames.get(i);
            double price = Double.parseDouble(priceFields.get(i).getText());
            int calories = Integer.parseInt(calorieFields.get(i).getText());

            newItemProperties.put(itemName, new Item(itemName, Item.getItemCapacity(), price, calories));
        }

        return newItemProperties;
    }

    public void addSubmitListener(ActionListener listenForSubmitButton) {
        submitButton.addActionListener(listenForSubmitButton);
    }

    private void handleSubmit() {
        newItemPropertiesMap = getItemProperties();
        this.dispose();  // This will close the dialog.
    }

    // To be called from within the RegularVendingMachine class when you want to display the dialog.
    public void display() {
        pack();
        setLocationRelativeTo(null); // Center the dialog
        setVisible(true);
    }
}
