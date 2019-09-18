package maze;

public class Maze {
	
	
	int xStart = 0;
	int yStart = 0;
		
	public Maze(char[][] m, int i, int j) {
		xStart = i;
		yStart = j;
	}

	public static void main(String args[]) {

		char[][] m = {

				{ '*', ' ', '*', '*', '*', '*', '*', '*', '*' }, { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
				{ '*', ' ', '*', '*', '*', '*', '*', ' ', '*' }, { '*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*' },
				{ '*', ' ', '*', '.', '*', '*', '*', ' ', '*' }, { '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*' },
				{ '*', '*', '*', ' ', '*', ' ', '*', ' ', '*' }, { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*' } };
		Maze maze = new Maze(m, 4, 3);
		maze.display();
		if (maze.findExit())
			System.out.println("There is an exit at (" + maze.getIExit() + ", " + maze.getIExit() + ")");

		else
			System.out.println("No exit was found");
		System.out.println();
		System.out.println();
		maze.display();
		System.out.println("Steps:" + maze.getSteps());
	}

	private boolean findExit() {
		// TODO Auto-generated method stub
		return false;
	}

	private void display() {
		// TODO Auto-generated method stub
		
	}

	private String getIExit() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getSteps() {
		// TODO Auto-generated method stub
		return null;
	}

}
