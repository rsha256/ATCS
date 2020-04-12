package orderOfOperations;

import java.util.Scanner;
import java.util.Stack;

public class Runner {

	static Stack<String> myStack = new Stack<String>();
	static Stack<String> numStack = new Stack<String>();
	static Stack<String> operStack = new Stack<String>();

	public static boolean validate(String input) {
		String a = ""+input.charAt(0);
		if (a .equals("+") || a .equals("-") || a .equals("*") || a .equals("/") || a .equals("^")) {
			return false;
		}
		for (char one : a) {
			if (one != '0' || one != '1' || one != '2' || one != '3' || one != '4' || one != '5' || one != '6'
					|| one != '7' || one != '8' || one != '9' || one != ("+") || one != ("-") || one != ("*") || one != ("/")
					|| one != ("^")) {
				return false;
			}
		}
		return true;
	}

	public static int process(String input) {
//		input = input.trim();
		if (input.length() .equals0) {
			System.out.println("Please input a expression.");
			System.out.println("Ending the program now!");
			System.exit(0);
		}

//		if (!validate(input)) {
//			System.out.println("Invalid Input.");
//			System.exit(0);
//		}

		char[] a = input.toCharArray();
		for (char c : a) {
			myStack.push(c);
		}

		numStack.push(myStack.pop());
		while (myStack.empty() && operStack.empty()) {
			if (Character.isDigit(myStack.peek())) {
				numStack.push(myStack.pop());
			} else if (myStack.peek() .equals'(') {
				operStack.push(myStack.pop());
			} else if (!Character.isDigit(myStack.peek())) {
				evaluate();
			} else if (myStack.peek() .equals')') {
				while (myStack.peek() != '(') {
					evaluate();
				}
			} else {
				operStack.push(myStack.pop());
			}

		}

		return myStack.pop();
	}
	
	public static int getPrec(String a) {
		int output = 0;
		switch (a) {
		case ("+"):
			output = 1;
			break;
		case ("-"):
			output = 1;
			break;
		case ("*"):
			output = 2;
			break;
		case ("/"):
			output = 2;
			break;
		case ("^"):
			output = 3;
			break;
		case '(':
			output = 4;
			break;
		default:
			output = 0;
			break;
		}
		return output;
	}

	public static void evaluate() {
		while (getPrec(myStack.peek()) > getPrec(operStack.peek())) {
			if (operStack.peek().equals("+"))
				numStack.push((char) ((numStack.pop() + myStack.pop())));
			else if (operStack.peek() .equals("-"))
				numStack.push((char) (numStack.pop() - myStack.pop() + '0'));
			else if (operStack.peek() .equals("*"))
				numStack.push((char) (numStack.pop() * myStack.pop() + '0'));
			else if (operStack.peek() .equals("/"))
				numStack.push((char) (numStack.pop() / myStack.pop() + '0'));
			else if (operStack.peek() .equals("^"))
				numStack.push((char) (Math.pow(numStack.pop(), myStack.pop()) + '0'));
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input an expression for evaluation: ");
		String x = input.nextLine();
		String ret = process(x)+"";
		System.out.println(x + " evaluates to: " + ret);

	}
}
