package warmup;

public class WarmupList {
	private ListNode front;

	public WarmupList() {
		front = null;
	}

	public WarmupList(ListNode sentIn) {
		front = sentIn;
	}

	public static void addToFront(ListNode list, int val) {
//		ListNode insert = new ListNode(val, list);
//		list = insert;

		int x = (int) list.getValue();
		list.setValue(val);
		list.setNext(new ListNode(x, list.getNext()));
		System.out.println();
		System.out.println(new WarmupList(list));
	}

	@Override
	public String toString() {
		while (front != null) {
			if (front.getNext() == null)
				System.out.print(front.getValue());
			else
				System.out.print(front.getValue() + ", ");
			front = front.getNext();
		}
		return "\n";
	}

	public static void main(String[] args) {
		ListNode e = new ListNode(5, new ListNode(9, new ListNode(20, new ListNode(30, null))));
		WarmupList three = new WarmupList(e);
		System.out.println("Original: ");
		System.out.print(three);
		WarmupList.addToFront(e, 3);
	}

}
