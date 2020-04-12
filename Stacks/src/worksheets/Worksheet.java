package worksheets;

import static java.lang.System.*;
import java.util.Stack;

public class Worksheet {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.add(67);
		s.add(34);
		s.add(12);
		out.println(s); // outs [67, 34, 12 ]

		out.println(s.pop()); // outs 12

		out.println(s.pop()); // outs 34
	}
}
