package acronyms;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.System.*;

public class AcroRunner {
	public static void main(String args[]) throws IOException {
		File file = new File("acro.dat");
		Scanner sc = new Scanner(file);
		Map<String, String> myMap = new TreeMap<String, String>();

		String[] a = new String[2];

		String rl = "";

		int n = -1;
		int c = 0;

		while (sc.hasNext()) {
			if (n == -1) {
				n = Integer.parseInt(sc.nextLine());
			} else if (c >= n) {
				rl += sc.nextLine();
				c++;
			} else {
				a = sc.nextLine().split("-");
				a[0] = a[0].trim();
				a[1] = a[1].trim();
				myMap.put(a[0], a[1]);
				c++;
			}
		}

		System.out.println("==== MAP CONTENTS ====\n");

		System.out.println(myMap + "\n");

		System.out.println("==== READ LINES ====\n");

//		Scanner sc2 = new Scanner(System.in);
//		String r2 = sc2.nextLine();
		Acronyms a2 = new Acronyms(myMap);
		System.out.println(a2.convert(rl));
	}
}
