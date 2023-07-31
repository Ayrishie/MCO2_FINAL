import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final MainView mainView;
    private CreateVendingMachineView createVendingMachineView;
    private final Menu menu;
    private TestVendingMachineView testVendingMachineView;
    private final Item item;


    public Controller(MainView mainView, Menu menu, Item item) {
        this.mainView = mainView;
        this.menu = menu;
        this.item = item;

        // Add listeners for the main menu buttons
        mainView.getMainMenuPanel().addCreateVendingMachineListener(e -> openCreateVendingMachineView());
        mainView.getMainMenuPanel().addTestVendingMachineListener(e -> openTestVendingMachineView());
        mainView.getMainMenuPanel().addExitListener(e -> exit());
    }

    private void openCreateVendingMachineView() {
        // Close the main window
        mainView.dispose();

        // Open the create vending machine window
        createVendingMachineView = new CreateVendingMachineView();
        createVendingMachineView.addRegularVendingMachineListener(e -> createRegularVendingMachine());
        createVendingMachineView.addBackListener(e -> openMainMenu());
    }

    private void createRegularVendingMachine() {
        // Logic to create a regular vending machine
        menu.createVendingMachine();
        JOptionPane.showMessageDialog(createVendingMachineView, "Regular Vending Machine created.");
        // Additional logic to navigate to the next step or close the window
    }



    private void performMaintenance() {
        menu.initiateMaintenance();
    }

    private void exit() {
        System.exit(0); // Exit the program
    }

    private void openMainMenu() {
        // Close the create vending machine window
        if (createVendingMachineView != null) {
            createVendingMachineView.dispose();
        }

        // Open the main menu window
        mainView.setVisible(true);
    }

    private void openTestVendingMachineView() {
        // Close the main window
        mainView.dispose();

        // Open the test vending machine window
        testVendingMachineView = new TestVendingMachineView();
        testVendingMachineView.addTestFeaturesListener(e -> testVendingFeatures());
        testVendingMachineView.addMaintenanceListener(e -> performMaintenance());
        testVendingMachineView.addBackListener(e -> openMainMenu());

        testVendingMachineView.setVisible(true);
    }

    private void testVendingFeatures() {
        RegularVendingMachine vendingMachine = menu.getRegularVendingMachine();
        new VendingMachineGUI(vendingMachine, item);
    }

}

