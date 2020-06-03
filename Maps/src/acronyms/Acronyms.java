package acronyms;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Acronyms
{
	private Map<String, String> acronymTable;

	public Acronyms()
	{
		acronymTable = new HashMap<String, String>();
	}

	
	public Acronyms(Map<String, String> t)
	{
		acronymTable = t;
	}
	
	public void putEntry(String entry)
	{
		String[] tmp = entry.split(" - ");
		acronymTable.put(tmp[0], tmp[1]);
	}

	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output = "";

		while(chop.hasNext()) {
			String tmp = chop.next();
			
			String lookFor = tmp.replaceAll("[\\p{Punct}&&[^']]+", "");
			
			if(acronymTable.containsKey(lookFor)) {
				output += acronymTable.get(lookFor) + " ";
			}
			else {
				output += tmp + " ";
			}
			
		}

		chop.close();
		return output;
	} 

	public String toString()
	{
		return acronymTable.toString();
	}
}
