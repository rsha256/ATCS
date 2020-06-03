package blackjack;

import java.util.*;

public class BlackJack {

	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		System.out.println("Welcome to Le Casino d'Aravind");

		String in = "";
		double score = 500;
		double amnt = 0;

		System.out.println("How much money do you want to play with?");
		score = input.nextDouble();

		do {
			System.out.println("\nPrepare to face the dealer!");

			Deck one = new Deck();
			one.completeShuffle();
			System.out.println("Shuffling deck ...");

			DeckHand play = new DeckHand(one.deal());

			System.out.println("\nDealing cards...\n\nHere is your hand:\n" + play);

			System.out.println("\nHow much money do you want to bet? You have $" + score);
			amnt = input.nextDouble();
			score -= amnt;
			while (score < 0) {
				score += amnt;
				System.out.println("Enter Valid Bet! You only have $" + score);
				System.out.println("\nHow much money do you want to bet?");
				amnt = input.nextDouble();
				score -= amnt;
			}

			play.hit(one.deal());
			System.out.println("\n\nDealing second card to player...Here is your hand:\n" + play);

			in = "";
			while (!in.equalsIgnoreCase("n") && play.getHandValue() <= 30) {

				System.out.println("\nDo you want to hit? (Enter 'y' to hit or Enter 'N' to stay)");
				in = input2.nextLine();
				if (in.equalsIgnoreCase("y")) {
					play.hit(one.deal());
					System.out.println("Your new hand: \n" + play);
				}
			}

			DeckHand deal = new DeckHand(one.deal());

			System.out.println("\n>Dealer's turn\n\nThe dealer's hand is:\n" + deal);

			while (deal.getHandValue() < 17) {
				deal.hit(one.deal());
				System.out.println("\nThe dealer hit.\nHis new hand is:\n" + deal);
			}
			if (deal.getHandValue() <= 21) {
				System.out.println("\nThe dealer decided to stay!");
			}
			if (deal.bust()) {
				if (play.bust()) {
					score += amnt;
					System.out.println("\nBoth dealer and player busted. " + "You guys should improve your skills.");
					System.out.println("\nYou can have your bet back. " + "Currently you have $" + score);
				} else {
					score += (2 * amnt);
					System.out.println("\nLooks like you won. " + "Congratulations but here is your money"
							+ "\n\nCurrent Balance: $" + score);
				}
			} else if (play.bust()) {
				if (deal.bust()) {
					score += amnt;
					System.out.println("\nBoth dealer and player busted. " + "You guys should improve your skills.");
					System.out.println("\nYou can have your bet back. " + "Currently you have $" + score);
				} else {
					System.out.println("\nLooks like the dealer won. " + "You should improve your skills!"
							+ "\n\nCurrent Balance: $" + score);
				}
			} else {
				if (play.winner(deal) == 0) {
					System.out.println(
							"\nRIP, the dealer won. " + "Better Luck next time!" + "\n\nCurrent Balance: $" + score);
				} else if (play.winner(deal) == 1) {
					score += amnt;
					System.out.println("\nOof it's a tie." + "You should improve your skills!");
					System.out.println("\nYou can have your bet back. " + "Currently you have $" + score);
				} else {
					score += (2 * amnt);
					System.out.println("\nLooks like you won. " + "Unfortunate but here is your money"
							+ "\n\nCurrent Balance: $" + score);
				}
			}

			in = "";
			System.out.println("Do you want to Play again? (Enter 'y' or 'N')");
			in = input2.nextLine();

		} while (!in.equalsIgnoreCase("n") && score > 0);
		if (score == 0) {
			System.out.println("\nThanks for playing at Le Casino d'Aravind. Come back when you have more money for us!");
		} else {
			System.out.println("\nThanks for playing at Le Casino d'Aravind. Play again later!");
		}
	}
}
