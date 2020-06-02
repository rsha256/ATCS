package treeProject6;

public class ThingCount implements Comparable {
    private int count;
    private Object thing;

    public ThingCount() {}

    public ThingCount(Object thang, int cnt) {
        thing = thang;
        count = cnt;
    }

    public void setThing(Object obj) {
        thing = obj;
    }

    public void setCount(int cnt) {
        count=cnt;
    }

    public Object getThing() {
        return thing;
    }

    public int getCount() {
        return count;
    }

    public boolean equals(Object obj) {
        ThingCount other = (ThingCount) obj;
        return other.getCount()==this.getCount() && this.getThing().equals(other.getThing());
    }

    public int compareTo(Object obj) {
        ThingCount other = (ThingCount) obj;
        if (this.equals(obj))
            return 0;
        if (other.getCount() > this.getCount())
            return -1;
        if (other.getCount() < this.getCount())
            return 1;
        return 0;
    }

    public String toString() {
        return "" + thing + " - " + count;
    }
}
