package pd2;

public class MyList {

    private ListNode front;

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

    public void removeMiddle() {
        ListNode temp = front;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        temp = front;
        for (int i = 1; i < count / 2; i++) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());

//        front = temp;
    }

    // rev mid
    public void reverseMiddle() {
        ListNode tmp = front.getNext();
        MyList tmp2 = new MyList(tmp);
        while (tmp.getNext().getNext() != null) {
            tmp = tmp.getNext();
            tmp2.addToFront(tmp);
        }
    }

    // duplicate
    public void duplicate() {
        int c = 1;
        ListNode tmp = front;
        while (tmp.getNext() != null) {
            c++;
            tmp = tmp.getNext();
        }

        ListNode tmp1 = front;
        ListNode tmp2 = front;
        Comparable a;
        int counter = 1;
        while (tmp1.getNext() != null && counter < c + 1) {
            counter++;
            a = tmp1.getValue();
            while (tmp2.getNext() != null) {
                tmp2 = tmp2.getNext();
            }
            tmp2.setNext(new ListNode(a, null));
            tmp2 = front;
            tmp1 = tmp1.getNext();
        }

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
        MyList list = new MyList(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(3, new ListNode(5, new ListNode(5, new ListNode(6, new ListNode(7, null))))))))));
        list.print(list.front);
//       list.reverseMiddle();
//        list.print(list.front);
        list.duplicate();
        list.print(list.front);

    }
}
