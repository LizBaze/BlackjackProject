package com.skilldistillery.players;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;

public class Player {
	private Hand hand = new BlackjackHand();

	public Player() {
	}

	public void receiveCard(Card card) {
		hand.addCard(card);
	}

	public void showHand() {
		for (Card card : hand.getCards()) {
			System.out.print(card + " ");
		}
		System.out.println();
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
}
