import java.util.Iterator;
import java.util.Stack;

public class CDStack {

	Stack<String> myStack;

	public CDStack() {
		myStack = new Stack<String>();
		myStack.push("Journey");
		myStack.push("Iggy Pop");
		myStack.push("Hall & Oats");
		myStack.push("Genesis");
		myStack.push("Foreigner");
		myStack.push("Eagles");
		myStack.push("Deep Purple");
		myStack.push("Cheap Trick");
		myStack.push("Beatles");
		myStack.push("Aerosmith");
	}

	public CDStack(String one, String two, String three) {
		myStack = new Stack<String>();
		
		myStack.push(one);
		myStack.push(two);
		myStack.push(three);
	}
	
	public void printCDs() {
		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
	}

	public void printCDs2() {
		for (String x : myStack) {
			System.out.println(x);
		}
	}

	public void printCDs3() {
		Iterator<String> iter = myStack.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public void printRecursive() {
		System.out.println(myStack.pop()+"");
		if(!myStack.isEmpty()) {
			printRecursive();
		}
	}
	
	public void reverseStack() {
		Stack<String> temp = new Stack<String>();
		while (!myStack.isEmpty()) {
			temp.push(myStack.pop());
		}
		myStack = temp;
	}
	
	public void combineStacks(CDStack other) {
		other.reverseStack();
		while (other.myStack.isEmpty()) {
			this.myStack.push(other.myStack.pop());
		}
	}
	
	public int bin(int x) {
		Stack<Integer> temp = new Stack<Integer>();

		if (x%2==0) {
			temp.push(0);
		}
		if (x%2==1) {
			temp.push(1);
		}
				
		Stack<Integer> temp2 = new Stack<Integer>();
		while (!temp.isEmpty()) {
			temp2.push(temp.pop());
		}
		temp = temp2;
		
		String x2 = "";
		
		for (int integer : temp) {
			x2+=integer;
		}
		int a = Integer.parseInt(x2);
		return a;
		
	}
	
	public static Stack<String> combine(Stack<String> one, Stack<String> two) {
		Stack<String> temp = new Stack<String>();
		int t = two.size();

		
		while (!one.isEmpty() && !two.isEmpty()) {
			temp.push(one.pop());
			temp.push(two.pop());
			for (String x : temp) {
				System.out.println(x);
			}
		}

		while (!one.isEmpty()) {
			temp.push(one.pop());
		}

		while (!two.isEmpty()) {
			temp.push(two.pop());
		}

		return temp;
	}
	
	public static void main(String[] args) {
		CDStack one = new CDStack();
//
//		one.reverseStack();
//		one.printRecursive();
//		one.printCDs2();

		CDStack two = new CDStack("CookiesRFun", "BartGoesToSchool" , "Älphabet");
		one.combineStacks(two);
		one.printRecursive();
		
		System.out.println(one.bin(201));

	}
}
