import javax.swing.*;
/**
 * The VendingMachineController class serves as a controller for managing interactions between the
 * graphical user interface (GUI) components and the vending machine models. It handles various actions
 * such as creating vending machines, initiating tests, performing maintenance, and exiting the application.
 */
public class VendingMachineController {
    private VendingMachineView view;
    private RegularVendingMachine rVendingMachine;
    private SpecialVendingMachine sVendingMachine;
    private MaintenanceView maintenanceView;
    private MaintenanceController maintenanceController;
    private TestRegularMachineView testRegularMachineView;
    private TestRegularMachineController testRegularMachineController;
    private IVendingMachine machine;



    /**
     * Constructs a VendingMachineController instance with the specified VendingMachineView.
     *
     * @param view The VendingMachineView associated with this controller.
     */

    public VendingMachineController(VendingMachineView view) {
        this.view = view;
        initController();  // Call this method to set up all the action listeners
    }
    /**
     * Initializes action listeners for various buttons in the GUI.
     */
    private void initController() {
        if (view.getCreateMachineButton() != null)
            view.getCreateMachineButton().addActionListener(e -> view.showCreateVendingMachinePanel());

        if (view.getTestMachineButton() != null)
            view.getTestMachineButton().addActionListener(e -> testVendingMachine());

        if (view.getExitButton() != null)
            view.getExitButton().addActionListener(e -> exitApp());

        if (view.getRegularButton() != null)
            view.getRegularButton().addActionListener(e -> createRegularVendingMachine());

        if (view.getSpecialButton() != null)
            view.getSpecialButton().addActionListener(e -> createSpecialVendingMachine());

        if (view.getReturnButton() != null)
            view.getReturnButton().addActionListener(e -> view.showMainPanel());

        if (view.getInitiateTestButton() != null)
            view.getInitiateTestButton().addActionListener(e -> initiateTest());

        if (view.getMaintenanceButton() != null)
            view.getMaintenanceButton().addActionListener(e -> performMaintenance());

        if (view.getBackButton() != null)
            view.getBackButton().addActionListener(e -> view.showMainPanel());
    }
    /**
     * Displays the test vending machine panel or shows an error message if no vending machine is created.
     */

    private void testVendingMachine() {
        if (rVendingMachine == null && sVendingMachine == null) {
            JOptionPane.showMessageDialog(null, "No Vending Machine created yet. Please create a Vending Machine first.");
            return;
        }
        view.showTestVendingMachinePanel();
    }
    /**
     * Initiates testing based on the type of vending machine created.
     */
    private void initiateTest() {
        if (rVendingMachine != null) {
            if (testRegularMachineView == null) {
                testRegularMachineView = new TestRegularMachineView(rVendingMachine);
                testRegularMachineController = new TestRegularMachineController(testRegularMachineView, rVendingMachine);
            }
            testRegularMachineView.show();
        } else if (sVendingMachine != null) {
            VendingMachineGUIController guiController = new VendingMachineGUIController(sVendingMachine);
            VendingMachineGUI gui = new VendingMachineGUI(guiController);
        } else {
            JOptionPane.showMessageDialog(null, "No Vending Machine to test. Please create one first.");
        }
    }

    /**
     * Performs maintenance operations on the regular vending machine.
     */
    private void performMaintenance() {
        if (machine != null) {
            if (maintenanceView == null) {
                maintenanceView = new MaintenanceView();
                maintenanceController = new MaintenanceController(maintenanceView, view, machine);
            }
            maintenanceView.show();
        } else {
            JOptionPane.showMessageDialog(null, "No Vending Machine created yet.");  // Change the message to be more generalized
        }
    }

    /**
     * Creates a new regular vending machine instance.
     */
    private void createRegularVendingMachine() {
        rVendingMachine = new RegularVendingMachine();
        machine = rVendingMachine;
        JOptionPane.showMessageDialog(null, "Regular Vending Machine created.");
    }
    /**
     * Creates a new special vending machine instance.
     */

    private void createSpecialVendingMachine() {
        sVendingMachine = new SpecialVendingMachine();
        machine = sVendingMachine;  // Assign the newly created instance to the machine field
        JOptionPane.showMessageDialog(null, "Special Vending Machine created.");
    }

    /**
     * Creates a new special vending machine instance.
     */

    private void exitApp() {
        System.exit(0);
    }


}
