package autoparts;

import java.util.Map;

public class Part implements Comparable<Part> {
	private String make, mode, rest;
	private int year;

	public Part(String line) {
		String[] list = line.split(" ");

		rest = "";
		year = Integer.valueOf(list[list.length - 1]);
		mode = list[list.length - 2].trim();
		make = list[list.length - 3].trim();

		for (int i = 0; i < list.length - 3; i++) {
			rest += list[i].trim() + " ";
		}
	}

	// have to have compareTo if implements Comparable
	public int compareTo(Part rhs) {
		if (make.compareTo(rhs.make) == 0) {
			if (mode.compareTo(rhs.mode) == 0) {
				if (year == rhs.year) {
					return rest.compareTo(rhs.rest);
				} else {
					return year - rhs.year;
				}
			} else {
				return mode.compareTo(rhs.mode);
			}
		} else {
			return make.compareTo(rhs.make);
		}
	}

	public boolean equals(Object o) {
		Part tmp = (Part) o;
		return make.equals(tmp.make) && mode.equals(tmp.mode) && rest.equals(tmp.rest) && year == tmp.year;
	}

	public String toString() {
		return make + " " + mode + " " + year + "  " + rest;
	}
}
