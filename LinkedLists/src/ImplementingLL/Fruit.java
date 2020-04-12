package ImplementingLL;

public class Fruit {

	LinkedList bowl;

	public Fruit() {
		bowl = new LinkedList();
		bowl.addFirst("watermelon");
		bowl.addFirst("strawberry");
		bowl.addFirst("papaya");
		bowl.addFirst("orange");
		bowl.addFirst("lemon");
		bowl.addFirst("cherry");
		bowl.addFirst("banana");
		bowl.addFirst("apple");
	}

	public void displayFruit() {
	
			ListIterator iter  = bowl.listIterator(); // Object creates another object.
			while(iter.hasNext())
				System.out.println(iter.next());
		
	}

	public void displayFruit3() {
		ListIterator iter = bowl.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public void displayEveryOtherFruit() {
		ListIterator iter = bowl.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			if (iter.hasNext())
				iter.next();
		}
	}

	public void removeEveryOtherFruit() {
		ListIterator iter = bowl.listIterator();
		while (iter.hasNext()) {
			iter.next();
			if (iter.hasNext())
				iter.next();
			iter.remove();
		}
	}

	public void removeEveryOtherFruit2() {
		ListIterator iter = bowl.listIterator();
		while (iter.hasNext()) {
			iter.next();
			iter.remove();
			if (iter.hasNext())
				iter.next();
		}
	}

//	needs previous()		
//	public void insert(String s) {
//		ListIterator iter = bowl.listIterator();
//		while (iter.hasNext()) {
//			String x = (String) iter.next();
//			if (x.compareTo(s) > 0) {
//				iter.previous();
//				iter.add(s);
//				break;
//			
//			}
//		}
//	}

	public void rmBeginningLetter(char ch) {
		ListIterator iter = bowl.listIterator();
		while (iter.hasNext()) {
			String x = (String) iter.next();
			if ((x.charAt(0) + "").equals(ch + "")) {
				iter.remove();
				break;
			}
		}
	}

	public String ifExists(String s) {
		ListIterator iter = bowl.listIterator();
		while (iter.hasNext()) {
			String x = (String) iter.next();
			if (x.equals(s)) {
				return "is indeed in the  list";
			}
		}
		return "is not in the list";
	}

	public LinkedList reverse() {
		ListIterator iter = bowl.listIterator();
		LinkedList reverse = new LinkedList();
		ListIterator iter2 = reverse.listIterator();
		while (iter.hasNext()) {
			String x = (String) iter.next();
			iter2.add(x);
		}
		return reverse;
	}

	public static void main(String[] args) {
		Fruit one = new Fruit();
		one.displayFruit();
		one.rmBeginningLetter('p');
		one.displayFruit();

		System.out.println(one.ifExists("papaya"));
//		System.out.println(one.reverse());
//		one.displayFruit();

	}
}
