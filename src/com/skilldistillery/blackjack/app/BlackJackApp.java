package com.skilldistillery.blackjack.app;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	public void run() {
		Dealer dealer = new Dealer();
		Player player = new Player();
		
		player.receiveCard(dealer.dealCard());
		dealer.receiveCard(dealer.dealCard());
		player.receiveCard(dealer.dealCard());
		dealer.receiveCard(dealer.dealCard());
		
		System.out.println("Your hand's value is " + ((BlackjackHand) player.getHand()).getHandValue());
		System.out.println("You cards are: " + player.getHand());
		
		
		System.out.println("The dealer shows ");
		dealer.showPartialHand();
		
	}
	
	
	
	
	
}
