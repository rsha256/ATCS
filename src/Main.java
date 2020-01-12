import java.util.*;
public class Main {

    public static void reverse(Stack<String> words){
        Stack<String> temp = new Stack <String>();
        System.out.println(words);
        while(!words.isEmpty())
            temp.push(words.pop());
        words = temp;
    }

    public static void main(String[] args) {
        Stack<String> t = new Stack <String>();
        t.push("Memes");
        t.push("Yeah");
        reverse(t);
}
