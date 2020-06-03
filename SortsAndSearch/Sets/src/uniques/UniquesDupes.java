package uniques;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes {
	public static Set<String> getUniques(String input) {
		String[] words = input.split(" ");
		Set<String> uniques = new TreeSet<String>(Arrays.asList(words));

		return uniques;
	}

	public static Set<String> getDupes(String input) {
		String[] words = input.split(" ");

		Set<String> uniques = new TreeSet<String>(Arrays.asList(words));
		Set<String> tmp = new TreeSet<String>();

		for (String x : words) {
				if (uniques.contains(x)) {
					Iterator<String> itr = uniques.iterator();
					while (itr.hasNext() && uniques.contains(x)) {
						itr.next();
						uniques.remove(x);
					}
				} else {
					tmp.add(x);
				}
		}

		return tmp;
	}

	public static String print(Set<String> s) {
		String t = "[";
		for (String w : s) {
			t += w + ", ";
		}
		return t.substring(0, t.length() - 2) + "]";
	}

}
