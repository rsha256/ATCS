package restaurant;

public class Main {

	public static int countOdds(ListNode list) {
		int count = 0;

		while (list != null) {
			if ((Integer)(list.getValue()) % 2 == 1) {
				count++;
			}
			list = list.getNext();
		}
		
		return count;
	}

	public static void main(String[] args) {
		ListNode list = null;
		for (int i = 0; i < 4; i++) {
			list = new ListNode(i, list);
		}
		
		System.out.println(countOdds(list));
	}
}
