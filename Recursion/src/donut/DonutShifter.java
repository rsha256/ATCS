package donut;

public class DonutShifter {

	static int count = 0;

	public static String moveDonut(int numDonuts, int start, int end) {
		return moveDonutH(numDonuts, start, end);
	}

	public static String moveDonutH(int nDonuts, int start, int end) {
		int helpPeg;
		String Sol1, Sol2, MyStep, mySol; 

		count++;
		
		if (nDonuts == 1) {
			return start + " -> " + end + "\n";
		} else {
			helpPeg = 6 - start - end;
			Sol1 = moveDonutH(nDonuts - 1, start, helpPeg);

			MyStep = start + " -> " + end + "\n";

			Sol2 = moveDonutH(nDonuts - 1, helpPeg, end);

			mySol = Sol1 + MyStep + Sol2;
			return mySol;

		}
	}

}
