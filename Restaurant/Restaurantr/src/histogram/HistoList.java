package histogram;

import java.util.*;

public class HistoList {
	private HistoNode front;

	public HistoList() {
		front = null;
	}

	// addLetter will add a new node to the front for let if let does not exist
	// addLetter will bump up the count if let already exists
	public void addLetter(char let) {
		while (front.getNext() != null) {
			if (front.getLetter() == let) {
				
				return;
			}
		}
		front.setNext(new HistoNode(let, 1, front.getNext()));
	}

	// returns a string will all values from list
	public String toString() {
		String output = "";

		while (front.getNext() != null) {
			output += front.getLetter() + " - " + front.getLetterCount() + "\t";
		}

		return output;
	}
}