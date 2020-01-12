package quadratic;

public class OmSort {
	public static void omSort(int[] stuff) {
		for (int j = 1; j < stuff.length; ++j) {
			int val = stuff[j];
			while (j > 0 && val < stuff[j - 1]) {
				stuff[j] = stuff[j - 1];
				j--;
			}
			stuff[j] = val;
		}
	}

}
