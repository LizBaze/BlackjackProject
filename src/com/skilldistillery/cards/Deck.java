package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			// Create a card for every value in Rank except Rank.ONE which will be used only for soft Aces
			for (int i = 1; i < Rank.values().length; i++) {
				cards.add(new Card(Rank.values()[i], suit));
			}
		}
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	
	public Card removeCard() {
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}
	
	
	
}
