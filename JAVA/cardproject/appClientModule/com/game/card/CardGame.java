package com.game.card;

import java.util.ArrayList;

/*
 * 카드 게임을 만들기 위해서 내가 필요한 만큼의 
 * 서로다른 카드를 만든다.
 * */
public class CardCase {
	/* 만들려고 하는 전체 카드 개수 정의 
	 * Card c = new Card(); c.num.length;
	 * Card.num.length;
	 * */
	private final int numOfCards = Card.num.length * Card.grim.length;
	/* 만들어진 카드를 담을 그릇을 정의 */
	public ArrayList<Card> cards;
	
	/* CardCase 객체를 생성할때 값을 초기화하는 메소드와 카드를 섞는 메소드 호출 */
	public CardCase() {
		init();
		shuffle();
	}

	/* 카드를 담을 객체를 초기화 */
	private void init() {
		cards = new ArrayList<>();
	}
	
	/*
	 * 서로다른 카드가 생성되도록 하는 메소드
	 * cards라는 그릇에 이미 존재하는 카드가 나오면 스킵하고
	 * cards에 존재하지 않는 카드가 나오면 추가하는 형태로
	 * 카드를 numOfCards 개수만큼 생성한다.
	 * public boolean isSame(String[] cards, String cd){
	 *   boolean isT = false;
	 *   for(){
		 *   if(){
		 *   	isT = true;
		 *   	break;
		 *   }
	 *   }
	 *   return isT;
	 * }
	 * */
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
