package hashtable;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import static java.lang.System.*;

public class HashTableRunner
{
    public static void main ( String[] args )
    {
        try{
            //initialize a new hashtable
            HashTable a = new HashTable();

            //read from the dat file using a scanner object
            Scanner input = new Scanner(new File("src/numbers.dat"));
            //hint: the first number in the file tells you how many integers in your numbers.dat file
            int num = Integer.parseInt(input.nextLine().trim());

            //load stuff into the table using your add method
            for (int i = 0; i < num; i++) {
                Number myNum = new Number(Integer.valueOf(input.nextLine().trim()));
                a.add(myNum);
            }

            //print out the table
            System.out.println(a);
        }
        catch(Exception e)
        {
            out.println(e);
//            System.out.println("Houston, we have a problem!");
        }
    }
}
