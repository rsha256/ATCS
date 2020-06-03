package orderOfOperations;

import java.util.Stack;
import java.util.Scanner;

public class Runner {

	private String input;
	private Stack<Double> numbers;
	private Stack<String> operators;
	private String expression;
	private String[] exp;
	private int position;

	public Runner() {
		input = "";
	}

	public Runner(String in) {
		expression = in;
		exp = expression.split(" ");
		numbers = new Stack<Double>();
		operators = new Stack<String>();
		position = 0;

	}

	public String getExpression() {
		return expression;
	}

	public double evaluate(String in) {
		expression = in;
		exp = expression.split(" ");
		numbers = new Stack<Double>();
		operators = new Stack<String>();
		position = 0;
		return evaluate();
	}

	public double evaluate() {
		for (int x = 0; x < expression.length(); x++) {
			int space = expression.indexOf(" ", x);
			String a = expression.substring(x, space);
			x = space;
			position = space++;

			switch (a) {
			case "(":
				Runner temp = new Runner(expression.substring(x + 1));
				numbers.push(temp.evaluate());
				x += temp.position + 1;
				break;
			case ")":
				while (numbers.size() > 1)
					calculate();
				return numbers.pop();
			case "^":
				if (operators.isEmpty())
					operators.push(a);
				else {
					while (!operators.isEmpty() && (operators.peek().equals("^")))
						calculate();
					operators.push(a);
				}
				break;
			case "*":
			case "/":
				if (operators.isEmpty())
					operators.push(a);
				else {
					while (!operators.isEmpty() && (operators.peek().equals("^") || operators.peek().equals("*")
							|| operators.peek().equals("/")))
						calculate();
					operators.push(a);
				}
				break;
			case "+":
			case "-":
				if (operators.isEmpty())
					operators.push(a);
				else {
					while (!operators.isEmpty())
						calculate();
					operators.push(a);
				}
				break;
			default:
				numbers.push(Double.parseDouble(a));
			}
		}

		while (numbers.size() > 1)
			calculate();

		return numbers.pop();
	}

	private void calculate() {
		double secondNumber = numbers.pop();
		double firstNumber = numbers.pop();
		switch (operators.pop()) {
		case "^":
			double a1 = Math.pow(firstNumber, secondNumber);
			numbers.push(a1);
			break;
		case "*":
			double a2 = firstNumber * secondNumber;
			numbers.push(a2);
			break;
		case "/":
			double a3 = firstNumber / secondNumber;
			numbers.push(a3);
			break;
		case "+":
			double a4 = firstNumber + secondNumber;
			numbers.push(a4);
			break;
		case "-":
			double a5 = firstNumber - secondNumber;
			numbers.push(a5);
			break;
		}

	}

	public static void main(String[] args) {
		System.out.println("Please input an expression: ");
		Scanner i = new Scanner(System.in);
		String t = i.nextLine();
		while (!t.toLowerCase().trim().equals("exit")) {
			Runner one = new Runner();
			System.out.println(one.evaluate(t));
			

			System.out.println("Input another expression: ");
			t = "";
			t = i.nextLine();
		}

//		3 + 4 
//		3 * 4 + 5 
//		3 + 4 * 5 
//		3 * ( 4 + 5 ) 
	}

}