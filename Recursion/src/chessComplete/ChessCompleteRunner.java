package chessComplete;

public class ChessCompleteRunner {
	public static void main(String[] args) {
		ChessComplete one = new ChessComplete(5);
		one.move(0, 0);
		one.displayBoard();
		System.out.print("Recursive method call count:");
		System.out.println(one.getSteps());
		System.out.println();
	}
}