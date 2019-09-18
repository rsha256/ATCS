package grid;

import java.util.ArrayList;

public class Grid {

	int a, b;
	String[][] myGrid;

	String[] gGrid;

	int[] x1;
	int[] x2;
	int[] x3;
	int[] x4;
	int[] x5;
	int[] x6;

	int max1 = 0;
	int max2 = 0;
	int max3 = 0;
	int max4 = 0;
	int max5 = 0;
	int max6 = 0;

	public Grid(int a, int b, String[] myGrid) {
		setGrid(a, b, myGrid);
	}

	public void setGrid(int a, int b, String[] grid) {
		this.a = a;
		this.b = b;

		gGrid = grid;

		x1 = new int[grid.length];
		x2 = new int[grid.length];
		x3 = new int[grid.length];
		x4 = new int[grid.length];
		x5 = new int[grid.length];
		x6 = new int[grid.length];

		myGrid = new String[a][b];

		for (int i = 0; i < myGrid.length; i++) {
			for (int j = 0; j < myGrid[0].length; j++) {
				int tmp = ((int) (grid.length * Math.random()));

				myGrid[i][j] = grid[tmp];

			}
		}
	}

	public void findMax(int a, int b) {
//		if (!exists(a, b)) {
//			output();
//			return 0;
//		}
		if (exists(a, b + 1)) {
			int c = 0;
			for (String s : gGrid) {
				if (myGrid[a][b + 1].equals(s)) {
					x1[c] = x1[c] + 1;
				}
				c++;
			}
			findMax(a, b + 1);
		}
		if (exists(a, b - 1)) {
			int c = 0;
			for (String s : gGrid) {
				if (myGrid[a][b - 1].equals(s)) {
					x1[c] = x1[c] + 1;
				}
				c++;
			}
			findMax(a, b + 1);
		}
		if (exists(a + 1, b)) {
			int c = 0;
			for (String s : gGrid) {
				if (myGrid[a + 1][b].equals(s)) {
					x1[c] = x1[c] + 1;
				}
				c++;
			}
			findMax(a, b + 1);
		}
		if (exists(a - 1, b)) {
			int c = 0;
			for (String s : gGrid) {
				if (myGrid[a - 1][b].equals(s)) {
					x1[c] = x1[c] + 1;
				}
				c++;
			}
			findMax(a, b + 1);
		}
		if (a == myGrid.length && b == myGrid[0].length) {
			output();
			System.exit(0);
		}
	}

	public String output() {
		for (String[] string : myGrid) {
			for (String string2 : string) {
				System.out.print(string2 + " ");
			}
			System.out.println();
		}
		System.out.println();

		String r = "";
		int m = 0;

		maxG();

		for (String s : gGrid) {
			r += s + " count == " + m;
		}

		return r;
	}

	public void maxG() {
		for (int i = 0; i < x1.length; i++) {
			if (x1[i] > max1)
				max1 = x1[i];
		}
		for (int i = 0; i < x2.length; i++) {
			if (x2[i] > max2)
				max2 = x2[i];
		}
		for (int i = 0; i < x3.length; i++) {
			if (x3[i] > max3)
				max3 = x3[i];
		}
		for (int i = 0; i < x4.length; i++) {
			if (x4[i] > max4)
				max4 = x4[i];
		}
		for (int i = 0; i < x5.length; i++) {
			if (x5[i] > max5)
				max5 = x5[i];
		}
		for (int i = 0; i < x6.length; i++) {
			if (x6[i] > max6)
				max6 = x6[i];
		}
	}

	public boolean exists(int row, int col) {
		return (row >= 0 && col >= 0) && (row < myGrid.length && col < myGrid[0].length);
	}

}
