package histograms2;

public class ThingCount implements Comparable {
	private int count;
	private Object thing;

	public ThingCount() {
		thing = null;
		count = 0;
	}

	public ThingCount(Object thang, int cnt) {
		thing = thang;
		count = cnt;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int cnt) {
		count = cnt;
	}

	public void setThing(Object obj) {
		thing = obj;
	}

	public Object getThing() {
		return thing;
	}

	public boolean equals(Object obj) {
		ThingCount other = (ThingCount) obj;
		String o = "" + other.getThing();
		String t = "" + thing;
		return (o.equals(t)) && (other.getCount() == count);
	}

	public int compareTo(Object obj) {
		ThingCount other = (ThingCount) obj;
		return other.getCount() - count;
	}

	public String toString() {
		return "" + getThing() + " - " + getCount();
	}
}
