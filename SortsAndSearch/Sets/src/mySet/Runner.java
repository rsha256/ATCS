package mySet;

public class Runner {
	public static void main(String[] args) {
		Set mySet = new Set();
		Set mySet2 = new Set();
		mySet2.add(1);
		mySet2.add(6);
		mySet.add(1);
		mySet.add(2);
		mySet.add(3);
		System.out.println(mySet);
		mySet.add(3);
		mySet.add(4);
		System.out.println(mySet);
		mySet.remove(2);
		System.out.println(mySet);
		System.out.println(mySet.size());
		System.out.println(mySet.isEmpty());

	}
}
