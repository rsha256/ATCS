package hashPhone;

public class PhoneEntry {
    String name;
    String phNumb;

    public PhoneEntry(String name, String phNumb) {
        this.name = name;
        this.phNumb = phNumb;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.phNumb;
    }
}
