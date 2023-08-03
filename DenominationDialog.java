import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;

/**
 * The DenominationDialog class represents a dialog for setting denomination quantities.
 * Users can input quantities for each denomination.
 */

public class DenominationDialog extends JDialog {
    private List<JTextField> denominationFields;
    private JButton submitButton;
    private List<String> denominationNames;


    /**
     * Constructs a DenominationDialog instance.
     *
     * @param owner            The parent JFrame that owns this dialog.
     * @param denominationNames The list of denomination names.
     */
    public DenominationDialog(JFrame owner, List<String> denominationNames) {
        super(owner, "Set Denominations", true);
        setSize(300, 400);
        setLayout(new GridLayout(0, 2));

        this.denominationNames = denominationNames;
        denominationFields = new ArrayList<>();

        for (String denominationName : denominationNames) {
            add(new JLabel(denominationName));
            JTextField denominationField = new JTextField();
            denominationFields.add(denominationField);
            add(denominationField);
        }

        submitButton = new JButton("Submit");
        add(submitButton);
    }

    /**
     * Retrieves the inputted denomination quantities from the dialog.
     *
     * @return A list of denomination quantities inputted by the user.
     */
    public List<Integer> getDenominationQuantities() {
        List<Integer> quantities = new ArrayList<>();
        for (JTextField field : denominationFields) {
            quantities.add(Integer.parseInt(field.getText()));
        }
        return quantities;
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
     * Displays the dialog on the screen.
     */
    public void display() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}