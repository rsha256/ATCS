package hashtable;

public class Number {
    private int theValue;

    public Number(int value) {
        //complete your constructor
        theValue = value;
    }

    public int getValue() {
        return theValue;
    }

    public boolean equals(Object obj) {
        //number objects are equal if they contain equal values
        //and remember, your parameter is an object, so casting is necessary before comparison.
        return ((Number) obj).getValue() == this.getValue();
    }

    public int hashCode() {
        // based on the output, and specificially on how bucket indices relate to each number in the bucket,
        // implement sa proper hashcode
        return getValue() % 10;
    }

    public String toString() {
        return "" + this.getValue();
    }
}
