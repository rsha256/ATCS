package pd1;

public class MyList {

    private ListNode front;

    public MyList() {
        front = null;
    }

    public MyList(ListNode x) {
        front = x;
    }

    public void addToFront(ListNode sentIn) {
        ListNode temp = new ListNode(sentIn.getValue(), front);
        front = temp;
    }

    public void addToEnd(ListNode sentIn) {
        ListNode temp = front;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(new ListNode(sentIn.getValue(), null));
    }

    // Remove last node
    public void removeLastNode() {
        if (front == null) {
            System.out.println("list is empty");
            return;
        }
        if (front.getNext() == null) {
            front = null;
            return;
        }

        ListNode temp = front;

        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);

    }

    // Reverse the linked list
    public void reverse() {
        MyList one = new MyList();
        ListNode temp = front;
        while (temp != null) {
            one.addToFront(temp);
            temp = temp.getNext();
        }
        front = one.front;
    }

    // Remove consecutive duplicate values
    public void removeConsecutive() {
        MyList one = new MyList();
        ListNode temp = front;
        while (temp.getNext() != null) {
            if (one.notHasNode(temp)) {
                one.addToEnd(temp);
            }
            temp = temp.getNext();
        }
        front = one.front;
    }

    public boolean notHasNode(ListNode x) {
        while (front != null) {
            if (front.equals(x)) {
                return false;
            }
            front = front.getNext();
        }
        return true;
    }

    public void print(ListNode list) {
        System.out.print("[");
        while (list != null) {
            System.out.print(list.getValue() + ", ");
            list = list.getNext();
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        MyList list = new MyList(new ListNode(1, new ListNode(8, new ListNode(3, new ListNode(5,new ListNode(5, new ListNode(6, null)))))));
        list.print(list.front);
        list.removeConsecutive();
        list.print(list.front);
    }

}
