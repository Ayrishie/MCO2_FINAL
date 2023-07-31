import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ItemCaloriesGUI {

    private JDialog dialog;
    private final Item item;
    private List<JTextField> calorieTextFields;

    public ItemCaloriesGUI(Item item) {
        this.item = item;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        dialog = new JDialog();
        dialog.setTitle("Set Item Calories");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(item.getSlotCount() + 1, 2));


        JLabel[] labels = new JLabel[item.getSlotCount()];
        calorieTextFields = new ArrayList<>();

        for (int i = 0; i < item.getSlotCount(); i++) {
            labels[i] = new JLabel(item.getitemNames().get(i));
            JTextField calorieTextField = new JTextField(5);
            calorieTextFields.add(calorieTextField);

            dialog.add(labels[i]);
            dialog.add(calorieTextField);
        }

        JButton setButton = new JButton("Set Calories");
        setButton.addActionListener(new SetCaloriesAction());

        dialog.add(new JLabel());
        dialog.add(setButton);
        dialog.pack();
        dialog.setVisible(true);
    }

    private class SetCaloriesAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < calorieTextFields.size(); i++) {
                try {
                    int calories = Integer.parseInt(calorieTextFields.get(i).getText());
                    if (calories < 0) {
                        JOptionPane.showMessageDialog(dialog, "Calories cannot be negative. Please enter a valid number for " + item.getitemNames().get(i));
                        return;
                    }
                    item.getItemCalories().set(i, calories);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Invalid input for " + item.getitemNames().get(i) + ". Please enter a number.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(dialog, "Calories set successfully!");
            dialog.dispose();
        }
    }
}
