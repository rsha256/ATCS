package worksheets;

import java.util.Stack;
import static java.lang.System.*;

public class StackTest {
	private Stack<String> stack;

	public StackTest() {
		setStack("");
	}

	public StackTest(String line) {
		stack = new Stack<String>();
		stack.push(line);
	}

	public void setStack(String line) {
		stack = new Stack<String>();
		stack.push(line);
	}

	public void popEmAll() {
		stack = new Stack<String>();

	}

	// add a toString
	@Override
	public String toString() {
		String tmp = "";
		for (String x : stack) {
			tmp += x;
		}
		return tmp;
	}
}