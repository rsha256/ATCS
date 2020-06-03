//// Rahul and Aravind
//
//import java.util.*;
//
//public class QueueMethods {
//
//	// Returns a new queue that is the clone of one.
//	public static Queue<String> clone(Queue<String> one) {
//		Queue<String> tmp = new LinkedList<String>();
//		tmp = one;
//		return tmp;
//	}
//
//	// Try a different approach to clone (hint: one is longer, one is short)
//	public static Queue<String> clone2(Queue<String> one) {
//		Queue<String> tmp = new LinkedList<String>();
//		ListIterator<String> iter = ((LinkedList<String>) one).listIterator();
//		while (iter.hasNext())
//			tmp.add(iter.next());
//		return tmp;
//	}
//
//	// Returns a new Queue that is the reverse of one.
//	public static Queue<String> reverse(Queue<String> x) {
//		Queue<String> tmp = new LinkedList<String>();
//		ListIterator<String> iter = ((LinkedList<String>) x).listIterator();
//		Stack<String> stack = new Stack<String>();
//		while (iter.hasNext())
//			stack.push(iter.next());
//
//		while (!stack.isEmpty())
//			tmp.add(stack.pop());
//
//		return tmp;
//	}
//
//	// add Queue y to the end of Queue x. Return the new queue
//	public static Queue<String> append(Queue<String> x, Queue<String> y) {
//		Queue<String> tmp = new LinkedList<String>();
//		Queue<String> xClone = clone2(x);
//		Queue<String> yClone = clone2(y);
//
//		while (!xClone.isEmpty())
//			tmp.offer(xClone.poll());
//		while (!yClone.isEmpty())
//			tmp.offer(yClone.poll());
//
//		return tmp;
//	}
//
//	// Return a new queue with alternating values from one and two
//	public static Queue<String> alternate(Queue<String> one, Queue<String> two) {
//		Queue<String> tmp = new LinkedList<String>();
//		Queue<String> tmp1 = clone2(one);
//		Queue<String> tmp2 = clone2(two);
//
//		while (!tmp1.isEmpty() && !tmp2.isEmpty()) {
//			tmp.add(tmp1.poll());
//			tmp.add(tmp2.poll());
//		}
//		while (!tmp1.isEmpty())
//			tmp.add(tmp1.poll());
//		while (!tmp2.isEmpty())
//			tmp.add(tmp2.poll());
//
//		return tmp;
//	}
//
//	// Determines if a queue of strings is a palindrome. Return True/False
//	public static boolean isPalindrome(Queue<String> x) {
//		ListIterator<String> iter = ((LinkedList<String>) x).listIterator();
//		Queue<String> tmp = clone2(x);
//
//		Stack<String> stack = new Stack<String>();
//		while (iter.hasNext())
//			stack.push(iter.next());
//
//		while (!stack.isEmpty())
//			if (!stack.pop().equals(tmp.poll()))
//				return false;
//		return true;
//	}
//
//	// Try a different approach to palindrome (hint: one is longer, one is short)
//	public static boolean isPalindrome2(Queue<String> x) {
//		return (reverse(x).equals(x));
//	}
//
//	// Determines if a queue of strings are in alphanumeric order. Return True/False
//	public static boolean isAlphabetical(Queue<String> x) {
//		ListIterator<String> iter = ((LinkedList<String>) x).listIterator();
//		String prev = iter.next();
//		while (iter.hasNext()) {
//			String next = iter.next();
//			if (next.compareTo(prev) <= 0)
//				return false;
//			prev = next;
//		}
//		return true;
//	}
//
//	// Calculates the average of a queue of integers.
//	public static double average(Queue<Integer> x) {
//		int amnt = x.size();
//		double cum = 0;
//		for (Integer n : x)
//			cum += n;
//		return cum / amnt;
//	}
//
//	// Determines whether string lookFor is in the Queue lookIn . Return True/False
//	public static boolean search(String lookFor, Queue<String> lookIn) {
//		ListIterator<String> iter = ((LinkedList<String>) lookIn).listIterator();
//		while (iter.hasNext())
//			if (iter.next().equals(lookFor))
//				return true;
//		return false;
//
//	}
//
//	// remove all of the occurrences of lookFor in Queue lookIn
//	public static Queue<String> remove(String lookFor, Queue<String> lookIn) {
//		ListIterator<String> iter = ((LinkedList<String>) lookIn).listIterator();
//		while (iter.hasNext())
//			if (iter.next().equals(lookFor))
//				iter.remove();
//		return lookIn;
//
//	}
//
//	// Remove every other element of one starting with the first
//	public static Queue<String> removeEveryOther(Queue<String> one) {
//		ListIterator<String> iter = ((LinkedList<String>) one).listIterator();
//		while (iter.hasNext()) {
//			iter.next();
//			iter.remove();
//			iter.next();
//		}
//		return one;
//
//	}
//
//	// return a string of the first n binary numbers.... 1 10 11 100 101 110 111
//	// 1000...
//	public static String generateBinary(int n) {
//		String tmp1 = "";
//		String tmp2 = "";
//		String output = "";
//		Queue<String> que = new LinkedList<String>();
//		que.add("1");
//
//		while (n-- > 0) {
//			tmp1 = que.peek();
//			que.remove();
//			output += tmp1 + " ";
//
//			tmp2 = tmp1;
//
//			que.add(tmp1 + "0");
//			que.add(tmp2 + "1");
//		}
//		return output;
//	}
//
//	public static void main(String[] args) {
//
//		Queue<String> one = new LinkedList<String>();
//		one.add("A");
//		one.add("B");
//		one.add("C");
//		one.add("D");
//		one.add("E");
//		one.add("Z");
//		System.out.println("ONE: " + one);
//		System.out.println("REMOVE EVERY OTHER:" + removeEveryOther(one));
//		System.out.println("REVERSE:" + reverse(one));
//		System.out.println("SEARCH for E:" + search("E", one));
//		System.out.println("SEARCH for Q:" + search("Q", one));
//		Queue<String> two = new LinkedList<String>();
//		two.add("1");
//		two.add("2");
//		two.add("2");
//		two.add("1");
//		System.out.println("TWO: " + two);
//		System.out.println("APPEND " + append(one, two));
//		System.out.println("REMOVE 1: " + remove("1", two));
//		System.out.println("TWO: " + two);
//		System.out.println("REMOVE 7: " + remove("7", two));
//		System.out.println("TWO: " + two);
//		System.out.println("COPY: " + clone(one));
//		System.out.println("ALTERNATE: " + alternate(one, two));
//		System.out.println("ONE: " + one);
//		System.out.println("TWO: " + two);
//		System.out.println("ISPALINDROME ONE? " + isPalindrome(one));
//		System.out.println("ISPALINDROME TWO? " + isPalindrome(two));
//		System.out.println("ISALPHABETICAL ONE? " + isAlphabetical(one));
//		System.out.println("ISALPHABETICAL TWO? " + isAlphabetical(two));
//		System.out.println(isPalindrome2(one));
//		System.out.println(reverse(one));
//		System.out.println(one);
//		Queue<Integer> three = new LinkedList<Integer>();
//		three.add(11);
//		three.add(12);
//		three.add(2);
//		three.add(71);
//		System.out.println("AVERAGE: " + average(three));
//		System.out.println("THREE: " + three);
//		System.out.println(generateBinary(16));
//	}
//
//}
