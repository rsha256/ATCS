public class DListIterator {

	private DListNode current;
	private DListNode previous;
	private DLinkedList myList;
	private boolean canRemove; // for remove() method. true if OK to call

	// remove()

	public DListIterator(DLinkedList list) {
		myList = list;
		current = null;
		previous = null;
		canRemove = false;
	}


	public String toString() {
		String tmp = "";
		DListNode f = current;

		while (f != null) {
			tmp += f.getValue();
			f = f.getNext();
		}

		return tmp;
	}

	public boolean hasPrevious() {
		return previous != null;
	}

	public boolean hasNext() {
		return current.getNext() != null;
	}

	public Object next() {
		return current.getNext();
	}

	public Object previous() {
		return previous;
	}

	public void remove() {

		if (!canRemove) {
			return;
		}

	}

	public DListNode getLast() {
		DListNode x = current;
		while(x.getNext() != null) {
			x=x.getNext();
		}
		return x;
	}

	public void insert(Object element) {
		current.setNext(new DListNode(element, null, current));
	}
	
	public void add(Object element) {
		current.setNext(new DListNode(element, null, getLast()));
	}
	
	public void set(Object element) {
		current.setNext(new DListNode(element, current.getNext(), previous.getNext()));
	}

}
