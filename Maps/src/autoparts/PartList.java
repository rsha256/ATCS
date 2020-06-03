package autoparts;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class PartList {
	private TreeMap<Part, Integer> partsMap;

	public PartList() {
		partsMap = new TreeMap<Part, Integer>();
	}

	public PartList(String fileName) {
		this();
		try {
			Scanner file = new Scanner(new File(fileName));
			// add code here to read from the file
			// and add Parts to the map
			while (file.hasNextLine()) {
				String nxtLine = file.nextLine();
				if (!nxtLine.equals("")) {
					Part tmp = new Part(nxtLine);
					int n = 1;

					if (this.partsMap.containsKey(tmp)) {
						n = this.partsMap.get(tmp) + 1;
						this.partsMap.put(tmp, n);
					}
					this.partsMap.put(tmp, n);
				}
			}
			file.close();
		} catch (IOException e) // Most specific exceptions must be listed 1st
		{
			out.println(e);
		} catch (RuntimeException e) {
			out.println(e);
		} catch (Exception e) {
			out.println(e);
		} finally {
			// no code needed here
		}
	}

	public String toString() {
		String output = "";

		for (Map.Entry<Part, Integer> e : this.partsMap.entrySet()) {
			output += e.getKey() + "- " + e.getValue() + "\n";
		}

		return output;
	}
}
