package histograms2;

import static java.lang.System.*;

public class HistogramList2Runner
{
	public static void main(String[] args)
	{
		HistoList test = new HistoList();
		String testString = "ABCDEFABCDEFFEDCBAAAAABBBBBCCCDAAAAAAAEEFFF";
		for(char c : testString.toCharArray())
		{
			test.add(c);
		}
		System.out.println(test);

		//demonstrate bad data check
		test = new HistoList();
		test.add("dog");
		test.add(314);
		test.add(3.14);
		test.add("pi");
		test.add("p");
		test.add(6.9);
		test.add(69);
		test.add(6.9);
		test.add(33);
		test.add("another_string");
		System.out.println(test);
	}
}
