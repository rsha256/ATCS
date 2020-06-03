public class LLQueue {

	private DLinkedList myList;

	public LLQueue() {
		myList = new DLinkedList();
	}

	/**
	 * Adds q to the end of the current queue. Queue q is then cleared.
	 **/
	public void append(LLQueue q) {
		DLinkedList tmp = new DLinkedList();

		while (!q.empty()) {
			tmp.addLast(q.poll());
		}

		myList.setLastNode(tmp);
	}

	/**
	 * Inserts q to the current queue alternately. Queue q is then cleared.
	 **/
	public LLQueue alternate(LLQueue q) {
		return q;
	}

	// Tests if this queue is empty
	public boolean empty() {
		return myList.size() == 0;
	}

	// Inserts the specified element into this queue
	public void offer(int i) {
		myList.addLast(i);
	}

	// Retrieves and removes the head of this queue,
	// or returns null if this queue is empty.
	public String poll() {
		String x = "" + myList.removeFirst();
		return x;
	}

	// Returns a String representation of your queue
	@Override
	public String toString() {
		String t = "";
		while (!myList.isEmpty()) {
			t += "" + myList.removeFirst();
		}
		return super.toString();
	}
}
