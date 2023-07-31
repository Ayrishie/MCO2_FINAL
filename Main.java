import javax.swing.*;
/**
 * This class represents the entry point of the program.
 */
public class Main {
    /**
     * The main method that starts the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            Menu menu = new Menu();
            Item itemInstance = new Item();
            Controller controller = new Controller(mainView, menu, itemInstance);
        });
    }
}





