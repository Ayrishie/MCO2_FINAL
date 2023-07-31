import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame {
    private MainMenuPanel mainMenuPanel; // Attribute for the main menu panel

    // Constructor
    public MainView() {
        // Set the title of the window
        setTitle("RAIO Pizza Vending Machine");

        // Set the size of the window
        setSize(400, 300);

        // Prevent resizing of the window
        setResizable(false);

        // Set the layout
        setLayout(new BorderLayout());

        // Add the title panel (top)
        add(new TitlePanel(), BorderLayout.NORTH);

        // Create and add the main menu panel (center)
        mainMenuPanel = new MainMenuPanel(); // Initialize the main menu panel
        add(mainMenuPanel, BorderLayout.CENTER);

        // Add a bottom panel with the same color as the top panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(255, 99, 71)); // Tomato red color
        add(bottomPanel, BorderLayout.SOUTH);

        // Set default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }

    // Getter method for the main menu panel
    public MainMenuPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainView::new);
    }
}
