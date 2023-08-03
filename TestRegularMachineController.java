import javax.swing.*;

/**
 * The TestRegularMachineController class is responsible for controlling interactions between the
 * TestRegularMachineView (UI) and the RegularVendingMachine model for testing purposes.
 */
public class TestRegularMachineController {
    private TestRegularMachineView view;
    private RegularVendingMachine model;

    /**
     * Constructs a TestRegularMachineController object with the specified view and model.
     *
     * @param view  The TestRegularMachineView instance representing the UI.
     * @param model The RegularVendingMachine instance representing the vending machine model.
     */
    public TestRegularMachineController(TestRegularMachineView view, RegularVendingMachine model) {
        this.view = view;
        this.model = model;
        view.getExecuteButton().addActionListener(e -> testFeatures());
    }

    /**
     * Executes the test features using data from the view.
     */
    private void testFeatures() {
        int itemNumber = Integer.parseInt(view.getItemNumber());
        int paymentDenomination = Integer.parseInt(view.getPaymentDenomination());
    }
}
