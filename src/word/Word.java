package word;

public class Word {
    private String theValue;

    //write a constructor method
    public Word() {
        theValue = "";
    }

    public Word(String i) {
        theValue = i;
    }

    //write the getValue method
    public String getValue() {
        return theValue;
    }


    //write the equals method
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //write the hashCode method
    @Override
    public int hashCode() {
        int v = 0;
        int l = theValue.length();
        String t = theValue.toLowerCase().trim();
        for (char c : t.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                v++;
            }
        }
        return (v * l) % 10;
    }


    //write the toString method
    @Override
    public String toString() {
        return getValue();
    }


}
