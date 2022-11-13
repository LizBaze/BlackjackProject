package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cardgame.BlackjackHandComparator;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp {
	Dealer dealer = new Dealer();
	Player player = new Player();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean keepGoing = true;

		do {

			initialDeal(dealer, player);

			playerDecisions(sc);
			
			resolveWinner();

			keepGoing = playAgain(sc, keepGoing);

		} while (keepGoing);

		System.out.println("Thanks for playing!");
	}

	public void initialDeal(Dealer dealer, Player player) {
		if (dealer.getDeck().checkDeckSize() < 12) {
			dealer.setDeck(new Deck());
			printStars();
			System.out.println("The dealer will reshuffle the deck now.");
			printStars();
		}
		dealer.getDeck().shuffle();
		player.getHand().clear();
		dealer.getHand().clear();
		player.receiveCard(dealer.dealCard());
		dealer.receiveCard(dealer.dealCard());
		player.receiveCard(dealer.dealCard());
		dealer.receiveCard(dealer.dealCard());
	}

	public void playerDecisions(Scanner sc) {
		int playerHandValue = 0;
		boolean hit = true;
		do {
			try {
				playerHandValue = getHandValue(player);
				System.out.println("Your hand's value is " + playerHandValue);
				System.out.println("You cards are: " + player.getHand());
				System.out.println(dealer.showPartialHand());
				System.out.println("Do you want to hit? y/n");
				String userInput = sc.nextLine();

				switch (userInput.toUpperCase()) {
				case "Y":
					player.receiveCard(dealer.dealCard());
					if (getHandValue(player) >= 21) {
						((BlackjackHand) player.getHand()).isSoft(player);
					}
					playerHandValue = getHandValue(player);
					break;
				case "N":
					hit = false;
					break;
				}

			} catch (InputMismatchException E) {
				System.out.println("Invalid input, please try again");
				sc.nextLine();
			}

		} while (playerHandValue < 21 && hit == true);
	}

	public boolean playAgain(Scanner sc, boolean keepGoing) {
		boolean validInput = false;
		do {
			try {
				System.out.println("Do you want to play again? y/n");
				String userInput = sc.nextLine();
				if (userInput.toUpperCase().equals("N")) {
					keepGoing = false;
					validInput = true;
					break;
				} else if (userInput.toUpperCase().equals("Y")) {
					validInput = true;
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please try again.");
				sc.nextLine();
			}
			System.out.println("Invalid input, please try again.");
		} while (!validInput);
		return keepGoing;
	}

	public void resolveWinner() {

		int playerHandValue = getHandValue(player);

		if (((BlackjackHand) player.getHand()).isBust()) {
			printStars();
			System.out.println("You bust with a score of " + playerHandValue + " " + player.getHand());
			printStars();
		} else {

			BlackjackHandComparator winDecider = new BlackjackHandComparator();

			// Call dealerDecisions and assign the result to the dealer's hand
			dealerDecisions(dealer);

			int dealerHandValue = getHandValue(dealer);
			if (dealerHandValue <= 21) {
				printScores();
				int winner = winDecider.compare(dealer.getHand(), player.getHand());

				switch (winner) {
				case -1:
					printStars();
					System.out.println("You won!");
					printStars();
					break;
				case 1:
					printStars();
					System.out.println("Dealer wins");
					printStars();
					break;
				case 0:
					printStars();
					System.out.println("Push");
					printStars();
				}
			} else {
				printStars();
				printScores();
				System.out.println("Dealer busts");
				printStars();
			}
		}
	}

	// casts to BlackjackHand to get the value, used for readability elsewhere
	public int getHandValue(Player player) {
		int handValue = ((BlackjackHand) player.getHand()).getHandValue();
		return handValue;
	}
	
	public void dealerDecisions(Dealer dealer) {
		int dealerHandValue = getHandValue(dealer);
		do {
			if (dealerHandValue >= 17 && dealerHandValue <= 21) {
				break;
			} else if (dealerHandValue > 21) {
				break;
			} else if (dealerHandValue < 17) {
				dealer.receiveCard(dealer.dealCard());
				if (getHandValue(dealer) > 21) {
					((BlackjackHand) dealer.getHand()).isSoft(dealer);
				}
				dealerHandValue = getHandValue(dealer);
			}
		} while (dealerHandValue < 21);
	}

	public void printStars() {
		System.out.println("*******************************************************");
	}
	
	public void printScores() {
		System.out.println("Your score is " + getHandValue(player) + " with the cards: " + player.getHand());
		printStars();
		System.out.println(
				"The dealer's score is " + getHandValue(dealer) + " with the cards: " + dealer.getHand());
		printStars();

	}
}
