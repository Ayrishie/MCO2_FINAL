public interface ProcessTransaction {
    /**
     * The processTransaction method processes a transaction by checking if the item is available
     * and the payment is sufficient, updating the item quantities and sales, giving change,
     * printing a receipt, and displaying the updated item quantities.
     *
     * @param slot               The slot parameter represents the index of the item in the inventory.
     *                           It is used to retrieve the price and quantity of the item from the
     *                           itemPrices and itemQuantities lists respectively.
     * @param paymentDenomination The paymentDenomination parameter represents the denomination of the
     *                           payment made by the customer. It is an integer value that corresponds
     *                           to the index of the denomination in the denominationValues list.
     * @return The method should return a boolean value indicating whether the transaction was
     *         successful or not.
     * @throws IllegalArgumentException if there is an error with the input parameters.
     */
    boolean processTransaction(int slot, int paymentDenomination) throws IllegalArgumentException;
}
