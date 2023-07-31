import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateVendingMachineView extends JFrame {
    private JButton regularVendingMachineButton;
    private JButton specialVendingMachineButton;
    private JButton backButton;

    // Constructor
    public CreateVendingMachineView() {
        // Set the title of the window
        setTitle("RAIO Pizza Vending Machine");

        // Set the size of the window
        setSize(400, 300);

        // Prevent resizing of the window
        setResizable(false);

        // Set the layout
        setLayout(new BorderLayout());

        // Add the top panel with the question
        add(createTopPanel(), BorderLayout.NORTH);

        // Add the main menu panel (center)
        add(createCenterPanel(), BorderLayout.CENTER);

        // Add a bottom panel with the same color as the top panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(255, 99, 71)); // Tomato red color
        backButton = createButton("Back");
        bottomPanel.add(backButton); // Add the back button to the bottom panel
        add(bottomPanel, BorderLayout.SOUTH);

        // Set default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }

    private JPanel createTopPanel() {
        // Create a background panel with a specific color (e.g., tomato red)
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(255, 99, 71)); // Tomato red color

        // Create and add the question label
        JLabel questionLabel = new JLabel("What kind of vending machine?");
        questionLabel.setFont(new Font("Serif", Font.BOLD, 18));
        questionLabel.setForeground(Color.WHITE);
        topPanel.add(questionLabel);

        return topPanel;
    }

    private JPanel createCenterPanel() {
        // Create the main menu panel with GridBagLayout to center the buttons
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(255, 255, 204)); // Light yellow color for cheese

        // Create and add buttons with equal widths
        regularVendingMachineButton = createButton("Regular Vending Machine");
        specialVendingMachineButton = createButton("Special Vending Machine");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Aligns components to the center
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fills the horizontal space

        centerPanel.add(regularVendingMachineButton, gbc);
        centerPanel.add(specialVendingMachineButton, gbc);

        return centerPanel;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.PLAIN, 18));
        button.setMaximumSize(new Dimension(300, 50)); // Set a maximum size for equal widths
        return button;
    }

    // Methods to add listeners to the buttons (will be used by the controller)
    public void addRegularVendingMachineListener(ActionListener listener) {
        regularVendingMachineButton.addActionListener(listener);
    }

    public void addSpecialVendingMachineListener(ActionListener listener) {
        specialVendingMachineButton.addActionListener(listener);
    }
    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
