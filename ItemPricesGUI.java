import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ItemPricesGUI {

    private JDialog dialog;
    private final Item item;
    private List<JTextField> priceTextFields;

    public ItemPricesGUI(Item item, JFrame parentFrame) {
        this.item = item;
        createAndShowGUI(parentFrame);
    }

    private void createAndShowGUI(JFrame parentFrame) {
        dialog = new JDialog(parentFrame, "Set Item Prices", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(item.getSlotCount() + 1, 2));

        JLabel[] labels = new JLabel[item.getSlotCount()];
        priceTextFields = new ArrayList<>();

        for (int i = 0; i < item.getSlotCount(); i++) {
            labels[i] = new JLabel(item.getitemNames().get(i));
            JTextField priceTextField = new JTextField(5);
            priceTextFields.add(priceTextField);

            dialog.add(labels[i]);
            dialog.add(priceTextField);
        }

        JButton setButton = new JButton("Set Prices");
        setButton.addActionListener(new SetPricesAction());

        dialog.add(new JLabel());
        dialog.add(setButton);
        dialog.pack();
        dialog.setVisible(true);
    }

    private class SetPricesAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < priceTextFields.size(); i++) {
                try {
                    double price = Double.parseDouble(priceTextFields.get(i).getText());
                    if (price < 0) {
                        JOptionPane.showMessageDialog(dialog, "Price cannot be negative. Please enter a valid number for " + item.getitemNames().get(i));
                        return;
                    }
                    item.getItemPrices().set(i, price);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Invalid input for " + item.getitemNames().get(i) + ". Please enter a valid number.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(dialog, "Prices set successfully!");
            dialog.dispose();
        }
    }
}
