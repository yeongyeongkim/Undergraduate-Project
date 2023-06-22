package com.game.card;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> player;

	// 값을 넣어주는 메소드
	public ArrayList<Card> getPlayer() {
		return player;
	}

	// 값을 외루보 가져가는 메소드
	public void setPlayer(ArrayList<Card> player) {
		this.player = player;
	}
}
