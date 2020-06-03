public class DLinkedList {
	private DListNode firstNode;
	private DListNode lastNode;

	/**
	 * Construct an empty list
	 */
	public DLinkedList() {
		firstNode = null;
		lastNode = null;
	}

	/**
	 * Returns true if the list contains no elements
	 */
	public boolean isEmpty() {
		return firstNode.getValue() == null && lastNode.getValue() == null;
	}

	/**
	 * Inserts the argument as the first element of this list.
	 */
	public void addFirst(Object o) {
		DLinkedList temp = null;
		temp.firstNode.setValue(o);
		temp.firstNode.setNext(firstNode);
		firstNode = temp.firstNode;
	}

	/**
	 * Inserts the argument as the last element of this list.
	 * 
	 */
	public void addLast(Object o) {
		DListNode temp = lastNode;
		lastNode.setValue(o);
		lastNode.setNext(temp);
	}

	/**
	 * Removes and returns the first element of this list.
	 */
	public Object removeFirst() {
		DListNode f = firstNode;
		DListNode temp = firstNode;
		DLinkedList tList = null;
		tList.firstNode.setValue(temp.getNext());
		firstNode = tList.firstNode;
		return (Object)f;
	}

	/**
	 * Removes and returns the last element of this list.
	 */
	public Object removeLast() {
		DListNode l = lastNode;
		lastNode = lastNode.getPrevious();
		return l;
	}

	/**
	 * Returns a String representation of the list.
	 */
	public String toString() {
		String tmp = "";
		DListNode f = firstNode;
		DListNode l = lastNode;

		while (f != null) {
			tmp += f.getValue();
			f = f.getNext();
		}

		return tmp;
	}

	/**
	 * Returns the number of elements in the list as an int.
	 */
	public int size() {
		int c = 0;
		while (firstNode != null && lastNode != null) {
			c++;
		}
		return c;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	private void clear() {
		firstNode = null;
		lastNode = null;
	}

	/**
	 * Returns a DListIterator.
	 */
	public DListIterator iterator() {
		return new DListIterator(this);
	}
	
	public void setLastNode(DLinkedList l) {
		lastNode.setNext(l.firstNode);
		lastNode = l.lastNode;
	}
	
}
