package com.game.card;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGameTest {
	public static void main(String[] args) {
		int money = 500; // 기본자산

		System.out.println("블랙잭 게임을 시작합니다. ( 게임을 종료하려면 숫자 7을 입력하세요 ) ");
		while (money>0) {
			CardCase cc = new CardCase();// 카드 52개를 생성한다.
			ArrayList<Card> cardlist = cc.getAllCards(); // 카드케이스에 담겨있는 카드를 리스트에 담는다.
			System.out.println();
			System.out.print("얼마를 베팅하시겠습니까? ");
			Scanner in = new Scanner(System.in); // 키보드로 부터 입력받는다 베팅 종료 힛 스탠드등
			int inputNum = in.nextInt(); // 숫자로 입력을 받는다. 1 2 3

			// 종료조건~!!
			if (inputNum == 7) {
				System.out.println("게임을 종료합니다.");
				break;
			}

			// Player, Dealer
			ArrayList<Card> player = new ArrayList<Card>();// 플레이어 카드 슬롯 구현
			ArrayList<Card> dealer = new ArrayList<Card>();// 딜러 카드 슬롯 구현

			// 플레이어 배팅
			System.out.println();
			System.out.println("money : " + money);

			// 베팅금액 받아오기
			int bet = inputNum;
			System.out.println(bet + " 베팅 완료");

			// dealer가 카드 분배하기
			System.out.println();
			System.out.println("딜러가 카드를 분배합니다.");
			System.out.println();
			// cardlist에서 랜덤으로 값을 2장 가져와서 player에게 던져준다.
			player.add(cardlist.get(0));
			player.add(cardlist.get(1));
			// cardlist에서 랜덤으로 값을 2장 가져와서 dealer에게 던져준다.
			dealer.add(cardlist.get(2));
			dealer.add(cardlist.get(3));

			// 카드 분배확인
//			System.out.println("player : "+player);
//			System.out.println("dealer : "+dealer);

			// dealer,player 카드 보여주기
			// 카드의 합 계산

			int player_sum = 0; // player의 카드의 합
			int dealer_sum = 0; // dealer의 카드의 합
			int sum = 0; // 최종 변환된 카드의 합

			label:while (true) {//**
				System.out.println("-----player card-----");
				for (int i = 0; i < player.size(); i++) {
					// 카드 출력
					System.out.print(player.get(i));
					// 카드 뽑아와서 String 변환
					String cd = player.get(i).getCard();
					// 숫자부분만 String에서 자르기
					String card_num = cd.substring(1);
					// System.out.println(card_num);

					// A카드 변환 로직
					if (card_num.equals("A")) {
						if (sum > 10)// 11일 경우 11을 더하면 bust 상태가 된다.
							sum += 1;
						else
							sum += 11;
					}

					// 숫자,JQK 변환 로직
					switch (card_num) {
					case "2":
					case "3":
					case "4":
					case "5":
					case "6":
					case "7":
					case "8":
					case "9":
						sum += Integer.parseInt(card_num);// 형 변환
						break;// **
					case "T":
					case "J":
					case "Q":
					case "K":
						sum += 10;
						break;
					}
				}

				// 변환된 카드의 합을 player_sum 변수에 할당
				player_sum = sum;

				// blackjack 상태일 경우
				if (player.size() == 2 && player_sum == 21) {
					System.out.println("-----dealer card-----");
					for (int i = 0; i < dealer.size(); i++) {
						System.out.print(dealer.get(i));
					}
					//
					System.out.println(dealer_sum);
					System.out.println();
					System.out.println("Blackjack");
					money += 1.5 * bet;
					System.out.println("money : " + money);
					break;
				}
				
				// 카드의 합이 딜러보다 먼저 21이  이기는 조건
				if ( player_sum == 21) {
					//이기는 조건
					// 승패 나올 때 오픈
					System.out.println("-----dealer card-----");
					for (int i = 0; i < dealer.size(); i++) {
						System.out.print(dealer.get(i));
					}
					//
					System.out.println(dealer_sum);
					System.out.println();
					System.out.println("Win");
					money += bet;
					System.out.println("money : " + money);
				}

				//
				System.out.print(player_sum);
				sum = 0;

				System.out.println();
				System.out.println();

				System.out.println("-----dealer card-----");
				// dealer 카드 출력(쉐도잉 버전)
				System.out.print(dealer.get(0));
				System.out.println("[**]");
				System.out.println();

				// 1차(쉐도잉 버전 2개 카드 할당시의) dealer_sum 계산 >>추가 할당 전
				for (int i = 0; i < dealer.size(); i++) {
					// 카드 뽑아와서 String 변환
					String cd = dealer.get(i).getCard();
					// 숫자부분만 String에서 자르기
					String card_num = cd.substring(1);
					// System.out.println(card_num);

					// A카드 변환 로직
					if (card_num.equals("A")) {
						if (sum > 10)// 11일 경우 11을 더하면 bust 상태가 된다.
							sum += 1;
						else
							sum += 11;
					}

					// 숫자,JQK 변환 로직
					switch (card_num) {
					case "2":
					case "3":
					case "4":
					case "5":
					case "6":
					case "7":
					case "8":
					case "9":
						sum += Integer.parseInt(card_num);// 형 변환
						break;// **
					case "T":
					case "J":
					case "Q":
					case "K":
						sum += 10;
						break;
					}
				}

				// 1차로 변환된 카드의 합을 dealer_sum 변수에 할당
				dealer_sum = sum;
				sum = 0;

				// player 선택지
				// bust 상태일 경우
				if (player_sum > 21) {
					System.out.println("Bust");
					System.out.println("Game over");
					money -= bet;
					System.out.println("money : " + money);
					break;
				} else {
					// hit or stand 선택
					System.out.print("1. Hit or 2. Stand? ");
					int num = in.nextInt();

					switch (num) {
					// hit일 경우 카드 한 장을 더 받아온다.
					case 1:
						player.add(cardlist.get(4));
						// 사용한 카드 지우기
						cardlist.remove(4);// **
						break;

					// stand일 경우에 처리
					case 2:
						// 딜러 카드 할당
						while (dealer_sum < 17) {
							// 카드 한 장을 딜러에게 할당 >> while문 조건을 불만족할 때까지(dealer_sum >= 17)
							dealer.add(cardlist.get(4));
							// for (int i = 0; i < dealer.size(); i++) {
							// 가져온 카드 숫자 변환
							// 카드 뽑아와서 String 변환
							String cd = cardlist.get(4).getCard();
							// 숫자부분만 String에서 자르기
							String card_num = cd.substring(1);
							// System.out.println(card_num);

							// A카드 변환 로직
							if (card_num.equals("A")) {
								if (sum > 10)// 11일 경우 11을 더하면 bust 상태가 된다.
									sum += 1;
								else
									sum += 11;
							}

							// 숫자,JQK 변환 로직
							switch (card_num) {
							case "2":
							case "3":
							case "4":
							case "5":
							case "6":
							case "7":
							case "8":
							case "9":
								sum += Integer.parseInt(card_num);// 형 변환
								break;// **
							case "T":
							case "J":
							case "Q":
							case "K":
								sum += 10;
								break;
							}
							// 2차(오픈 버전 카드 할당 후의) dealer_sum 계산 >>추가 할당 후
							dealer_sum += sum;
							// 사용한 카드 지우기
							cardlist.remove(4);
							sum = 0;
							// }
						}

//						System.out.println("-----dealer card-----");
//						for (int i = 0; i < dealer.size(); i++) {
//							System.out.print(dealer.get(i));
//						}
						
						// 딜러 카드 오픈, 승패 처리
						//if (dealer_sum == player_sum) { 수정전 에러 없을 때
						if ((dealer_sum == player_sum)||(Math.abs(21 - dealer_sum)==Math.abs(21 - player_sum))) {
							// 비기는 조건
							// 승패 나올 때 오픈
							System.out.println("-----dealer card-----");
							for (int i = 0; i < dealer.size(); i++) {
								System.out.print(dealer.get(i));
							}
							//
							System.out.println(dealer_sum);
							System.out.println();
							System.out.println("Tie");
							System.out.println("money : " + money);
						} else if (Math.abs(21 - dealer_sum) >Math.abs(21 - player_sum)) {
							//이기는 조건
							// 승패 나올 때 오픈
							System.out.println("-----dealer card-----");
							for (int i = 0; i < dealer.size(); i++) {
								System.out.print(dealer.get(i));
							}
							//
							System.out.println(dealer_sum);
							System.out.println();
							System.out.println("Win");
							money += bet;
							System.out.println("money : " + money);
						} else {
							//지는 조건
							// 승패 나올 때 오픈
							System.out.println("-----dealer card-----");
							for (int i = 0; i < dealer.size(); i++) {
								System.out.print(dealer.get(i));
							}
							//
							System.out.println(dealer_sum);
							System.out.println();
							System.out.println("Game over");
							money -= bet;
							System.out.println("money : " + money);
						}
						break label;//**
					}
				}

			} // 게임 한 판 while end
		} // 게임 전체 while end
	}

//	// 승--아직 구현X
//	void win() {
//		System.out.println("Win");
//		money += bet;
//		System.out.println("money : " + money);
//	}
//
//	// 비김--아직 구현X
//	void same() {
//		System.out.println("Tie");
//		System.out.println("money : " + money);
//	}
//
//	// 패--아직 구현X
//	void lose() {
//		System.out.println("Game over");
//		money -= bet;
//		System.out.println("money : " + money);
//	}
//

}
