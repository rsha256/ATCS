import java.util.LinkedList;
import java.util.ListIterator;

public class ShahSelvamFruit {

	LinkedList<String> bowl;

	public ShahSelvamFruit() {
		bowl = new LinkedList<String>();
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cherry");
		bowl.addLast("lemon");
		bowl.addLast("orange");
		bowl.addLast("papaya");
		bowl.addLast("strawberry");
		bowl.addLast("watermelon");
	}

	public void displayFruit() {
		System.out.println(bowl);
	}

	public void displayFruit2() {
		for (String t : bowl) {
			System.out.println(t);
		}
	}

	public void displayFruit3() {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public void displayEveryOtherFruit() {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			if (iter.hasNext())
				iter.next();
		}
	}

	public void removeEveryOtherFruit() {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			iter.next();
			if (iter.hasNext())
				iter.next();
			iter.remove();
		}
	}

	public void removeEveryOtherFruit2() {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			iter.next();
			iter.remove();
			if (iter.hasNext())
				iter.next();
		}
	}

	public void displayReverse() {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			iter.next();
		}
		while (iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
	}

	public void insert(String s) {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			String x = iter.next();
			if (x.compareTo(s) > 0) {
				iter.previous();
				iter.add(s);
				break;
			}
		}
	}

	public void rmBeginningLetter(char ch) {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			String x = iter.next();
			if ((x.charAt(0) + "").equals(ch + "")) {
				iter.remove();
				break;
			}
		}
	}

	public String ifExists(String s) {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			String x = iter.next();
			if (x.equals(s)) {
				return "is indeed in the  list";
			}
		}
		return "is not in the list";
	}

	public LinkedList<String> reverse() {
		ListIterator<String> iter = bowl.listIterator();
		LinkedList<String> reverse = new LinkedList<String>();
		while (iter.hasNext()) {
			String x = iter.next();
			reverse.addFirst(x);
		}
		return reverse;
	}

	public static void main(String[] args) {
		ShahSelvamFruit one = new ShahSelvamFruit();
		one.displayFruit();
//		one.rmBeginningLetter('p');
//		System.out.println(one.ifExists("papaya"));
		System.out.println(one.reverse());
//		one.displayFruit();

	}
}
