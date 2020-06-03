package spanish;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) throws IOException {
		File file = new File("spantoeng.dat");
		Scanner sc = new Scanner(file);
		Map<String, String> myMap = new TreeMap<String, String>();

		String[] a = new String[2];

		while (sc.hasNext()) {
			a = sc.nextLine().split(" ");
			myMap.put(a[0], a[1]);
		}

//		System.out.println(myMap);

		Scanner i = new Scanner(System.in);
		System.out.println("Word you want translated: ");
		String ab = i.nextLine();
		System.out.println(myMap.get(ab));
	}
}
