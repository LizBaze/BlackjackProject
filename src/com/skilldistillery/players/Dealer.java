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
	
	public String showPartialHand() {
		List<Card> hand = getHand().getCards();
		String results = "The dealer shows: ";
		for (int i = 1; i < hand.size(); i++) {
			results += hand.get(i) + " ";
		}
		return results;
	}


	public Deck getDeck() {
		return deck;
	}


	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
	
}
