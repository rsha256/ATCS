package implementingStacks;

import java.util.ArrayList;

public class ArrayStack {

	Object[] myStack;

	public ArrayStack() {
	}

	public ArrayStack(int i) {
		myStack = new Object[i];
	}

	public Object push(Object item) {
		if (myStack == null || myStack.length == 0) {
			myStack = new Object[1];
			myStack[0] = item;
			return item;
		}

		Object[] tmp = new Object[myStack.length + 1];
		for (int i = 0; i < tmp.length-1; i++) {
			tmp[i] = myStack[i];
		}
		tmp[myStack.length] = item;
		myStack = tmp;
		return item;
	}

	// removes and returns last object on stack(arraylist)
	public Object pop() {
		if (myStack.length == 0) {
			return "nothing to rm";
		}

		Object rThis = myStack[myStack.length - 1];

		Object[] tmp = new Object[myStack.length - 1];

		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = myStack[i];
		}

		myStack = tmp;

		return rThis;
	}

	public Object peek() {
		return myStack[myStack.length - 1];
	}

	public boolean isEmpty() {
		return myStack.length == 0;
	}

	public int size() {
		return myStack.length;
	}

	public int search(Object a) {
		int pos = -1;
		if (myStack == null || myStack.length == 0)
			return -1;

		for (int i = 0; i < myStack.length; i++) {
			if (myStack[i].equals(a)) {
				pos = i;
				break;
			}
		}

		if (pos == -1)
			return -1;

		return myStack.length - pos;
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
