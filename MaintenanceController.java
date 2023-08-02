public class MaintenanceController {
    private MaintenanceView mView;
    private RegularVendingMachine rVendingMachine;
    private Maintenance maintenance; // Assuming you have a Maintenance class

    public MaintenanceController(MaintenanceView view, RegularVendingMachine machine) {
        this.mView = view;
        this.rVendingMachine = machine;
        initController();
    }

    private void initController() {
        mView.getRefillButton().addActionListener(e -> maintenance.refillItem(rVendingMachine));
        mView.getRestockButton().addActionListener(e -> maintenance.restockChange(rVendingMachine));
        mView.getUpdatePricesButton().addActionListener(e -> maintenance.updatePrices(rVendingMachine));
        mView.getCollectPaymentsButton().addActionListener(e -> maintenance.dispenseTotalPayments(rVendingMachine));
        mView.getPrintSummaryButton().addActionListener(e -> rVendingMachine.printSummary());
        mView.getGoBackButton().addActionListener(e -> mView.show()); // Or close the maintenance menu and return to the main menu
    }
}
