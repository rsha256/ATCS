package pQueue;

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQTester {
	private Queue<String> pQueue;

	public PQTester() {
		setPQ("");
	}

	public PQTester(String list) {
		setPQ(list);
	}

	public void setPQ(String list) {
		pQueue = new PriorityQueue<String>();
		String[] myString = list.split(" ");
		for (String t : myString) {
			pQueue.offer(t);
		}
	}

	public Object getMin() {
		return pQueue.peek();
	}

	public String getNaturalOrder() {

		String output = "";
		while (pQueue.size() > 0) {
			output += " " + pQueue.poll();
		}
		return output;
	}

	// write a toString method
	public String toString() {
		return pQueue.toString();
	}
	
}