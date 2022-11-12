package com.skilldistillery.cardgame;

public class BlackjackHandComparator {
	
	public int compare(Hand hand1, Hand hand2) {
		int result = 0;
		if (hand1.getHandValue() > hand2.getHandValue()) {
			result = 1;
		} else if (hand1.getHandValue() < hand2.getHandValue()) {
			result = -1;
		}
		
		return result;
	}

}
