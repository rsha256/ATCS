package inClassAssessment;

import java.util.Stack;

public class Reverse {

    public static void main(String[] args) {
        Stack<String> x = new Stack<String>();

        x.push("a");
        x.push("b");
        x.push("c");

        System.out.println(x);

        Stack<String> y = new Stack<String>();
        while(!x.isEmpty()) {
            y.push(x.pop());
        }

        x=y;

        System.out.println(x);
    }

}
