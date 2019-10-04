package chessComplete;

public class ChessComplete {

	private int[][] grid;
	int x = 0, y = 0;
	private int steps = 0, size;

	public ChessComplete(int i) {
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
		displayBoard();
		if (x < 0 || y < 0 || x >= grid.length || y >= grid.length)
			return false;
		if (counter == size) {
			grid[x][y] = size;
			return true;
		} else if (grid[x][y] != 0) {
			return false;
		} else {
			grid[x][y] = counter;
			return (move(x + 1, y + 2, counter + 1) || move(x + 2, y + 1, counter + 1)
					|| move(x - 2, y + 1, counter + 1) || move(x - 1, y + 2, counter + 1)
					|| move(x - 2, y - 1, counter + 1) || move(x - 1, y - 2, counter + 1)
					|| move(x + 2, y - 1, counter + 1) || move(x + 1, y - 2, counter + 1));
		}
	}

	public void displayBoard() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
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