public interface IVendingMachine {
    String refillItem(int slotNumber, int quantity);
    String restockChange(int denominationNumber, int quantity);
    String generateSummary();
    String updateItemPrice(int slotNumber, double newPrice);
    double getTotalSales();
}
