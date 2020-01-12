import java.util.*;

// Sub-study 01/10/2020
public class SubStudy {

    public static void reverse(Stack<String> words) {
        Stack<String> temp = new Stack<String>();
        System.out.println(words);
        while (!words.isEmpty())
            temp.push(words.pop());
        words = temp;
        System.out.println(words);
    }

    public static void main(String[] args) {
        Stack<String> t = new Stack<String>();
        t.push("Memes");
        t.push("Yeah");
        reverse(t);
    }
}
