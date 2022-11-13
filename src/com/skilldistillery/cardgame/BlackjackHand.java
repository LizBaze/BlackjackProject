package com.skilldistillery.cardgame;

import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Rank;
import com.skilldistillery.players.Player;

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
	
	public void isSoft(Player player) {
		for (Card card : player.getHand().getCards()) {
			if (card.getRank().equals(Rank.ACE) && ((BlackjackHand) player.getHand()).getHandValue() >= 21) {
				card.setRank(Rank.ONE);
			}
		}
	}	
	
}



