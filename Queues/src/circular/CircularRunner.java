package circular;

public class CircularRunner {
	private int last, front, size;
	private Object[] myArr;

	public CircularRunner(int n) {
		this.myArr = new Object[n];
	}

	public void enqueue(Object myObject) {
		changeSize();
		this.myArr[last] = myObject;
		this.size++;
		this.last++;
		if (this.last == this.myArr.length) {
			this.last = 0;
		}

	}

	public Object dequeue() {
		Object tmp = myArr[this.front];
		this.myArr[this.front] = null;
		this.front++;
		this.size--;
		if (this.front == this.myArr.length) {
			this.front = 0;
		}
		return tmp;
	}

	public void changeSize() {
		if (this.size == this.myArr.length) {
			Object[] temp = new Object[myArr.length * 2 + 1];
			int cnt = 0;

			for (int i = front; i < myArr.length; i++) {
				temp[cnt] = myArr[i];
				cnt++;
			}

			for (int i = 0; i < last; i++) {
				temp[cnt] = myArr[i];
				cnt++;
			}

			front = 0;
			last = cnt;
			myArr = temp;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		for (Object o : this.myArr) {
			out.append(o).append(" ");
		}
		return out.toString();
	}

	public static void main(String[] args) {
		CircularRunner a = new CircularRunner(5);
		System.out.println(a);
		String b = a.isEmpty() ? "It is empty!" : "It is not empty!";
		System.out.println("Is Circular empty?\n" + b);
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);
		System.out.println(a);
		a.enqueue(6);
		a.enqueue(7);
		a.enqueue(8);
		a.enqueue(9);
		System.out.println(a);
		System.out.println("NEXT: " + a.dequeue());
		System.out.println("NEXT: " + a.dequeue());
		System.out.println("NEXT: " + a.dequeue());
		System.out.println(a);
		a.enqueue(10);
		System.out.println(a);
		a.enqueue(11);
		System.out.println(a);
		a.enqueue(12);
		System.out.println(a);
		System.out.println("NEXT: " + a.dequeue());
		System.out.println(a);
		a.enqueue(13);
		System.out.println(a);
		a.enqueue(14);
		System.out.println(a);
		a.enqueue(15);
		System.out.println(a);
		System.out.println("NEXT: " + a.dequeue());
		System.out.println(a);
		a.enqueue(16);
		System.out.println(a);
		a.enqueue(17);
		System.out.println(a);
		b = a.isEmpty() ? "It is empty!" : "It is not empty!";
		System.out.println("Is Circular empty?\n" + b);
	}
}