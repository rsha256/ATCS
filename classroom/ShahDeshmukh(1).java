package maze;

public class ShahDeshmukh {

	int i = 0, j = 0, steps = 0;
	int xStart = 0;
	int yStart = 0;
	private char[][] array;

	public ShahDeshmukh(char[][] m, int i, int j) {
		xStart = i;
		yStart = j;
		array = m;
	}

	public static void main(String args[]) {

		char[][] m = {

				{ '*', ' ', '*', '*', '*', '*', '*', '*', '*' }, { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
				{ '*', ' ', '*', '*', '*', '*', '*', ' ', '*' }, { '*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*' },
				{ '*', ' ', '*', '.', '*', '*', '*', ' ', '*' }, { '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*' },
				{ '*', '*', '*', ' ', '*', ' ', '*', ' ', '*' }, { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*' } };
		ShahDeshmukh maze = new ShahDeshmukh(m, 4, 3);
		maze.display();
		if (maze.findExit())
			System.out.println("There is an exit at (" + maze.getIExit() + ", " + maze.getJExit() + ")");

		else
			System.out.println("No exit was found");
		System.out.println();
		System.out.println();
		maze.display();
		System.out.println("Steps:" + maze.getSteps());
	}

	private boolean findExit() {
		return findExit(xStart + 1, yStart) || findExit(xStart - 1, yStart) || findExit(xStart, yStart + 1)
				|| findExit(xStart, yStart - 1);
	}

	private boolean findExit(int r, int c) {
		steps++;
		if (r < 0 || c < 0 || r >= array.length || c >= array[0].length) {
			return false;
		}
		if (array[r][c] == ' ') {
			if (r == 0 || c == 0 || r == array.length - 1 || c == array.length - 1) {
				i = r;
				j = c;
				return true;
			}
			return findExit(r + 1, c) || findExit(r - 1, c) 
					|| findExit(r, c + 1) || findExit(r, c - 1);
		} else {
			return false;
		}
	}
	

	private void display() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	private String getIExit() {
		return i + "";
	}

	private String getJExit() {
		return j + "";
	}

	private String getSteps() {
		return steps + "";
	}

}
