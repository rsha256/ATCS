package histo;

import java.util.*;

public class HistoList {
    private HistoNode front;

    public HistoList() {
        front = null;
    }

    public void addLetter(char let) {
        if (front == null) {
            front = new HistoNode(let, 1, null);
            return;
        }

        boolean flag = false;
        HistoNode tmp = front;

        while (tmp != null) {
            if (tmp.getLetter() == let) {
                flag = true;
                tmp.setLetterCount(tmp.getLetterCount() + 1);
            }
            tmp = tmp.getNext();
        }

        if (!flag) {
            front = new HistoNode(let, 1, front);
        }

    }

    public void remove(char let) {
        HistoNode tmp = front;
        HistoNode tmp2 = null;

        while (tmp != null) {
            if (tmp.getLetter() == let) {
                int count = tmp.getLetterCount();
                if (count > 1) {
                    tmp.setLetterCount(count - 1);
                } else if (tmp2 == null) {
                    front = front.getNext();
                } else {
                    tmp2.setNext(tmp.getNext());
                }
                return;
            }
            tmp2 = tmp;
            tmp = tmp.getNext();
        }
    }

    // returns a string will all values from list
    public String toString() {
        HistoNode tmp = front;
        String output = "";

        while (tmp != null) {
            output += tmp.getLetter() + " - " + tmp.getLetterCount() + "\t";

            tmp = tmp.getNext();
        }

        return output;

    }

}
