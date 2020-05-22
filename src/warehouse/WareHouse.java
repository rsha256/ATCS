package warehouse;

import java.util.ArrayList;

/**
 * Represents a warehouse where Items are stored in an Array of ArrayLists.
 * Each Arraylist represents an aisle (0-99) of the warehouse
 * Items are added to the correct arrayList based on thir barcode number
 */
public class WareHouse {
    private ArrayList<Item>[] inventory;

    /**
     * creates an Array of 100 empty ArrayLists.
     * Each Arraylist represents an aisle (0-99) of the warehouse
     * <p>
     * for example inventory[47] is an ArrayList of Items
     */
    public WareHouse() {
        inventory = new ArrayList[100];
        for (int i = 0; i < inventory.length; i++)
            inventory[i] = new ArrayList<Item>();
    }

    /**
     * This method adds the item to the correct aisle (ArrayList) in the warehouse
     * The aisle is found by getting the last 2 digits of the barcode
     * if the item is not in the aisle add it to the end of the aisle
     * if the item already exists in the aisle increment the count of the item by 1;
     */
    public void addItem(Item newItem) {

    }

    /**
     * This calculates the total value of the warehouse
     * the sum of price * count of each item stored in the warehouse
     */
    public double totalValue() {
    }

    /**
     * This counts all of the items in a particular aisle x
     */
    public int getAisleCount(int x) {
    }

    /**
     * This displays the aisle number and the count of items for
     * every nonempty aisle
     */
    public void displayAisleCounts() {
    }

    public static void main(String[] args) {
        WareHouse amacron = new WareHouse();
        amacron.addItem(new Item("Hat", 29.99));
        amacron.addItem(new Item("Hat", 29.99));
        amacron.addItem(new Item("Pencil", .99));
        amacron.addItem(new Item("Pencil", .99));
        amacron.addItem(new Item("Pencil", .99));
        amacron.addItem(new Item("Shoes", 49.99));
        System.out.println("Total Value: " + amacron.totalValue());
        amacron.displayAisleCounts();
    }
}
/*
 * Output
 *
 * Total Value: 112.94
 * Aisle Count
 * 5 1
 * 48 3
 * 97 2
 */
