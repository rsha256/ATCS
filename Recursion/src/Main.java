
public class Main {
	public static void main(String[] args) {
		System.out.println(reverseStr("ecksdee"));
	}

	public static String reverseStr(String s) {
		return reverseH(s);
	}

	public static String reverseH(String s) {
		if (s.length()-1 > 0)
			return s.charAt(s.length() - 1) + reverseH(s.substring(0, s.length() - 1));
		else
			return s;
	}

}
