package histograms;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Histogram
{
	private Map<String, Integer> myMap;

	public Histogram()
	{
		myMap = new TreeMap<String, Integer>();
	}

	public Histogram(String sent)
	{
		this();
		setSentence(sent);
	}
	
	public void setSentence(String sent)
	{
		myMap = new TreeMap<String, Integer>();
		
		Scanner sn = new Scanner(sent);
		while(sn.hasNext()) {
			String nxt = sn.next();
			
			if(myMap.containsKey(nxt)) {
				int value = myMap.get(nxt);
				myMap.put(nxt, value + 1);
			}
			else  {
				myMap.put(nxt, 1);
			}
		}
		sn.close();
	}

	public String toString()
	{
		String output = "";
		String allStars="";
		output += "char\t1---5----01---5\n";
		
		for(Map.Entry<String, Integer> o: myMap.entrySet()) {
			output += o.getKey() + "\t";
			for(int i = 1; i <= o.getValue(); i++) {
				output += "*";
			}
			output += "\n";
		}
		
		return output+"\n\n";
	}
}
