package treeProject5;

import static java.lang.System.*;

public class HistoTreeRunner {
    public static void main(String[] args) {
        HistoTree test = new HistoTree();
        test.addData('A');
        test.addData('A');
        test.addData('A');
        test.addData('A');
        test.addData('B');
        test.addData('V');
        test.addData('S');
        test.addData('E');
        test.addData('A');
        test.addData('S');
        test.addData('A');
        test.addData('A');
        test.addData('V');
        test.addData('S');
        test.addData('E');
        test.addData('A');
        System.out.println(test);

        out.println("A - " + test.search('A').getDataCount());
        out.println("B - " +
                test.
                        search('B').
                        getDataCount());
        out.println("E - " + test.search('E').getDataCount());
        out.println("S - " + test.search('S').getDataCount());
        out.println("V - " + test.search('V').getDataCount() + "\n");

        test = new HistoTree();
        test.addData(1);
        test.addData(2);
        test.addData(3);
        test.addData(11);
        test.addData(22);
        test.addData(32);
        test.addData(1);
        test.addData(22);
        test.addData(13);
        System.out.println(test);

        out.println("1 - " + test.search(1).getDataCount());
        out.println("2 - " + test.search(2).getDataCount());
        out.println("3 - " + test.search(3).getDataCount());
        out.println("11 - " + test.search(11).getDataCount());
        out.println("13 - " + test.search(13).getDataCount());
        out.println("22 - " + test.search(22).getDataCount());
        out.println("32 - " + test.search(32).getDataCount() + "\n");

        test = new HistoTree();
        test.addData("abc");
        test.addData("ead");
        test.addData("xyz");
        test.addData("xyz");
        test.addData("abc");
        test.addData("ead");
        test.addData("abc");
        test.addData("2342");
        test.addData("x2y2z");
        System.out.println(test);

        out.println("2342 - " + test.search("2342").getDataCount());
        out.println("abc - " + test.search("abc").getDataCount());
        out.println("ead - " + test.search("ead").getDataCount());
        out.println("x2y2z - " + test.search("x2y2z").getDataCount());
        out.println("xyz - " + test.search("xyz").getDataCount());

        /*
         Sample Output :
         A - 8    B - 1   E - 2   S - 3       V - 2
         1 - 2    2 - 1   3 - 1   11 - 1      13 - 1  22 - 2  32 - 1
         2342 - 1 abc - 3 ead - 2 x2y2z - 1   xyz - 2
         */
    }
}
