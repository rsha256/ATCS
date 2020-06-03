package mathSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MathSet {
	private MySet one;
	private MySet two;

	public MathSet() {
		one = new MySet("");
		two = new MySet("");
	}

	public MathSet(String o, String t) {
		one = new MySet(o);
		two = new MySet(t);
	}

	public MySet union() {
		Set<Object> a = new HashSet<Object>();
		a.add(one.toString());
		a.add(two.toString());
		return new MySet(a.toString());
	}

	public MySet intersection() {
		HashSet<Object> in = new HashSet<Object>();
		in.add(one);
		in.retainAll((Collection<Object>) two);
		MySet in2 = new MySet();
		in2.add(in);
		return in2;
	}

	public MySet differenceAMinusB() {
		HashSet d = new HashSet();
		d.add(one);
		d.removeAll((Collection<Object>)two);
		MySet d2 = new MySet();
		d2.add(d);
		return d2;
	}

	public MySet differenceBMinusA() {
		HashSet diff = new HashSet();
		diff.add(two);
		diff.removeAll((Collection<Object>)one);
		MySet diff2 = new MySet();
		diff2.add(diff);
		return diff2;
	}

	public MySet symmetricDifference() {
		HashSet s = new HashSet();

		for (Object i : one.toArray()) {
			if (!two.contains(i)) {
				s.add(i);
			}
		}
		
		for (Object i : two.toArray()) {
			if (!one.contains(i)) {
				s.add(i);
			}
		}

		MySet s2 = new MySet();
		s2.add(s);
		
		return s2;
	}

	public String toString() {
		return "Set one " + one + "\n" + "Set two " + two + "\n";
	}
}
