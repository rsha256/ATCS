package word;

import java.io.File;
import java.util.Scanner;

import static java.lang.System.out;

public class HashTableRunner
{
    public static void main ( String[] args )
    {
        try{
            //initialize a new hashtable
            HashTable a = new HashTable();

            //read from the dat file using a scanner object
            Scanner input = new Scanner(new File("src/words.dat"));
            //hint: the first number in the file tells you how many integers in your numbers.dat file
            int num = Integer.parseInt(input.nextLine().trim());

            //load stuff into the table using your add method
            for (int i = 0; i < num; i++) {
                Word myWord = new Word(input.nextLine().trim());
                a.add(myWord);
            }

            //print out the table
            System.out.println(a);
        }
        catch(Exception e)
        {
            e.printStackTrace();
//            System.out.println("Houston, we have a problem!");
        }
    }
}
