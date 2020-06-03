package blackjack;

import java.util.Stack;

public class DeckHand {
	private Stack<Card> current;

	public DeckHand(Card first) {
		current = new Stack<Card>();
		current.push(first);
	}

	public Card hit(Card one) {
		current.push(one);
		return one;
	}

	public int getHandValue() {
		int total = 0;
		for (Card x : current) {
			if (x.value() == 14)
				total += 11;
			else if (x.value() >= 10)
				total += 10;
			else
				total += x.value();
		}
		for (Card x : current) {
			if (x.value() == 14 && total > 21)
				total -= 10;
		}
		return total;
	}

	public boolean bust() {
		return (getHandValue() > 21);
	}

	public int winner(DeckHand other) {
		if (other.getHandValue() > getHandValue())
			return 0;
		else if (other.getHandValue() == getHandValue())
			return 1;
		else
			return 2;
	}

	public String toString() {
		String out = "[ ";
		for (Card x : current) {
			out += x + " ";
		}
		return out + "]\nYour total value of hand: " + getHandValue();
	}
}
