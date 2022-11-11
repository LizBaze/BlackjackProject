package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	
	List<Card> cards = new ArrayList<>();
	
	
	public void addCard(Card card) {
		cards.add(card);
	}


	public List<Card> getCards() {
		return cards;
	}


	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public void clear() {
		for (Card card : cards) {
			cards.remove(card);
		}
	}
	
	abstract int getHandValue();


	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
	
	
	
}
