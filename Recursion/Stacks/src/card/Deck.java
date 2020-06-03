package card;

import java.util.Stack;

public class Deck {
	Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
	}

	public Deck(Card one) {
		deck = new Stack<Card>();
		deck.push(one);
	}
	
	public void newCard(Card one) {
		deck.push(one);
	}
	
	public Stack<Card> getDeck() {
		return deck;
	}

	// Load the stack with 52 cards in order
	public void loadDeck() {
		for (int i = 4; i >= 1; i--) {
			for (int j = 14; j >= 2; j--) {
				deck.push(new Card(i, j));
			}
		}
	}

	// Print the stack - for uniformity,
	// make 13 rows in four columns, filling
	// in each row from left to right
	public String toString() {
		String output = "";
		int i = 0;
		Stack<Card> tmp = new Stack<Card>();
		tmp = (Stack<Card>) deck.clone();
		tmp = reverse(tmp);
		for (Card c : tmp) {
			output += c + "\t ";
			i++;
			if (i == 4) {
				output += "\n";
				i = 0;
			}
		}
		return output;
	}

	// Return and remove the top card
	public Card deal() {
		return deck.pop();
	}

	// Take the top half of the deck (26 cards) and alternate card by card with
	// the bottom half
	public void bridgeShuffle() {
		int bp = deck.size() / 2;
		Stack<Card> copy = new Stack<Card>();
		for (int i = 0; i < bp; i++) {
			copy.push(deck.pop());
		}
		copy = reverse(copy);
		Stack<Card> tmp = new Stack<Card>();
		while (!copy.isEmpty()) {
			tmp.push(copy.pop());
			tmp.push(deck.pop());
		}
		deck = reverse(tmp);
	}

	// Split the deck at a random spot. Put the stack of cards above the random
	// spot below the other cards
	public void cut() {
		int split = (int) (Math.random() * 52) + 1;
		Stack<Card> tmp = new Stack<Card>();
		for (int i = 0; i < split; i++) {
			tmp.push(deck.pop());
		}
		
		tmp = reverse(tmp);
		deck = reverse(deck);
		
		while (!deck.isEmpty()) {
			tmp.push(deck.pop());
		}
		
		deck = tmp;
	}

	// Complete a bridge shuffle and then cut the deck. Repeat 7 times
	public void completeShuffle() {
		for (int i = 0; i < 7; i++) {
			bridgeShuffle();
			cut();
		}
	}

	// Reverse the order of the cards in the deck
	private void reverse() {
		deck = reverse(deck);
	}

	// Given a Stack of cards as an explicit parameter,
	// reverse the order of the cards in the deck
	private Stack<Card> reverse(Stack<Card> x) {
		Stack<Card> tmp = new Stack<Card>();
		while (!x.isEmpty()) {
			tmp.push(x.pop());
		}
		return tmp;
	}

	// Combine two decks, one as the implicit
	// parameter, the other as the explicit parameter
	public void combineDecks(Stack<Card> other) {
		other = reverse(other);
		while(!other.isEmpty()) {
			deck.push(other.pop());
		}
	}

	public static void main(String[] args) {
		Deck a = new Deck();
//		System.out.println(a.getDeck() + "\n");
		System.out.print("Display after DECK CONSTRUCTION\n" + a + "\n\n\n");

		a.cut();
		System.out.print("Display after CUT\n" + a + "\n\n\n");

		a.bridgeShuffle();
		System.out.print("Display after BRIDGE SHUFFLE\n" + a + "\n\n\n");

		a.completeShuffle();
		System.out.print("Display after COMPLETE SHUFFLE\n" + a + "\n\n\n");

		a.reverse();
		System.out.print("Display after REVERSE\n" + a + "\n\n\n");

		
		System.out.println("Dealing cards...");
		for (int i = 1; i <= 5; i++)
			System.out.println(a.deal());

	}
}
