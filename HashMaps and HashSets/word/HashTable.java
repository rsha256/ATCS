package word;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.IntStream;

public class HashTable {
    private LinkedList[] table;

    public HashTable() {
        //this could be your default, but I'd prefer an overloaded constructor
        // also, this only initializes the table of linked lists - you'll also need to initialize each linked list before adding to them!
        table = new LinkedList[10];
        IntStream.range(0, table.length).forEach(i -> table[i] = new LinkedList()); // yee fancy java syntax
    }

    public HashTable(LinkedList a) {
        table = new LinkedList[10];
        for (int i = 0; i < table.length; i++)
            table[i] = a;
    }

    public HashTable(LinkedList[] i) {
        table = i;
    }

    public void add(Object obj) {
        //because you are bringing in a object, you'll need to cast it to the object type you are working with before comparing it
        //using the object's hashcode, insert it into the linked list at the proper position in the table
        //as long as it doesn't already exist in that linked list
        int hc = ((Word) obj).hashCode();
        boolean t = true;
        for (LinkedList x : table) {
            for (Object a : x) {
                if (a.hashCode() == obj.hashCode() && a.toString().equals(obj.toString())) {
                    t = false;
                }
            }
        }
        if (t)
            table[hc].add(obj);
    }

    public String toString() {
        StringBuilder output = new StringBuilder("HASHTABLE\n");
        // begin with the accumulator provided above - make the printout look the same
        // as the document example
        for (int i = 0; i < table.length; i++) {
            output.append("bucket ").append(i).append(" ");
            for (Object o : table[i])
                output.append(o).append(" ");
            output.append("\n");
        }
        return output.toString();
    }
}
