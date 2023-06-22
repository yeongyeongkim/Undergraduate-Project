package com.game.card;

/*
 * 카드 게임을 만들기 위한 Card 객체
 * Card 객체를 생성하면 하나의 카드가 만들어 지도록 구현
 * */
public class Card {
	/*
	 * 생성된 카드 값을 저장하는 문자열 멤버변수
	 * H8,C2...
	 * */
	private String card;
	
	/* 카드의 종류 중에 숫자 */
	public static final String[] num = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	/* 카드의 종류 중에 그림 */
//	public static final String[] grim = {"H","C","D","S"};
	public static final String[] grim = {"♥","♦","♣","♠"};	
	
	/* 카드 객체를 생성할때 카드 하나를 만드는 메소드 호출 
	 * Card card = new Card();
	 * */
	public Card() {
		makeCard();
	}
	
	/* 카드를 랜덤으로 그림과 숫자가 조합되도록 만드는 메소드 */
	public void makeCard() {
		int n = (int)(num.length * Math.random());
		int g = (int)(grim.length * Math.random());
		
		card = grim[g]+num[n]; // A2, 3D		
	}
	
	/* equals overriding
	 * 객체는 기본적으로 같을 수 없기때문에 
	 * o1.equals(o2) 값은 항상 false가 나온다. 
	 * 하지만 여기에서는 값이같으면 객체가 같도록 해야하기 때문에
	 * equals overriding을 구현해서 값이 같으면 같은 객체라고
	 * 판단할 수 있게 해준다. 
	 *  */
	@Override
	public boolean equals(Object obj) {
		boolean isT = false;
		Card cd = (Card)obj;
		if (card.equals(cd.getCard())) {
			isT = true;
		}
		return isT;
	}
	
	/* equals overriding을 해줄경우에는 
	 * 반드시 hashCode도 오버라이딩을 해줘야 한다.
	 *  */
	@Override
	public int hashCode() {
		return card.hashCode()+137;
	}
	
	
	/* 만들어진 카드 객체의 값을 가져가는 메소드 */
	public String getCard() {
		return card;
	}
	
	/* 카드값이 출력될때 구분되게 보이도록 toString() 오버라이딩함. 
	 * Card c = new Card();
	 * System.out.println(c.getCard().toString()); // HAD2........
	 * System.out.println(c.getCard().toString()); // [HA][D2]...
	 * */
	@Override
	public String toString() {
		return "["+card+"]";
	}	
}
