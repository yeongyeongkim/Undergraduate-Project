package com.game.card;

import java.util.ArrayList;

public class CardCase {

	private final int numOfCards = Card.num.length * Card.grim.length;
	
	public ArrayList<Card> cards;
	
	
	public CardCase() {
		init();
		shuffle();
	}

	private void init() {
		cards = new ArrayList<>();
	}
	
	private void shuffle() {
		int count = 0;
		while(true) {
			Card cd = new Card();
			if (!cards.contains(cd)) {
				cards.add(cd);
				count++;
			}
			if (count==numOfCards) {
				break;
			}
		}
	}
	
	/* 생성된 서로다른 카드를 외부에서 호출해서 사용할 수 있도록 가져가는 메소드 */
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
