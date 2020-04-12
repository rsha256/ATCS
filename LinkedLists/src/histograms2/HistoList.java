package histograms2;

public class HistoList {
	private ListNode front;

	public HistoList() {
		front = null;
	}

	// ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	// IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj) {
		
		if (front == null) {
			front = new ListNode(new ThingCount(obj, 1), null);
			return;
		}

		ListNode tmp = front;
		boolean flag = false;

		while (tmp != null) {
			if (((ThingCount) tmp.getValue()).getThing().equals(obj)) {
				flag = true;
				((ThingCount) tmp.getValue()).setCount(((ThingCount) tmp.getValue()).getCount() + 1);
			}
			tmp = tmp.getNext();
		}

		if (!flag) {
			front = new ListNode(new ThingCount(obj, 1), front);
		}
		
	}

	

	// RETURNS THE LIST AS A BIG STRING
	public String toString() {
		
		String o = "";

		ListNode tmp = front;
		while (tmp != null) {
			o += tmp.getValue() + " ";
			tmp = tmp.getNext();
			o += "\n";
		}

		return o;

	}
}
