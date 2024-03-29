import java.util.ArrayList;

public class DeshmukhShah2 {

	int r = 0, c = 0;
	int x = 0, y = 0;

	String searchFor = "";
	
	String[] myGrid;

	String[][] grid;
	
	int m = 0;

	public DeshmukhShah2(int r, int c, String[] myGrid) {
		setGrid(r, c, myGrid);
	}

	public void setGrid(int x, int y, String[] myGrid) {
		this.r = x;
		this.c = y;

		this.myGrid = myGrid;

		grid = new String[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int tmp = ((int) (myGrid.length * Math.random()));
				
				grid[i][j] = myGrid[tmp];
				
			}
		}
	}

	public void findMaxH(int a, int b) {
		if (exists(a, b + 1)) {
			int c = 0;
			for (String s : myGrid) {
				if (grid[a][b + 1].equals(s)) {
					m++;
				}
				c++;
			}
			findMaxH(a, b + 1);
		}
		if (exists(a, b - 1)) {
			int c = 0;
			for (String s : myGrid) {
				if (grid[a][b - 1].equals(s)) {
					m++;
				}
				c++;
			}
			findMaxH(a, b + 1);
		}
		if (exists(a + 1, b)) {
			int c = 0;
			for (String s : myGrid) {
				if (grid[a + 1][b].equals(s)) {
					m++;
				}
				c++;
			}
			findMaxH(a, b + 1);
		}
		if (exists(a - 1, b)) {
			int c = 0;
			for (String s : myGrid) {
				if (grid[a - 1][b].equals(s)) {
					m++;
				}
				c++;
			}
			findMaxH(a, b + 1);
		}
		if (a == myGrid.length && b == myGrid[0].length()) {
			return;
		}
	}

	public String toString() {
		for (String[] string : grid) {
			for (String string2 : string) {
				System.out.print(string2 + " ");
			}
			System.out.println();
		}
		System.out.println();

		return "";
	}

	public boolean exists(int row, int col) {
		return (row >= 0 && col >= 0) && (row < myGrid.length && col < myGrid[0].length());
	}

	public String findMax(String string) {
		searchFor = string;
		findMaxH(0, 0);
		
		return ""+m;
	}

}
