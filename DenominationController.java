import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The DenominationController class serves as a controller for handling interactions
 * between the DenominationDialog view and the RegularVendingMachine model.
 */

public class DenominationController {
    private DenominationDialog view;
    private RegularVendingMachine model;


    /**
     * Constructs a DenominationController instance.
     *
     * @param view  The DenominationDialog view.
     * @param model The RegularVendingMachine model.
     */
    public DenominationController(DenominationDialog view, RegularVendingMachine model) {
        this.view = view;
        this.model = model;

        this.view.addSubmitListener(new SubmitButtonListener());
    }

    /**
     * ActionListener implementation that listens for the submit button click event.
     */
    class SubmitButtonListener implements ActionListener {
        /**
         * Handles the actionPerformed event when the submit button is clicked.
         *
         * @param e The ActionEvent associated with the button click.
         */

        public void actionPerformed(ActionEvent e) {
            List<Integer> quantities = view.getDenominationQuantities();
            model.setDenominationQuantities(quantities);
            view.dispose();
        }
    }
    /**
     * Displays the associated DenominationDialog view.
     */

    public void displayView() {
        view.display();
    }
}