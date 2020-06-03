import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) throws IOException {
		Map<String, String> myMap = new TreeMap<String, String>();
		myMap.put("restroom", "bano");
		myMap.put("cat", "gato");
		myMap.put("boy", "muchaco");
		myMap.put("house", "casa");
		myMap.put("toad", "sapo");
		myMap.put("water", "agua");

		//		System.out.println(myMap);
		
		Scanner i = new Scanner(System.in);
		System.out.println("Word you want translated: ");
		String a = i.nextLine();
		System.out.println(myMap.get(a));
	}
}
