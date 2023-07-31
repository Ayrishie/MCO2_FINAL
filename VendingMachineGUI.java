import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineGUI extends JFrame {
    private JTable itemsTable;
    private JComboBox<Integer> itemNumberBox;
    private JComboBox<Integer> denominationBox;
    private JButton submitButton;
    private JTextArea messageArea;
    RegularVendingMachine machine;


    public VendingMachineGUI(RegularVendingMachine vendingMachine, Item item) {
        setTitle("Vending Machine");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display the items in a table
        String[] columnNames = {"No", "Item", "Quantity", "Price", "Calories"};
        Object[][] data = new Object[item.getSlotCount()][5];

        for (int i = 0; i < item.getSlotCount(); i++) {
            data[i][0] = i + 1;
            data[i][1] = item.getitemNames().get(i);
            data[i][2] = item.getItemQuantities().get(i);
            data[i][3] = "$" + item.getItemPrices().get(i);
            data[i][4] = item.getItemCalories().get(i);
        }

        itemsTable = new JTable(data, columnNames);
        JScrollPane tablePane = new JScrollPane(itemsTable);
        add(tablePane, BorderLayout.CENTER);

        // Panel for selection and input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        itemNumberBox = new JComboBox<>();
        for (int i = 1; i <= item.getSlotCount(); i++) {
            itemNumberBox.addItem(i);
        }
        inputPanel.add(new JLabel("Select Item:"));
        inputPanel.add(itemNumberBox);

        denominationBox = new JComboBox<>();
        for (int i = 1; i <= 9; i++) {
            denominationBox.addItem(i);
        }
        inputPanel.add(new JLabel("Enter Denomination (1-9):"));
        inputPanel.add(denominationBox);

        submitButton = new JButton("Purchase");
        inputPanel.add(submitButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Message Area
        messageArea = new JTextArea(5, 40);
        messageArea.setEditable(false);
        JScrollPane messagePane = new JScrollPane(messageArea);
        add(messagePane, BorderLayout.NORTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int slotNumber = (int) itemNumberBox.getSelectedItem() - 1; // Adjust to zero-based index
                int paymentDenomination = (int) denominationBox.getSelectedItem();

                if (vendingMachine.processTransaction(slotNumber, paymentDenomination)) {
                    messageArea.setText("Transaction completed successfully.");
                } else {
                    messageArea.setText("Transaction failed.");
                }
            }
        });

        setVisible(true);
    }
}
