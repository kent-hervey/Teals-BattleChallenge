package com.hervey.app.bpSubmission;

import java.util.ArrayList; //import ArrayList 
import java.util.Random; //import Random
import java.util.Scanner;
import java.util.List; //import List
import java.util.Collections; //import Collections
//Bennett Plumb
//6/8/21
//War Card Game

public class Card {
	private int rank;
	private int suite;

	public static void main(String[] args) {

		List<Card> cardDeck = new ArrayList<Card>(); // create an ArrayList "cardDeck"
		List<Card> playerOne = new ArrayList<Card>(); // Player One's list
		List<Card> playerTwo = new ArrayList<Card>(); // Player Two's list
		List<Card> playerOneWin = new ArrayList<Card>();// Player One's Winnings
		List<Card> playerTwoWin = new ArrayList<Card>();// PLayer Two's Winnings
		List<Card> playerOneHold = new ArrayList<Card>();// Hold's player one's cards
		List<Card> playerTwoHold = new ArrayList<Card>(); // Hold's player two's cards

		for (int x = 0; x < 4; x++) { // 0-3 for suit (4 suits)
			for (int y = 2; y < 15; y++) { // 2-14 for rank (13 ranks)
				cardDeck.add(new Card(x, y)); // create new card and add into the deck

			} // end rank for
		} // end suit for

		Collections.shuffle(cardDeck, new Random()); // shuffle the deck randomly

		// assigns the shuffled cards to each deck
		for (int i = 0; i < 26; i++) {
			playerOne.add(cardDeck.get(i));
		}

		for (int a = (playerOne.size()); a < cardDeck.size(); a++) {
			playerTwo.add(cardDeck.get(a));
		}
		// Starts the game
		Welcoming();

		System.out.println("player 1 has this many cards:  " + playerOne.size());
		System.out.println("player 2 has this many cards:  " + playerTwo.size());

		for (int i = 0; i < 26; i++) {
			int pOneR = ((playerOne.get(0)).getRank());
			int pTwoR = ((playerTwo.get(0)).getRank());
			int pOneS = playerOne.get(0).getSuite();
			int pTwoS = playerTwo.get(0).getSuite();
			int numHelp = Fight(pOneR, pTwoR);
			// Prints out the card being played
			System.out.println("player 1 has this many cards:  " + playerOne.size());
			System.out.println("player 2 has this many cards:  " + playerTwo.size());
			System.out.println("Player One plays " + pOneR + " of " + printSuite(pOneS));
			System.out.println("Player Two plays " + pTwoR + " of " + printSuite(pTwoS));
			// if player one's card is better
			if (numHelp == 1) {
				 System.out.println("Player One wins this battle");
				 System.out.println(playerOneWin.size());
				System.out.println(playerTwoWin.size());
				playerOneWin.add(playerOne.get(0));
				playerOneWin.add(playerTwo.get(0));
				playerOne.remove(0);
				playerTwo.remove(0);
				 System.out.println(playerOneWin.size());
				 System.out.println(playerTwoWin.size());
			}
			// If player 2's card is better
			if (numHelp == 2) {
				System.out.println("Player Two wins this battle");
				 System.out.println(playerOneWin.size());
				 System.out.println(playerTwoWin.size());
				playerTwoWin.add(playerOne.get(0));
				playerTwoWin.add(playerTwo.get(0));
				playerOne.remove(0);
				playerTwo.remove(0);
				 System.out.println(playerOneWin.size());
				 System.out.println(playerTwoWin.size());
			}
			System.out.println("just before check for tie");
			System.out.println("player 1 has this many cards:  " + playerOne.size());
			System.out.println("player 2 has this many cards:  " + playerTwo.size());

			// if they tie
			if (numHelp == 3) {
				System.out.println("You tied, this means war!");
				System.out.println(" Sending in four more troops from each of you");
				if (!(playerOne.size() >= 5 && playerTwo.size() >= 5)) {
					System.out.println("You do not have enough troops for war");
					System.out.println("You both receive your own troop");
					playerOneWin.add(playerOne.get(0));
					playerTwoWin.add(playerTwo.get(0));
					playerOne.remove(0);
					playerTwo.remove(0);

				}
				if (playerOne.size() >= 5 && playerTwo.size() >= 5) {
					int warFight = Fight(playerOne.get(4).getRank(), playerTwo.get(4).getRank());

					if (warFight == 1) {
						i += 4;
						System.out.println("Player One wins the war!");
						 System.out.println(playerOneWin.size());
						 System.out.println(playerTwoWin.size());

						for (int a = 0; a < 5; a++) {
							playerOneWin.add(playerOne.get(a));
							playerOneWin.add(playerTwo.get(a));
						}
						for (int b = 0; b < 5; b++) {
							playerOne.remove(b);
							playerTwo.remove(b);
						}
						 System.out.println(playerOneWin.size());
						 System.out.println(playerTwoWin.size());

					}
					if (warFight == 2) {
						i += 4;
						System.out.println("Player Two wins the war!");
						// System.out.println(playerOneWin.size());
						// System.out.println(playerTwoWin.size());
						for (int a = 0; a < 5; a++) {
							playerTwoWin.add(playerOne.get(a));
							playerTwoWin.add(playerTwo.get(a));
						}
						for (int b = 0; b < 5; b++) {
							playerOne.remove(b);
							playerTwo.remove(b);
						}

					}

					if (warFight == 3) {
						System.out.println("Your troops enntered another war, but they went MIA");
						System.out.println("You recived your troop as an award");
						 System.out.println(playerOneWin.size());
						 System.out.println(playerTwoWin.size());
						playerOneWin.add(playerOne.get(3));
						playerTwoWin.add(playerTwo.get(3));
						playerOne.remove(3);
						playerTwo.remove(3);
						 System.out.println(playerOneWin.size());
						 System.out.println(playerTwoWin.size());
					}

				}
				System.out.println("end of war");
		    	System.out.println("player 1 has this many cards:  " + playerOne.size());
		    	System.out.println("player 2 has this many cards:  " + playerTwo.size());
			}
		}

		if (playerOneWin.size() > playerTwoWin.size()) {
			System.out.println("Player One had " + playerOneWin.size() + " cards");
			System.out.println("Player Two had " + playerTwoWin.size() + " cards");
			System.out.println("Player One wins!");
			 System.out.println(playerOne.size());
			 System.out.println(playerTwo.size());
		}
		if (playerTwoWin.size() > playerOneWin.size()) {
			System.out.println("Player One had " + playerOneWin.size() + " cards");
			System.out.println("Player Two had " + playerTwoWin.size() + " cards");
			System.out.println("Player Two wins!");
			 System.out.println(playerOne.size());
			 System.out.println(playerTwo.size());
		}
		if (playerOneWin.size() == playerTwoWin.size()) {
			System.out.println("Player One had " + playerOneWin.size() + " cards");
			System.out.println("Player Two had " + playerTwoWin.size() + " cards");
			System.out.println("Both players tie!");
			System.out.println(playerOne.size());
			 System.out.println(playerTwo.size());

		}

	}

