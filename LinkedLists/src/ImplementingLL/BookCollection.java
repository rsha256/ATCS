package ImplementingLL;

public class BookCollection {
	LinkedList books;


	public BookCollection() {
		books = new LinkedList();
		books.addFirst("Goodnight Moon");
		books.addFirst("Bagel Mouse");
		books.addFirst("Charlotte's Web");
		books.addFirst("Brown Bear, Brown Bear");
	}

	public void printBooks() {
		ListIterator iter  = books.listIterator(); // Object creates another object.
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	
	public void tester() {
		ListIterator iter  = books.listIterator(); // Object creates another object.
		iter.next();
		iter.remove();
		iter.next();
		iter.add("Three Blind Mice");
		iter.add("Where the Wild Things Are");
		iter.next();
		iter.set("Green Eggs and Ham");
	}

	public static void main(String[] args) {
		BookCollection one = new BookCollection();
		one.printBooks();
		System.out.println();
//		one.tester();
		one.printBooks();

	}

}