package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
	}
	

	public List<Card> getHand() {
		return getCards();
	}


	@Override
	public String toString() {
		return  "" + getCards();
	}
	
	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}
	
	public boolean isBust() {
		boolean isBust;
		if (getHandValue() > 21) {
			isBust = true;
		} else {
			isBust = false;
		}
		return isBust;
	}
	
	public boolean isBlackjack() {
		boolean isBlackjack;
		if (getHandValue() == 21 && getCards().size() == 2) {
			isBlackjack = true;
		} else {
			isBlackjack = false;
		}
		return isBlackjack;
	}
	
	
	
	
}



