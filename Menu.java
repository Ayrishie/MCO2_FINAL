
import java.util.Scanner;

/**
 * The Menu class represents the main menu of the vending machine.
 * It provides options for customer operations and maintenance operations.
 */
public class Menu {
    private Scanner scanner;
    private RegularVendingMachine vendingMachine;
    private Maintenance maintenance;


    /**
     * Constructs a new Menu object.
     * Initializes the scanner, vending machine, and maintenance instance.
     */
    public Menu() {
        scanner = new Scanner(System.in);
        vendingMachine = null;
        maintenance = new Maintenance(); // Create an instance of Maintenance
    }

    /**
     * The Menu class represents a user interface for interacting with a vending machine.
     * It provides options to create a vending machine, test its features, and perform maintenance tasks.
     */

    private void showTestVendingMachineSubMenu() {
        System.out.println();
        System.out.println();
        System.out.println("\u001B[35m========================================");
        System.out.println("\u001B[35m      Test Vending Machine Menu       ");
        System.out.println("\u001B[35m========================================");
        System.out.println("\u001B[31m  1. Test Vending Features");
        System.out.println("\u001B[31m  2. Maintenance");
        System.out.println("\u001B[31m  3. Go back to main menu");
        System.out.println("\u001B[35m========================================");
        System.out.println("\u001B[0m[STVMS]Enter your choice (1-3)");
        System.out.print("\t\t=> ");
    }

    /**
     * Constructs a Menu object with default values.
     * Initializes the scanner, vending machine, and maintenance objects.
     */
    private void showTitleScreen() {
        System.out.println();
        System.out.println(String.format("%60s", "\u001B[38;5;196m========== Test Vending Machine =========="));
        System.out.println(String.format("%52s", "\u001B[38;5;202mRRRR    AAAA  IIIIII   OOOOO"));
        System.out.println(String.format("%52s", "\u001B[38;5;208mR   R  A    A   II     O   O"));
        System.out.println(String.format("%52s", "\u001B[38;5;214mRRRR   AAAAAA   II     O   O"));
        System.out.println(String.format("%52s", "\u001B[38;5;220mR  R   A    A   II     O   O"));
        System.out.println(String.format("%52s", "\u001B[38;5;226mR   R  A    A  IIIII   OOOOO"));
        System.out.print(String.format("%60s", "\u001B[38;5;190m============================================="));

        System.out.println("\t\t\nWelcome to RAIO Vending Machine Factory and Store!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the main menu and handles user input.
     * Allows the user to create a vending machine, test its features, or exit the program.
     */
    private void showColoredMenu() {
        System.out.println();
        System.out.println();
        System.out.println("\u001B[32m====== Vending Machine Menu ======");
        System.out.println("\u001B[32m=================================");
        System.out.println("\u001B[33m1. Create a Vending Machine");
        System.out.println("\u001B[33m2. Test a Vending Machine");
        System.out.println("\u001B[33m3. Exit");
        System.out.println("\u001B[32m=================================");

        System.out.print("\t\t=> ");

    }


    /**
     * The function creates a vending machine and prompts the user to choose between a regular or
     * special vending machine.
     */
    public void createVendingMachine() {
        vendingMachine = new RegularVendingMachine();
    }

    /**
     * The performMaintenance() function displays a maintenance menu and allows the user to perform
     * various maintenance tasks on a vending machine.
     */
    private void performMaintenance() {

        int option;
        do {
            System.out.println();
            System.out.println();
            System.out.println("==============================");
            System.out.println("|     Maintenance Menu       |");
            System.out.println("==============================");
            System.out.println("| 1. Refill Items            |");
            System.out.println("| 2. Restock Change          |");
            System.out.println("| 3. Update Prices           |");
            System.out.println("| 4. Collect Payments        |");
            System.out.println("| 5. Print Summary           |");
            System.out.println("| 6. Go Back                 |");
            System.out.println("==============================");
            System.out.print("\u001B[92mEnter your choice (1-6): ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    maintenance.refillItem(vendingMachine);
                    break;
                case 2:
                    maintenance.restockChange(vendingMachine);
                    break;
                case 3:
                    maintenance.updatePrices(vendingMachine);
                    break;
                case 4:
                    maintenance.dispenseTotalPayments(vendingMachine);
                    break;
                case 5:
                    vendingMachine.printSummary();
                    break;
                case 6:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option != 6);
    }

    /**
     * The function "displayMenu" displays a menu with options to create a vending machine, test the
     * vending machine, or exit the program, and continues to display the menu until the user chooses
     * to exit.
     */
    public void displayMenu() {
        showTitleScreen(); // display once
        int choice;
        do {
            clearScreen();
            showColoredMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createVendingMachine();
                    break;
                case 2:
                    testVendingMachineSubMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }

    /**
     * The function "testVendingMachineSubMenu" displays a menu for testing vending machine features and
     * allows the user to choose an option.
     */
    public void testVendingMachineSubMenu() {
        if (vendingMachine == null) {
            System.out.println("\u001b[31m No Vending Machine created yet.");
            System.out.println("\u001b[31m Please create a Vending Machine first.\u001B[0m");
            return;
        }
        int option;
        do {
            clearScreen();
            showTestVendingMachineSubMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character


            switch (option) {
                case 1:
                    testVendingFeatures();

                    break;
                case 2:
                    performMaintenance();

                    break;
                case 3:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option != 3);
    }

    /**
     * The clearScreen() function clears the console screen in Java.
     */
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * The function allows the user to test vending machine features by selecting an item and making a
     * payment.
     */

    private void testVendingFeatures() {

        vendingMachine.displayItems();

        System.out.print("Enter the item number you want to purchase (1-" + vendingMachine.getSlotCount() + "): ");
        int itemNumber;
        if (scanner.hasNextInt()) {
            itemNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } else {
            System.out.println("Invalid input. Please enter a valid item number.");
            return;
        }
        // Adjust the itemNumber value to match zero-based indexing
        int slotNumber = itemNumber;

        System.out.println("[menu DEBUG] Slot number: " + slotNumber);
        System.out.println("[menu DEBUG] Slot count: " + vendingMachine.getSlotCount());

        if ((slotNumber < 0) || (slotNumber >= vendingMachine.getSlotCount())) {
            System.out.println("Item slot doesn't exist");
            return;
        }


        vendingMachine.displayUpdatedDenominationQuantities();
        System.out.print("Enter the payment denomination (1-9): ");
        int paymentDenomination;
        if (scanner.hasNextInt()) {
            paymentDenomination = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } else {
            System.out.println("Invalid input. Please enter a valid payment denomination.");
            return;
        }

        System.out.println("[menu DEBUG] Payment Denomination: " + paymentDenomination);

        if ((paymentDenomination < 1) || (paymentDenomination > 9)) {
            System.out.println("Denomination doesn't exist");
            return;
        }

        if (vendingMachine.processTransaction(slotNumber, paymentDenomination)) {
            System.out.println();
            System.out.println("Transaction completed successfully.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Transaction failed.");
            System.out.println();
        }
    }

    public void initiateMaintenance() {
        performMaintenance();
    }

    public RegularVendingMachine getRegularVendingMachine() {
        RegularVendingMachine vendingMachine1 = this.vendingMachine;
        return vendingMachine1;
    }

}
