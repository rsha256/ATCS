package chessComplete;

public class ShahDeshmukh {

	private int[][] grid;
	int x = 0, y = 0;
	private int steps = 0, size;

	public ShahDeshmukh(int i) {
		grid = new int[i][i];
		size = i * i;
	}

	public boolean move(int x, int y) {
		return move(x, y, 1);
	}

	public boolean move(int x, int y, int counter) {
		steps++;
		this.x = x;
		this.y = y;

		if (x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] != 0)
			return false;
		if (counter == size) {
			grid[x][y] = size;
			return true;
		} else if (grid[x][y] != 0) {
			return false;
		} else {
			grid[x][y] = counter;
			if (move(x + 1, y + 2, counter + 1) || move(x + 2, y + 1, counter + 1) || move(x - 2, y + 1, counter + 1)
					|| move(x - 1, y + 2, counter + 1) || move(x - 2, y - 1, counter + 1)
					|| move(x - 1, y - 2, counter + 1) || move(x + 2, y - 1, counter + 1)
					|| move(x + 1, y - 2, counter + 1)) {
				return true;
			} else {
				counter = counter - 1;
				grid[x][y] = 0;
				return false;
			}
		}
	}

	public void displayBoard() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] < 10)
					System.out.print("0" + grid[i][j] + " ");
				else
					System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	public String getSteps() {
		return " " + steps;
	}
}
