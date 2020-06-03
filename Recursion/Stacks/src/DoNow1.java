import java.util.Stack;

public class DoNow1 {

	public static Stack<String> reverseStack(Stack<String> myStack) {
		Stack<String> temp = new Stack<String>();
		while (!myStack.isEmpty()) {
			temp.push(myStack.pop());
		}
		return temp;
	}
	
	public static Stack<String> combine(Stack<String> one, Stack<String> two) {
		Stack<String> temp = new Stack<String>();
		int t = two.size();

		one = reverseStack(one);
		two = reverseStack(two);

		while (!one.isEmpty() && !two.isEmpty()) {
			temp.push(one.pop());
			temp.push(two.pop());
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
		Stack<String> one = new Stack<>();
		one.push("A");
		one.push("B");
		one.push("C");
		one.push("D");
		one.push("E");
		one.push("F");
		Stack<String> two = new Stack<>();
		two.push("1");
		two.push("2");
		two.push("3");
		two.push("4");

		Stack<String> myStack = combine(one, two);

		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}

	}

}
