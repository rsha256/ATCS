package warehouse;

import java.util.stream.IntStream;

/**
 * Represents an item stored in a warehouse. An item has
 * a name, count, and a price.
 */
public class Item {
    private String name;
    private int count;
    private double price;

    /**
     * When an item is created. It is the initial occurrence
     * The count is set to 1.
     */
    public Item(String theName, double thePrice) {
        name = theName;
        price = thePrice;
        count = 1;
    }

    public void increment() {
        count++;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    /**
     * An items unique barcode is created by adding up the digits of the price
     * That sum is multiplied by the number of characters in the name
     * that product is multiplied by 31
     * for example Item (hat 1.99) (1+9+9) * 3 * 31 ==> 1767
     */
    public int getBarCode() {
        return (1 + String.valueOf(price*100)
                .chars()
                .map(Character::getNumericValue)
                .sum()) * name.length() * 31;
    }
}
