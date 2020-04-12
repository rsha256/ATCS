package deckOfCards;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	// Load the stack with 52 cards in order
	public void loadDeck() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 2; j <= 14; j++) {
				deck.push(new Card(i, j));
			}
		}
		}

	// Print the stack - for uniformity,
	// make 13 rows in four columns, filling
	// in each row from left to right
	public String toString() {
		String x = "";
		int i = 0;
		Stack<Card> tmp = new Stack<Card>();
		tmp = (Stack<Card>)deck.clone();
		tmp = reverse(tmp);
		for (Card myCard : tmp) {
			x += myCard + "\t ";
			i++;
			if (i == 4) {
				x += "\n";
				i = 0;
			}
		}
		return x + "\n";
	}

	// Return and remove the top card
	public Card deal() {
		return deck.pop();
	}

	// Take the top half of the deck (26 cards) and alternate card by card with
	// the bottom half
	public void bridgeShuffle() {
		Stack<Card> tmp = new Stack<Card>();
		for (int i = 0; i < deck.size() / 2; i++) {
			tmp.push(deck.pop());
		}
		tmp = reverse(tmp);
		Stack<Card> temp = new Stack<Card>();
		while (!tmp.isEmpty()) {
			temp.push(tmp.pop());
			temp.push(deck.pop());
		}
		deck = reverse(temp);
	}

	// Split the deck at a random spot. Put the stack of cards above the random
	// spot below the other cards
	public void cut() {
		int r = (int)(Math.random() * 52 + 1);
		Stack<Card> tmp = new Stack<Card>();
		for (int i = 0; i < r; i++) {
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
		for (int i = 1; i <= 7; i++) {
			bridgeShuffle();
			cut();
		}
	}

	// Reverse the order of the cards in the deck
	private void reverse() {
		deck.sort(Collections.reverseOrder());
	}

	// Given a Stack of cards as an explicit parameter,
	// reverse the order of the cards in the deck
	private Stack<Card> reverse(Stack<Card> x) {
		Stack<Card> tmp = x;
		tmp.sort(Collections.reverseOrder());
		return tmp;
	}

	// Combine other decks, one as the implicit
	// parameter, the other as the explicit parameter
	public void combineDecks(Stack<Card> other) {
		Stack<Card> temp = new Stack<Card>();
		int t = other.size();

		while (!deck.isEmpty() && !other.isEmpty()) {
			temp.push(deck.pop());
			temp.push(other.pop());
			for (Card x : temp) {
				System.out.println(x);
			}
		}

		while (!deck.isEmpty()) {
			temp.push(deck.pop());
		}

		while (!other.isEmpty()) {
			temp.push(other.pop());
		}

		deck = temp;

	}

	public static void main(String[] args) {
		// example method calls - you should make your own

		Deck a = new Deck();
		System.out.println(a.getDeck());
		System.out.print("Display after DECK CONSTRUCTION\n" + a + "\n\n\n");

		a.cut();
		System.out.println("Display after CUT\n" + a + "\n\n\n");

		a.bridgeShuffle();
		System.out.println("Display after BRIDGE SHUFFLE\n" + a + "\n\n\n");

		a.completeShuffle();
		System.out.println("Display after COMPLETE SHUFFLE\n" + a + "\n\n\n");

//		System.out.println("After 1 bridge shuffle");
//		System.out.println(a);
//		a.reverse();
//		for (int i = 1; i <= 5; i++)
//			System.out.println(a.deal());
	}
}
