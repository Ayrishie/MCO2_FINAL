import javax.swing.*;

/**
 * The MaintenanceController class manages user interactions and actions related to maintenance
 * operations for a vending machine.
 */

public class MaintenanceController implements IVendingMachine{
    private MaintenanceView mView;
    private RegularVendingMachine rVendingMachine;
    private Maintenance maintenance; // Assuming you have a Maintenance class
    private VendingMachineView mainView;
    private IVendingMachine vendingMachine;


    /**
     * Constructs a MaintenanceController instance.
     *
     * @param view      The MaintenanceView associated with this controller.
     * @param machine   The RegularVendingMachine instance to perform maintenance on.
     * @param mainView  The main VendingMachineView used for navigation.
     */

    public MaintenanceController(MaintenanceView view, VendingMachineView mainView, IVendingMachine machine) {
        this.mView = view;
        this.vendingMachine = machine;
        this.mainView = mainView;
        maintenance = new Maintenance();  // Initialize the maintenance class
        initController();
    }

    /**
     * Initializes the event listeners and actions for maintenance operations.
     */
    private void initController() {
        mView.getCollectPaymentsButton().addActionListener(e -> maintenance.dispenseTotalPayments(rVendingMachine));
        mView.getRefillButton().addActionListener(e -> {mView.showRefillDialog();});

        mView.getConfirmRefillButton().addActionListener(e -> {
            try {
                int slotNumber = Integer.parseInt(mView.getSlotNumberField().getText());
                int quantity = Integer.parseInt(mView.getQuantityField().getText());

                String resultMessage = rVendingMachine.refillItem(slotNumber, quantity);
                JOptionPane.showMessageDialog(null, resultMessage);

                mView.hideRefillDialog();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for slot and quantity.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        });
        mView.getCancelRefillButton().addActionListener(e -> mView.hideRefillDialog());
        mView.getRestockButton().addActionListener(e -> {
            mView.showRestockChangeDialog();
        });

        mView.getConfirmRestockButton().addActionListener(e -> {
            try {
                int denominationNumber = Integer.parseInt(mView.getDenominationNumberField().getText());
                int quantity = Integer.parseInt(mView.getDenominationQuantityField().getText());

                String resultMessage = rVendingMachine.restockChange(denominationNumber, quantity);
                JOptionPane.showMessageDialog(null, resultMessage);

                mView.hideRestockChangeDialog();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for denomination and quantity.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        });

        mView.getCancelRestockButton().addActionListener(e -> mView.hideRestockChangeDialog());

        mView.getUpdatePricesButton().addActionListener(e -> mView.showUpdatePricesDialog());

        mView.getConfirmUpdatePricesButton().addActionListener(e -> {
            try {
                int slotNumber = Integer.parseInt(mView.getUpdateSlotNumberField().getText());
                double newPrice = Double.parseDouble(mView.getUpdatePriceField().getText());

                maintenance.updatePrices(vendingMachine, slotNumber, newPrice);

                mView.hideUpdatePricesDialog();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for slot and price.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        });

        mView.getCancelUpdatePricesButton().addActionListener(e -> mView.hideUpdatePricesDialog());
        mView.getGoBackButton().addActionListener(e -> {
            mView.getFrame().dispose();
            mainView.showTestVendingMachinePanel();
        });

        // Print Summary Button
        mView.getCollectPaymentsButton().addActionListener(e -> {
            double totalPayments = maintenance.dispenseTotalPayments(vendingMachine);
            JOptionPane.showMessageDialog(mView.getFrame(), "Total payments: $" + totalPayments + "\nPayments dispensed.");
        });
        mView.getPrintSummaryButton().addActionListener(e -> {
            String summary = vendingMachine.generateSummary();
            JOptionPane.showMessageDialog(mView.getFrame(), summary, "Item Summary", JOptionPane.INFORMATION_MESSAGE);
        });
    }


    @Override
    public String refillItem(int slotNumber, int quantity) {
        return null;
    }

    @Override
    public String restockChange(int denominationNumber, int quantity) {
        return null;
    }

    @Override
    public String generateSummary() {
        return null;
    }

    @Override
    public String updateItemPrice(int slotNumber, double newPrice) {
        return null;
    }

    @Override
    public double getTotalSales() {
        return 0;
    }
}
