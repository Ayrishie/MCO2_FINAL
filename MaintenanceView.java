import javax.swing.*;
import java.awt.*;

public class MaintenanceView {
    private JFrame frame;
    private JPanel maintenancePanel;
    private JButton refillButton;
    private JButton restockButton;
    private JButton updatePricesButton;
    private JButton collectPaymentsButton;
    private JButton printSummaryButton;
    private JButton goBackButton;

    public MaintenanceView() {
        frame = new JFrame("Maintenance Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        maintenancePanel = new JPanel();
        maintenancePanel.setLayout(new BoxLayout(maintenancePanel, BoxLayout.Y_AXIS));

        refillButton = new JButton("Refill Items");
        restockButton = new JButton("Restock Change");
        updatePricesButton = new JButton("Update Prices");
        collectPaymentsButton = new JButton("Collect Payments");
        printSummaryButton = new JButton("Print Summary");
        goBackButton = new JButton("Go Back");

        maintenancePanel.add(refillButton);
        maintenancePanel.add(restockButton);
        maintenancePanel.add(updatePricesButton);
        maintenancePanel.add(collectPaymentsButton);
        maintenancePanel.add(printSummaryButton);
        maintenancePanel.add(goBackButton);

        frame.add(maintenancePanel, BorderLayout.CENTER);
    }

    public void show() {
        frame.setVisible(true);
    }

    // Getters for the buttons for our controller to use
    public JButton getRefillButton() { return refillButton; }
    public JButton getRestockButton() { return restockButton; }
    public JButton getUpdatePricesButton() { return updatePricesButton; }
    public JButton getCollectPaymentsButton() { return collectPaymentsButton; }
    public JButton getPrintSummaryButton() { return printSummaryButton; }
    public JButton getGoBackButton() { return goBackButton; }
}
