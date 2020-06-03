package mathSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MySet {

	private ArrayList<Object> lst;

	public MySet() {
		lst = new ArrayList<Object>();
	}

	public MySet(Object one) {
		lst = new ArrayList<Object>();

		if (lst.isEmpty()) {
			lst.add(one);
		}
		if (canAdd(one)) {
			lst.add(one);
		} else {
			System.out.println("" + one + " is alaready in the list");
		}	
	}

	public boolean add(Object one) {
		if (lst.isEmpty()) {
			lst.add(one);
			return true;
		}
		if (canAdd(one)) {
			lst.add(one);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean remove(Object o) {
		return lst.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		for (Object object : c) {
			boolean t = false;
			for (Object object2 : lst) {
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

	public boolean contains(Object o) {
		for (Object e : lst) {
			if (o == null ? e == null : o.equals(e))
				return true;
		}
		return false;
	}

	public Iterator iterator() {
		Iterator myIterator = new Iterator() {

			private Object current;
			private int currentIndex;

			@Override
			public boolean hasNext() {
				return (lst.size() - currentIndex) > 0;
			}

			@Override
			public Object next() {
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
			temp += "" + o;
		}
		return temp; 
	}

	public boolean canAdd(Object a) {
		for (Object tmp : lst) {
			if (a.equals(tmp)) {
				return false;
			}
		}
		return true;
	}

}
