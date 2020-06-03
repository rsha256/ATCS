package relatives;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;

public class Relatives {
	private Map<String, Set<String>> map;

	public Relatives() {
		map = new TreeMap<String, Set<String>>();
	}

	public void setPersonRelative(String line) {
		String[] personRelative = line.split(" ");
		if (!map.containsKey(personRelative[0])) {
			map.put(personRelative[0], new TreeSet<String>());
		}

		map.get(personRelative[0]).add(personRelative[1]);
	}

	public String getRelatives(String person) {
		return (map.get(person) != null) ? map.get(person).toString() : "";
	}

	public String toString() {
		String output = "";
		for (Map.Entry<String, Set<String>> o : map.entrySet()) {
			output += o.getKey() + " is related to: " + getRelatives(o.getKey()) + "\n";
		}
		return output;
	}
}
