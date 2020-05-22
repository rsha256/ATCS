package hashPhone;

public class Node {
    PhoneEntry obj;
    Node next;

    public Node() {
        obj = new PhoneEntry("", "");
        next = null;
    }

    public Node(PhoneEntry obj, Node next) {
        this.obj = obj;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node clone = this;
        while (clone != null) {
            output.append(clone.obj).append(" ");
            clone = clone.next;
        }
        return output.toString();
    }
}
