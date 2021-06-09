package com.hervey.app.haSubmission;

/* Hudson Arney
 * Mrs. Buske
 * AP Computer Science A
 * 1 June 2021
 * Project: War
 */

import java.util.ArrayList; //import ArrayList
import java.util.Random; //import Random
import java.util.List; //import List
import java.util.Collections; //import Collections

public class War {

	public static void main(String[] args) {

		List<Card> cardDeck = new ArrayList<Card>(); // create an ArrayList "cardDeck"

		for (int x = 0; x < 4; x++) { // 0-3 for suit (4 suits)
			for (int y = 2; y < 15; y++) { // 2-14 for rank (13 ranks)
				cardDeck.add(new Card(x, y)); // create new card and add into the deck
			} // end rank for
		} // end suit for

		Collections.shuffle(cardDeck, new Random()); // shuffle the deck randomly

		List<Card> player1 = new ArrayList<Card>();
		List<Card> player2 = new ArrayList<Card>();

		for (int i = 0; i < 26; i++) {
			player1.add(cardDeck.get(i));
		}

		for (int j = 26; j < cardDeck.size(); j++) {
			player2.add(cardDeck.get(j));
		}

		System.out.println("player 1 starts with these cards:  " + player1.toString());
		System.out.println("player 2 starts with these cards:  " + player2.toString());

		System.out.println("Hello!\nWe will soon begin a game of WAR!\n");

		for (int k = 0; k < 999999; k++) {
			System.out.println("k is:  " + k);

			Card card1 = player1.remove(0); // card being played
			Card card2 = player2.remove(0); // card being played

			System.out.println("Player 1 plays: " + card1);
			System.out.println("Player 2 plays: " + card2);

			if (card1.getCard() > card2.getCard()) {
				player1.add(0, card1);
				player1.add(0, card2);
				System.out.println("Player 1 wins the Round.");
				System.out.println("player 1 card count:  " + player1.size());
				System.out.println("player 2 card count:  " + player2.size());
				System.out.println();
			}

			else if (card1.getCard() < card2.getCard()) {
				player2.add(0, card1);
				player2.add(0, card2);
				System.out.println("Player 2 wins the Round.");
				System.out.println("player 1 card count:  " + player1.size());
				System.out.println("player 2 card count:  " + player2.size());
				System.out.println();
			}

			else {

				System.out.println("There is a tie.\nTHIS MEANS WAR!");

				System.out.println("player 1 now has this many cards (1 already taken out):  " + player1.size() + " which are " + player1.toString());
				System.out.println("player 2 now has this many cards:  " + player2.size() + " which are " + player2.toString());

				List<Card> war1 = new ArrayList<Card>(); // war1 is all the cards in front of player1 on the table
				List<Card> war2 = new ArrayList<Card>();

				war1.add(card1); // putting the first card played on table in front of player1
				war2.add(card2);
				System.out.println("as soon as war was decided, war1 has:  " + war1 + " and size of:  " + war1.size());
				System.out.println("as soon as war was decided, war2 has:  " + war2 + " and size of:  " + war2.size());

				//adds 4 cards to do the war...three secret cards, and then a face up onto the table
				for (int i = 0; i < 4; i++) {
					if (player1.size() == 0 || player2.size() == 0) {
						break;
					}
					war1.add(player1.remove(0)); // this and two below add three cards to player1's table
					war2.add(player2.remove(0)); // this and two below add three cards to player2's table
					System.out.println("when for loop i is:  " + i + ", war1 has:  " + war1 + " and size of:  " + war1.size());
					System.out.println("when for loop i is:  " + i + ", war2 has:  " + war2 + " and size of:  " + war2.size());
				}
				//each table now has cards in 0, 1, 2, 3, 4..with 4 being the last card added
//				System.out.println("aaa");
//				System.out.println("just before if... war1.size is:  " + war1.size());
//				System.out.println("just before if... war2.size is:  " + war2.size());
//				
				if (player1.size() == 0 || player2.size() == 0) {
					break;
				}
				
				
				if (true) {
					//System.out.println("bbb");

					System.out.println("Player 1 plays: " + war1.get(4).toString() + " for their war card!");
					System.out.println("Player 2 plays: " + war2.get(4).toString() + " for their war card!");
					
					if (war1.get(4).getCard() > war2.get(4).getCard()) {
						System.out.print("war1 size: " + war1.size());
						System.out.print("war2 size: " + war2.size());
						System.out.println("player 1 card count:  " + player1.size());
						System.out.println("player 2 card count:  " + player2.size());
						System.out.println("now cards on table are moved to winner's hand");
						player1.addAll(war1);
						player1.addAll(war2);
						System.out.println("Player 1 won the war round!");
						System.out.println("player 1 card count:  " + player1.size());
						System.out.println("player 2 card count:  " + player2.size());
						System.out.println();
					}

					else {
						player2.addAll(war1);
						player2.addAll(war2);
						System.out.println("Player 2 won the war round!");
						System.out.println("player 1 card count:  " + player1.size());
						System.out.println("player 2 card count:  " + player2.size());
						System.out.println();
					}
//					System.out.println("at war end, player 1 has: " + war1);
//					System.out.println("at war end, player 2 has; " + war2);
				}

			}

			if (player1.size() == 0) {
				System.out.println("PLAYER 2 WINS!!!\nGAME OVER!!!");
				break;
			}

			else if (player2.size() == 0) {
				System.out.println("PLAYER 1 WINS!!!\nGAME OVER!!!");
				break;
			}

		}

	}

}
