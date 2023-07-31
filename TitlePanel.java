import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    // Constructor
    public TitlePanel() {
        // Set the layout
        setLayout(new BorderLayout());

        // Create a background panel with a specific color (e.g., tomato red)
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(255, 99, 71)); // Tomato red color
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        // Create and add the title label
        JLabel titleLabel = new JLabel("🍕 RAIO Pizza Vending Machine 🍕");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        backgroundPanel.add(titleLabel);

        // Create and add the welcome label
        JLabel welcomeLabel = new JLabel("Welcome to PizzaHub!");
        welcomeLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        welcomeLabel.setAlignmentX(CENTER_ALIGNMENT);
        backgroundPanel.add(welcomeLabel);

        // Add the background panel to the title panel
        add(backgroundPanel, BorderLayout.NORTH);
    }
}
