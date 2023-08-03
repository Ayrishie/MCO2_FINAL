import java.util.Scanner;
import javax.swing.*;


/**
 * Maintenance is a class that represents the maintenance operations of a vending machine.
 * It provides methods to refill items, restock change, update prices, and dispense total payments.
 */
public class Maintenance {
    private RegularVendingMachine vendingMachine;
    private Scanner scanner;
    private double totalSales; // New variable to store the total payments


    /**The `public Menu()` constructor is initializing the `scanner`, `vendingMachine`, and
     * `maintenance` objects.
     */
    public Maintenance() {
        vendingMachine = null;
        scanner = new Scanner(System.in);
        totalSales = 0.0; // Initialize total payments to 0
    }



    /**
     * Updates the price of an item in the vending machine.
     *
     * @param vendingMachine The RegularVendingMachine object to update the item price.
     */
    public void updatePrices(IVendingMachine vendingMachine, int slotNumber, double newPrice) {
        if (vendingMachine == null) {
            JOptionPane.showMessageDialog(null, "No Vending Machine created yet.");
            return;
        }
        try {
            String feedback = vendingMachine.updateItemPrice(slotNumber, newPrice);
            JOptionPane.showMessageDialog(null, feedback);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred while updating item price.");
            e.printStackTrace();
        }
    }


    /**
     * Dispenses the total payments accumulated in the vending machine.
     *
     * @param vendingMachine The RegularVendingMachine object to dispense the total payments.
     */
    public double dispenseTotalPayments(IVendingMachine vendingMachine) {
        double totalSales = vendingMachine.getTotalSales();
        totalSales = 0; // Reset total payments after dispensing
        return totalSales;
    }
}