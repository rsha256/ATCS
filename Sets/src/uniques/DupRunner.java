package uniques;

import static java.lang.System.*;
import java.util.*;

public class DupRunner {
	public static void main(String args[]) {
		String a = "a b c d e f g h a b c d e f g h i j k";
		String b = "one two three one two three six seven one two";
		String c = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";

		System.out.println("Original List : " + a);
		System.out.println("Uniques : " + UniquesDupes.print(UniquesDupes.getUniques(a)));
		System.out.println("Dupes : " + UniquesDupes.print(UniquesDupes.getDupes(a))+"\n\n");

		System.out.println("Original List : " + b);
		System.out.println("Uniques : " + UniquesDupes.print(UniquesDupes.getUniques(b)));
		System.out.println("Dupes : " + UniquesDupes.print(UniquesDupes.getDupes(b))+"\n\n");

		System.out.println("Original List : " + c);
		System.out.println("Uniques : " + UniquesDupes.print(UniquesDupes.getUniques(c)));
		System.out.println("Dupes : " + UniquesDupes.print(UniquesDupes.getDupes(c))+"\n\n");

	}
}
