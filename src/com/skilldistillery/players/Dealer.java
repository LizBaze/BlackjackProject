package com.skilldistillery.players;

import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player {
	private Deck deck = new Deck();
	
	
	public Dealer() {
	}
	
	
	public Card dealCard() {
		return deck.removeCard();
	}
	
	public void showPartialHand() {
		List<Card> hand = getHand().getCards();
		for (int i = 1; i < hand.size(); i++) {
			System.out.println("" + hand.get(i));
		}
	}
	
	
	
}
