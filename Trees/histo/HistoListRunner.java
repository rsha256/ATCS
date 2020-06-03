package histo;

import java.util.*;

public class HistoListRunner {
    public static void main(String[] args) {
        // A A A A B V S E A S A A
        HistoList test = new HistoList();
        test.addLetter('P');
        test.addLetter('A');
        test.addLetter('A');
        test.addLetter('A');
        test.addLetter('A');
        test.addLetter('B');
        test.addLetter('V');
        test.addLetter('S');
        test.addLetter('E');
        test.addLetter('E');
        test.addLetter('A');
        test.addLetter('S');
        test.addLetter('A');
        test.addLetter('A');
        System.out.println(test);

        System.out.println("Call method \"remove('E')\"");
        test.remove('E');

        System.out.println(test);

        System.out.println("Call method \"remove('E')\"");
        test.remove('E');
        System.out.println(test);

        System.out.println("Call method \"remove('S')\"");
        test.remove('S');
        System.out.println(test);

        System.out.println("Call method \"remove('S')\"");
        test.remove('S');
        System.out.println(test);

        System.out.println("Call method \"remove('A')\"");
        test.remove('A');
        System.out.println(test);

        System.out.println("Call method \"remove('P')\"");
        test.remove('P');
        System.out.println(test);

        System.out.println("Call method \"remove('Z')\"");
        test.remove('Z');
        System.out.println(test);

        // A B C
        test = new HistoList();
        test.addLetter('A');
        test.addLetter('B');
        test.addLetter('C');
        System.out.println(test);

        // A B C A B C A B C A B C A B C
        test = new HistoList();
        test.addLetter('A');
        test.addLetter('B');
        test.addLetter('C');
        test.addLetter('A');
        test.addLetter('B');
        test.addLetter('C');
        test.addLetter('A');
        test.addLetter('B');
        test.addLetter('C');
        test.addLetter('A');
        test.addLetter('B');
        test.addLetter('C');
        test.addLetter('A');
        test.addLetter('B');
        test.addLetter('C');
        System.out.println(test);
    }
}
