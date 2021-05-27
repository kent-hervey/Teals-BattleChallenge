package com.hervey.app.agVersion;


import java.util.*;

public class WarAG {

	final public static String SUITS = "CDHS";
	final public static int LIMIT = 10000;

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		Random r = new Random();

		// Create a deck of cards.
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int i=0; i<4; i++)
			for (int j=1; j<=13; j++) {
				//System.out.println("suit this time in loop:  " + SUITS.charAt(i));
				//System.out.println("rank this time in loop:  " + j);
				Card tempCard = new Card(SUITS.charAt(i), j);
				//System.out.println("tempCard looks like this, in loop  " + tempCard);
				deck.add(tempCard);
			}
		//System.out.println("deck looks like this to start:  " + deck);

		// Set up both players' cards.
		ArrayList<Card> player1 = new ArrayList<Card>();
		ArrayList<Card> player2 = new ArrayList<Card>();

		// Deal the cards randomly to the two players.
		int cnt = 0;
		while (deck.size() > 0) {
			int nextCard = r.nextInt(deck.size());
			if (cnt%2 == 0) {
				Card c1 = deck.remove(nextCard);
				player1.add(c1);
			}
			else
				player2.add(deck.remove(nextCard));
			cnt++;
		}

		int winner = -1, turns = 0;
		
		System.out.println("Player 1 has "+player1.size()+" cards and Player 2 has "+player2.size()+" cards.");

		// Play war until someone runs out of cards.
		while (player1.size() > 0 && player2.size() > 0 && turns < LIMIT) {

			// Show how many cards each team has,
			System.out.println("Player 1 has "+player1.size()+" cards and Player 2 has "+player2.size()+" cards.");
			
			//System.out.println("player 1's cards:  " + player1);

			Card c1 = player1.remove(0);
			Card c2 = player2.remove(0);

			// Print out the new play.
			System.out.println("Player 1 plays "+c1+" and player 2 plays "+c2);

			// War!
			if (c1.equalsForWar(c2)) {

				// Notify that we have a war.
				System.out.println("We have a war!!!");

				// Not enough cards for player 1 to carry out the war.
				if (player1.size() < 3) {
					winner = 2;
					System.out.println("Player 1 ran out of cards in a war battle.");
					break;
				}

				// Same case for player 2.
				else if (player2.size() < 3) {
					winner = 1;
					System.out.println("Player 2 ran out of cards in a war battle.");
					break;
				}

				// Have a battle. Put two cards in the "bin" and battle with the third card.
				else{

					// Two cards taken from both players stored in tmp.
					ArrayList<Card> tmp = new ArrayList<Card>();
					for (int i=0; i<2; i++) {
						tmp.add(player1.remove(0));
						tmp.add(player2.remove(0));
					}

					// These are the next cards to battle.
					Card c1extra = player1.remove(0);
					Card c2extra = player2.remove(0);

					// Print out cards played in battle.
					System.out.println("In the card battle player 1 played "+c1extra+" and player 2 played "+c2extra);

					// I'll use the no tie-breaker rule between these cards to simplify the game.
					if (c1extra.beats(c2extra)) {

						// Lots of cards to add! (8 in all)
						player1.add(c1);
						player1.add(c2);
						player1.add(c1extra);
						player1.add(c2extra);
						for (Card c: tmp)
							player1.add(c);

						System.out.println("Player 1 wins the battle and gets all 8 cards!");
					}

					else {

						// Here we do it for player 2 instead.
						player2.add(c1);
						player2.add(c2);
						player2.add(c1extra);
						player2.add(c2extra);
						for (Card c: tmp)
							player2.add(c);

						System.out.println("Player 2 wins the battle and gets all 8 cards!");
					}
				}
			}

			// Regular case.
			else {
				if (c1.beats(c2)) {
					player1.add(c1);
					player1.add(c2);
					System.out.println("Player 1 wins the battle and gets 2 cards.");
				}
				else {
					player2.add(c1);
					player2.add(c2);
					System.out.println("Player 2 wins the battle and gets 2 cards.");
				}

			}

			turns++;
			System.out.println();
		}

		if (turns == LIMIT) {
			System.out.println("Sorry, after 10000 turns no one won, so the game is a tie!");
		}

		// Assign winner if unassigned.
		else if (winner == -1) {
			if (player2.size() == 0)
				winner = 1;
			else
				winner = 2;
		}

		// Print out final winner.
		if (winner != -1)
			System.out.println("The winner is player "+winner);
	}
}