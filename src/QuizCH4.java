import java.util.Scanner;

public class QuizCH4 {

    public static void main(String[] args) {
        int correct = 0;
        String[] q = new String[5];
        String[] choices = new String[5];
        int[] a = new int[5];

        q[0] = "1+1=";
        q[1] = "2+2=";
        q[2] = "3+3=";
        q[3] = "4+4=";
        q[4] = "5+5=";

        choices[0] = "A) 2\nB) 4\nC) 6\nD) 8";
        choices[1] = "A) 1\nB) 4\nC) 6\nD) 8";
        choices[2] = "A) 2\nB) 4\nC) 6\nD) 9";
        choices[3] = "A) 2\nB) 4\nC) 8\nD) 10";
        choices[4] = "A) 2\nB) 4\nC) 6\nD) 10";

        a[0] = 2;
        a[1] = 4;
        a[2] = 6;
        a[3] = 8;
        a[4] = 10;

        Scanner input = new Scanner(System.in);
        int r = (int) (Math.random() * 5);

        System.out.println("Your first question is: " + q[r]);
        System.out.println(choices[r]);
        int ans = input.nextInt();
        if (a[r] == ans) {
            System.out.println("Correct!");
            correct++;
        }
        else {
            System.out.println("Incorrect!");
        }
        q[r]="";

        r = (int) (Math.random() * 5);
        String nextQ = q[r];
        while (q[r].equals("")) {
            r = (int) (Math.random() * 5);
            nextQ = q[r];
        }
        System.out.println("Your second question is: " + nextQ);
        System.out.println(choices[r]);
        int ans2 = input.nextInt();
        if (a[r] == ans2) {
            System.out.println("Correct!");
            correct++;
        }
        else {
            System.out.println("Incorrect!");
        }
        q[r]="";

        r = (int) (Math.random() * 5);
        nextQ = q[r];
        while (q[r].equals("")) {
            r = (int) (Math.random() * 5);
            nextQ = q[r];
        }
        System.out.println("Your third question is: " + nextQ);
        System.out.println(choices[r]);
        int ans3 = input.nextInt();
        if (a[r] == ans3) {
            System.out.println("Correct!");
            correct++;
        }
        else {
            System.out.println("Incorrect!");
        }
        q[r]="";

        r = (int) (Math.random() * 5);
        nextQ = q[r];
        while (q[r].equals("")) {
            r = (int) (Math.random() * 5);
            nextQ = q[r];
        }
        System.out.println("Your fourth question is: " + nextQ);
        System.out.println(choices[r]);
        int ans4 = input.nextInt();
        if (a[r] == ans4) {
            System.out.println("Correct!");
            correct++;
        }
        else {
            System.out.println("Incorrect!");
        }
        q[r]="";

        r = (int) (Math.random() * 5);
        nextQ = q[r];
        while (q[r].equals("")) {
            r = (int) (Math.random() * 5);
            nextQ = q[r];
        }
        System.out.println("Your fifth question is: " + nextQ);
        System.out.println(choices[r]);
        int ans5 = input.nextInt();
        if (a[r] == ans5) {
            System.out.println("Correct!");
            correct++;
        }
        else {
            System.out.println("Incorrect!");
        }
        q[r]="";

        System.out.println("Your score is: " + getScore(correct) + "%");
    }

    public static double getScore(int correct) {
        double numOfQuestions = 5;
        return (correct / numOfQuestions) * 100.0;
    }

}
