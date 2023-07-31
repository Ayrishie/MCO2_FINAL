import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DenominationQuantitiesGUI extends JDialog {
    private final List<String> denominationNames;
    private final List<Integer> denominationQuantities;
    private final RegularVendingMachine machine;

    public DenominationQuantitiesGUI(JFrame parentFrame, RegularVendingMachine machine) {
        super(parentFrame, "Set Denomination Quantities", true); // Set 'true' for modal
        this.machine = machine;
        this.denominationNames = machine.getDenominationNames();
        this.denominationQuantities = machine.getDenominationQuantities();

        setSize(400, 300);
        setLayout(new GridLayout(denominationNames.size() + 1, 2));

        for (int i = 0; i < denominationNames.size(); i++) {
            JLabel label = new JLabel(denominationNames.get(i) + ": ");
            JTextField field = new JTextField(5);
            field.setText(String.valueOf(denominationQuantities.get(i))); // Show current values
            add(label);
            add(field);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valid = true;
                for (int i = 0; i < getContentPane().getComponents().length; i += 2) {
                    Component comp = getContentPane().getComponents()[i + 1];  // Fetch the component first

                    if (comp instanceof JTextField) {  // Check if the component is an instance of JTextField
                        JTextField field = (JTextField) comp;
                        try {
                            denominationQuantities.set(i / 2, Integer.parseInt(field.getText()));
                        } catch (NumberFormatException ex) {
                            valid = false;
                            JOptionPane.showMessageDialog(null, "Invalid input for " + denominationNames.get(i / 2), "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }
                if (valid) {
                    dispose();
                }
            }
        });


        add(new JLabel()); // Empty space
        add(submitButton);

        pack();
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }
}
