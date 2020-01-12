package implementingStacks;

import java.util.LinkedList;

public class LinkedListStack {
	
	LinkedList<Object> myStack = new LinkedList<>();

	public LinkedListStack() {
		
	}

	public Object push(Object item) {
		myStack.add(item);
		return item;
	}

	// removes and returns last object on stack(arraylist)
	public Object pop() {
		Object tmp = myStack.get(myStack.size() - 1);
		myStack.remove(myStack.size() - 1);
		return tmp;
	}

	public Object peek() {
		return myStack.get(myStack.size() - 1);
	}

	public boolean isEmpty() {
		return myStack.size() == 0;
	}

	public int size() {
		return myStack.size();
	}

	public int search(Object a) {
		int pos = myStack.indexOf(a);
		if (pos == -1)
			return -1;
		return myStack.size() - pos;
	}

	@Override
	public String toString() {
		String t = "";
		for (Object object : myStack) {
			t += object + " ";
		}
		return t;
	}
	
}
