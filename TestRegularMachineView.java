import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class TestRegularMachineView {
    private JFrame frame;
    private JTextField itemNumberField;
    private JTextField paymentDenominationField;
    private JButton executeButton;
    private JTextArea messageArea;
    private JTable itemTable;
    private DefaultTableModel tableModel;

    public TestRegularMachineView() {
        frame = new JFrame("Test Regular Vending Machine");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(500, 400);

        // Table for displaying item details
        Vector<String> columnNames = new Vector<>();
        columnNames.add("No");
        columnNames.add("Item");
        columnNames.add("Quantity");
        columnNames.add("Price");
        columnNames.add("Calories");

        tableModel = new DefaultTableModel(columnNames, 0);  // 0 indicates no rows initially
        itemTable = new JTable(tableModel);
        updateItemTable(); // Fill the table with data from the Item class

        itemNumberField = new JTextField(10);
        paymentDenominationField = new JTextField(10);
        executeButton = new JButton("Execute Test");
        messageArea = new JTextArea(10, 30);
        messageArea.setEditable(false);

        frame.add(new JScrollPane(itemTable));  // Wrap table in scroll pane
        frame.add(new JLabel("Enter item number:"));
        frame.add(itemNumberField);
        frame.add(new JLabel("Enter payment denomination:"));
        frame.add(paymentDenominationField);
        frame.add(executeButton);
        frame.add(new JScrollPane(messageArea));
    }

    public void updateItemTable() {
        tableModel.setRowCount(0); // Clear the table
        for (int i = 0; i < Item.getItemNames().size(); i++) {
            String itemName = Item.getItemNames().get(i);
            Item item = Item.getItemProperties(itemName);
            Vector<Object> rowData = new Vector<>();
            rowData.add(i + 1);
            rowData.add(itemName);
            rowData.add(item.getQuantity());
            rowData.add("$" + item.getPrice());
            rowData.add(item.getCalories());
            tableModel.addRow(rowData);
        }
    }

    public void showMessage(String message) {
        messageArea.append(message + "\n");
    }

    public String getItemNumber() {
        return itemNumberField.getText();
    }

    public String getPaymentDenomination() {
        return paymentDenominationField.getText();
    }

    public JButton getExecuteButton() {
        return executeButton;
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
}
