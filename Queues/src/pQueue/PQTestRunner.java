package pQueue;

//import java.util.PriorityQueue;

public class PQTestRunner {
	public static void main(String[] args) {
		PQTester one = new PQTester("one two three four five six seven");
		System.out.println("toString() - " + one.toString());
		System.out.println("getMin() - " + one.getMin());
		System.out.println("getNaturalOrder() - " + one.getNaturalOrder() + "\n");

		PQTester two = new PQTester("1 2 3 4 5 one two three four five");
		System.out.println("toString() - " + two.toString());
		System.out.println("getMin() - " + two.getMin());
		System.out.println("getNaturalOrder() - " + two.getNaturalOrder() + "\n");

		PQTester three = new PQTester("a p h j e f m c i d k l g n o b");
		System.out.println("toString() - " + three.toString());
		System.out.println("getMin() - " + three.getMin());
		System.out.println("getNaturalOrder() - " + three.getNaturalOrder() + "\n");
		
//		PriorityQueue<Integer> pq;
//		pq = new PriorityQueue<Integer>();
//		pq.add(67);
//		pq.add(34);
//		pq.add(12);
//
//		System.out.println(pq.remove()); //outs 12
//		System.out.println(pq.remove()); //outs 34
//		System.out.println(pq.remove()); //outs 67
	}
}
