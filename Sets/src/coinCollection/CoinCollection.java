package coinCollection;

public class CoinCollection {

	public static void main(String[] args) {
		Coin one = new Coin(1941, "penny");
		Coin two = new Coin(2010, "dime");
		Coin three = new Coin(2009, "quarter");
		Coin four = new Coin(1954, "nickel");
		Coin five = new Coin(1987, "dime");
		Coin six = new Coin(1949, "penny");
		Coin seven = new Coin(1982, "dime");
		Coin eight = new Coin(1955, "penny");
		Coin nine = new Coin(2002, "quarter");
		Coin ten = new Coin(2008, "quarter");
		Coin eleven = new Coin(1952, "nickel");
		Coin twelve = new Coin(1931, "penny");
		Coin thirteen = new Coin(1989, "dime");
		
		System.out.println("COIN COLLECTION CONTENTS");
		MySet a = new MySet(one);
		a.add(two);
		a.add(three);
		a.add(four);
		a.add(five);
		a.add(six);
		a.add(seven);
		a.add(eight);
		a.add(nine);
		a.add(ten);
		a.add(eleven);
		a.add(twelve);
		a.add(thirteen);

		System.out.println(a.toString());
		
	}

}
