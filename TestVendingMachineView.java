import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TestVendingMachineView extends JFrame {
    private JButton btnTestFeatures;
    private JButton btnMaintenance;
    private JButton btnBack;
    private JPanel buttonPanel; // Panel to hold the buttons

    public TestVendingMachineView() {
        setTitle("Test Vending Machine Menu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout()); // Use GridBagLayout to center the panel

        btnTestFeatures = new JButton("Test Vending Features");
        btnMaintenance = new JButton("Maintenance");
        btnBack = new JButton("Go back to main menu");

        // Determine the maximum width from all buttons
        int maxWidth = Math.max(btnTestFeatures.getPreferredSize().width,
                Math.max(btnMaintenance.getPreferredSize().width,
                        btnBack.getPreferredSize().width));

        // Set maximum size for each button based on the determined width
        Dimension maxButtonSize = new Dimension(maxWidth, btnTestFeatures.getPreferredSize().height);
        btnTestFeatures.setPreferredSize(maxButtonSize);
        btnMaintenance.setPreferredSize(maxButtonSize);
        btnBack.setPreferredSize(maxButtonSize);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(btnTestFeatures);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnMaintenance);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnBack);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
    }

    public void addTestFeaturesListener(ActionListener listener) {
        btnTestFeatures.addActionListener(listener);
    }

    public void addMaintenanceListener(ActionListener listener) {
        btnMaintenance.addActionListener(listener);
    }

    public void addBackListener(ActionListener listener) {
        btnBack.addActionListener(listener);
    }
}
