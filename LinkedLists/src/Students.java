import java.util.LinkedList;
import java.util.ListIterator;

public class Students {
	public static void main(String[] args) {
		LinkedList<String> roster = new LinkedList<String>();
		roster.addLast("Arjun");
		roster.addLast("Daniel");
		roster.addFirst("Eric");
		roster.add("Fenil");
		roster.add("Michael");
		roster.add("Om");
		roster.remove();
		roster.removeLast();
		
		ListIterator<String> iter = roster.listIterator();
		iter.add("Renny");
		iter.add("Sriyaank");
		System.out.println(roster);
		iter.next();
		iter.next();
		iter.previous();
		iter.next();
		iter.remove();
		System.out.println("done: " + roster);
		
		iter.previous();
		iter.set("Jake");
		System.out.println(roster);
		
	}
}