	public Card(int x, int y) {
		suite = x;
		rank = y;
	}

	public int getRank() {
		return rank;
	}

	public int getSuite() {
		return suite;
	}

	public String toString() {
		return (rank + " " + suite);

	}

	public static void Welcoming() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to war soilders!");
		System.out.println("I have accurately split up your soilders");
		System.out.println("Do you know how to play? Y or N");
		String howPlay = scn.nextLine();
		if (howPlay.equals("N") || howPlay.equals("n")) {
			Spacing();
			Instructions();
		}

	}

	public static void Instructions() {
		Scanner scn = new Scanner(System.in);

		System.out.println("A deck of cards has 52 cards");
		System.out.println("I have given both of you 26");
		System.out.println("You'll both flip your top card to fight eachother");
		System.out.println("If both cards are of the same rank, it starts a war");
		System.out.println(" Your team will consist of 5 soilders");
		System.out.println("You'll have 3 soilders face down and one faced up");
		System.out.println("Whoever wins the most battles wins the war, and all 10 cards");
		System.out.println("If that war ends in a tie, another war will start");
		System.out.println(" Press any letter when you're ready for battle");
		String ready = scn.nextLine();
	}

	public static void Spacing() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}

	public static int Fight(int x, int y) {
		if (x > y) {
			return 1;
		}
		if (x < y) {
			return 2;
		} else {
			return 3;
		}
	}

	public static String printSuite(int x) {
		if (x == 1) {

			return "clubs";
		}
		if (x == 2) {
			return "diamonds";
		}
		if (x == 3) {
			return "hearts";
		} else {
			return "spades";
		}
	}

}
