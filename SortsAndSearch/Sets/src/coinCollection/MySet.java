package coinCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MySet {

	private ArrayList<Coin> lst;

	public MySet() {
		lst = new ArrayList<Coin>();
	}

	public MySet(Coin one) {
		lst = new ArrayList<Coin>();

		if (lst.isEmpty()) {
			lst.add(one);
		}
		if (canAdd(one) && !containsSame(one)) {
			lst.add(one);
		} else {
			// don't add if already in list
		}

	}

	public boolean add(Coin one) {
		if (lst.isEmpty()) {
			lst.add(one);
			return true;
		}
		if (canAdd(one) && !containsSame(one)) {
			lst.add(one);
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(Coin o) {
		return lst.remove(o);
	}

	public boolean containsAll(Collection<Coin> c) {
		for (Coin object : c) {
			boolean t = false;
			for (Coin object2 : lst) {
				if (object.equals(object2)) {
					t = true;
				}
			}
			if (t == false) {
				return false;
			}
		}
		return true;
	}

	public void clear() {
		lst.clear();
	}

	public int size() {
		return lst.size();
	}

	public boolean isEmpty() {
		return lst.isEmpty();
	}

	public boolean equals(MySet o) {
		return o.toString().equals(lst.toString());
	}

	public boolean contains(Coin o) {
		for (Coin e : lst) {
			if (o == null ? e == null : o.equals(e))
				return true;
		}
		return false;
	}

	public Iterator<Coin> iterator() {
		Iterator<Coin> myIterator = new Iterator<Coin>() {

			private Coin current;
			private int currentIndex;

			@Override
			public boolean hasNext() {
				return (lst.size() - currentIndex) > 0;
			}

			@Override
			public Coin next() {
				int a = lst.indexOf(current);
				return lst.get(a + 1);
			}

		};
		return myIterator;
	}

	public Object[] toArray() {
		return lst.toArray();
	}

	@Override
	public String toString() {
		String temp = "";
		for (Object o : lst) {
			temp += "" + o + "\n";
		}
		return temp;
	}

	public boolean containsSame(Object a) {
		String u = ("" + a).substring(0, Math.min(("" + a).length(), 4));
		int y1 = Integer.valueOf(u);

		String t1 = ("" + a).substring(Math.min(("" + a).length(), 6), (""+ a).length());
				
		for (Coin coin : lst) {
			if ((y1 / 10 == coin.getYr() / 10) && (t1.equals(coin.getCoin()))) {
				return true;
			}
		}
		return false;
	}

	public boolean canAdd(Object a) {
		for (Coin tmp : lst) {
			if (a.equals(tmp)) {
				return false;
			}
		}
		return true;
	}

}
