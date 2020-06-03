package three_problem_set;

import java.util.Scanner;
import java.util.Stack;

public class StackTest {

	public static void reverseDigits(int n) {
		Stack<Integer> myStack = new Stack<Integer>();

		while (n > 0) {
			myStack.push(n % 10);
			n = n / 10;
		}

		for (Integer x : myStack) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void reverseSentences(String line) {
		String[] words = line.toLowerCase().split("\\.");

		for (String lin : words) {

			Stack<String> myStack = new Stack<String>();
			String[] words2 = lin.trim().split(" ");

			for (String word : words2) {
				myStack.add(word);
			}

			System.out.print(myStack.peek().substring(0, 1).toUpperCase() + myStack.pop().substring(1) + " ");

			while (!myStack.isEmpty()) {
				System.out.print(myStack.pop());
				if (!myStack.isEmpty()) {
					System.out.print(" ");
				} else {
					System.out.print(". ");
				}
			}

		}

		System.out.print("\n");
	}

	public static void driveway() {
		int license;
		Scanner scn = new Scanner(System.in);
		Stack<Integer> driveway = new Stack<Integer>();
		Stack<Integer> street = new Stack<Integer>();
		System.out.println("Positive numbers add a car, negative numbers remove a car, zero stops the simulation.");
		
		do {
			System.out.println("In the driveway, there is: \n" + driveway);
			System.out.println();
			System.out.print("Enter Licence Plate #: ");
			license = scn.nextInt();

			if (driveway.contains(license)) {
				System.out.println("That car is already in the driveway.");
				System.out.println("Please verify that you typed your number in correctly.\n");
				continue;
			}

			if (license > 0) {
				driveway.add(license);
			}

			if (license < 0) {
 				if (!driveway.contains(-license)) {
 					int lTmp = -1 * license; 
					System.out.println("Car with license #" + lTmp + " is not in the stack.");
					continue;
				}

				while (!driveway.isEmpty()) {
					if (driveway.peek() == -license) {
						driveway.pop();
						break;
					} else {
						street.add(driveway.pop());
					}
					System.out.println("In the street, there is: \n" + street);
					System.out.println("In the driveway, there is: \n" + driveway);
					System.out.println();
				}

				while (!street.isEmpty()) {
					driveway.add(street.pop());
					System.out.println("In the street, there is: \n" + street);
					System.out.println("In the driveway, there is: \n" + driveway);
					System.out.println();
				}
			}
		} while (license != 0);

		System.out.println("Simulation ended!");
		scn.close();
	}

	public static void main(String[] args) {
		StackTest one = new StackTest();
		
		reverseDigits(2134);
		reverseDigits(1729);
		System.out.println();
		
		reverseSentences("Mary had a little lamb. Its fleece was white as snow.");
		System.out.println();		
		
		driveway();
	}

}
