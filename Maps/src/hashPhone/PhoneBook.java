package hashPhone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneBook {

    private Node[] hashMap;

    public PhoneBook() {
        hashMap = new Node[10];
    }

    public PhoneBook(int initialSize) {
        hashMap = new Node[initialSize];
    }

    /**
     * reads data from txt file; constructs PhoneEntry objects, sends them to add method
     **/
    public void load() {
        Scanner in;
        try {
            in = new Scanner(new File("src/hashPhone/phone.txt"));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String name = line.substring(0, line.indexOf("\t"));
                String phoneNumber = line.substring(line.lastIndexOf("\t")+1);
                this.add(new PhoneEntry(name, phoneNumber));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void add(Object obj) {
        while (this.getLoadFactor() > 0.75)
            this.rehash();
        int index = ((PhoneEntry) obj).hashCode() % this.getCapacity();
        if (hashMap[index] == null)
            hashMap[index] = new Node(((PhoneEntry) obj), null);
        else
            hashMap[index].obj = ((PhoneEntry) obj);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.getCapacity(); i++)
            if (hashMap[i] != null)
                output.append("Bucket ").append(i).append(": ").append(hashMap[i]).append("\n");
        return output.toString();
    }

    public int getCapacity() {
        return hashMap.length;
    }

    public int getSize() {
        int c = 0;

        for (Node node : hashMap) {
            if (node != null)
                c += getLength(node);
        }
        return c;
    }

    public int getNumberOfNulls() {
        int numberOfNulls = 0;
        for (Node node : hashMap)
            if (node == null)
                numberOfNulls++;
        return numberOfNulls;
    }

    //    helper method :P
    public int getLength(Node node) {
        int l = 0;
        Node tmp = node;
        while (tmp != null) {
            l++;
            tmp = tmp.next;
        }
        return l;
    }

    public int getLongestList() {
        int longestListLength = 0;
        for (int i = 1; i < hashMap.length; i++)
            if (hashMap[i] != null && getLength(hashMap[i]) > longestListLength)
                longestListLength = getLength(hashMap[i]);
        return longestListLength;
    }

    public String lookup(String lookFor) {
        Node tmp = this.hashMap[lookFor.hashCode() % this.getCapacity()];
        while (tmp != null) {
            PhoneEntry entry = tmp.obj;
            if (entry.name.equalsIgnoreCase(lookFor))
                return entry.phNumb;
            tmp = tmp.next;
        }
        return lookFor + " is not found.";
    }

    public boolean changeNumber(String lookFor, String newNumber) {
        Node clone = hashMap[lookFor.hashCode() % this.getCapacity()];
        while (clone != null) {
            PhoneEntry entry = clone.obj;
            if (entry.name.equalsIgnoreCase(lookFor)) {
                clone.obj.phNumb = newNumber;
                return true;
            }
            clone = clone.next;
        }
        return false;
    }

    /**
     * λ = # of elements / array size
     **/
    public double getLoadFactor() {
        return (getSize() + 0.0) / getCapacity();
    }

    private void rehash() {
        PhoneBook tmp = new PhoneBook(this.getCapacity() * 2);
        for (Node node : hashMap)
            while (node != null) {
                tmp.add(node.obj);
                node = node.next;
            }
        hashMap = tmp.hashMap;
    }
}
