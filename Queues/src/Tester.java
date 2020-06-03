public class Tester {
	public static void main(String[] args) {
		LLQueue queue = new LLQueue();
		for (int k = 1; k <= 5; k++)
			queue.offer(new Integer(k));
		LLQueue queue2 = new LLQueue();
		for (int k = 11; k <= 15; k++)
			queue2.offer(new Integer(k));
		LLQueue queue3 = new LLQueue();
		for (int k = 21; k <= 27; k++)
			queue3.offer(new Integer(k));
		queue.append(queue3);
		System.out.println(queue);
		while (!(queue.empty())) {
			System.out.print(queue.poll() + " ");
		}
		LLQueue queue4 = queue3.alternate(queue2);
		System.out.println("Alternate");
		System.out.println(queue4);
		LLQueue queue5 = queue3.alternate(queue2);
		System.out.println("Alternate");
		System.out.println(queue4);
	}
}
