import java.util.LinkedList;
import java.util.ListIterator;

public class Worksheet {


    public static void delete(LinkedList staff, String searchFor) {
        ListIterator iter = staff.listIterator();
        while (iter.hasNext()) {
            if(iter.next().equals(searchFor)) {
                iter.remove();
            }
        }
        iter = staff.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    public static void repeat(LinkedList staff) {
        for (int i=0; i<2; i++) {
            ListIterator iter = staff.listIterator();
            while (iter.hasNext())
                System.out.println(iter.next());
        }
    }

    public static void duplicate(LinkedList staff) {
        ListIterator iter = staff.listIterator();
        while (iter.hasNext()) {
            String tmp = ""+iter.next();
            System.out.println(tmp+"\n"+tmp);
        }
    }

    public static void reverse(LinkedList staff) {
        ListIterator iter = staff.listIterator();
        while (iter.hasNext())
            iter.next();
        while (iter.hasPrevious())
            System.out.println(iter.previous());
    }

    public static void main(String[] args) {
        LinkedList staff = new LinkedList();
        ListIterator iterator = staff.listIterator();
        staff.addLast("Jane");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");
        iterator = staff.listIterator();
        iterator.next();
        iterator.next();
        iterator.add("Mary");
        iterator = staff.listIterator();
        iterator.next();
        iterator.remove();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("\n");

        reverse(staff);

        System.out.println("\n");

        duplicate(staff);

        System.out.println("\n");

        repeat(staff);

        System.out.println("\n");
        delete(staff, "Romeo");

    }

}
