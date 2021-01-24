/**
 * CashRegister
 *
 * An instance of this class holds the key ata for a cash register, and provides public methods for managing
 * that data
 *
 * @author Michael Sammels
 * @version 25.03.2019
 */
public class CashRegister {
    /**
     * A cash register that tracks the item count and the total amount due, both initially 0
     */
    private int itemCount = 0;
    private double totalPrice = 0;

    /**
     * Adds an item to this cash register
     * @param price the price of this item
     */
    public void addItem(double price) {
        itemCount++;
        totalPrice = totalPrice + price;
    }

    /**
     * Displays the total amount of items
     * @return the total amount of items
     */
    public int getCount() {
        return itemCount;
    }

    /**
     * Adds multiple items to this cash register
     * @param price the price of a single item
     * @param number the number of items to be added
     */
    public void addMultipleItems(double price, int number) {
        itemCount = itemCount + number;
        totalPrice = totalPrice + price * number;
    }

    /**
     * Gets the price of all items in the current sale
     * @return the total amount
     */
    public double getTotal() {
        return totalPrice;
    }

    /**
     * Clear the values
     */
    public void clearValues() {
        itemCount = 0;
        totalPrice = 0;
    }
}