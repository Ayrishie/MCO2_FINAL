import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    private JButton createVendingMachineButton;
    private JButton testVendingMachineButton;
    private JButton exitButton;

    // Constructor
    public MainMenuPanel() {
        // Set the background color (light yellow for cheese)
        setBackground(new Color(255, 255, 204));

        // Set the layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createVendingMachineButton = createButton("Create a Vending Machine");
        testVendingMachineButton = createButton("Test a Vending Machine");
        exitButton = createButton("Exit");

        // Add buttons with equal widths
        add(createVendingMachineButton); // Use the member variables instead of calling createButton again
        add(testVendingMachineButton);
        add(exitButton);
    }

    // Method to create a button with specific styling
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.PLAIN, 18));
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(300, 50)); // Set a maximum size for equal widths
        add(button); // Add the button to the panel
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons
        return button;
    }


    public void addCreateVendingMachineListener(ActionListener listener) {
        createVendingMachineButton.addActionListener(listener);
    }

    public void addTestVendingMachineListener(ActionListener listener) {
        testVendingMachineButton.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}