package com.hervey.app.apSubmission;

/* Alana Perry
 * 6/1/21
 * Play a game of the war card game
 */

import java.util.ArrayList; 	//import ArrayList 
import java.util.Random;    	//import Random
import java.util.List;      	//import List
import java.util.Collections;   //import Collections

public class apWar {
	public static void main(String[] args) {
		System.out.println("Alana's game");
    	//create an ArrayList "cardDeck"
    	List<Card> cardDeck = new ArrayList<Card>(); 
    	
    	for(int x=0; x<4; x++){      	//0-3 for suit (4 suits)
        	for(int y=2; y<15; y++){ 	//2-14 for rank (13 ranks)
            	cardDeck.add(new Card(x,y)); //create new card and add into the deck
        	} //end rank for loop
    	}//end suit for loop
    	
    	Collections.shuffle(cardDeck, new Random()); //shuffle the deck randomly
    	
    	// distributes the cards in cardDeck between players
    	List<Card> player1 = new ArrayList<Card>() ;
    	List<Card> player2 = new ArrayList<Card>() ;
    	for(int i = 0; i  < 27; i++) {
    		player1.add(cardDeck.get(i));
    	}
    	for(int i = 27; i < cardDeck.size() - 1; i++) {
    		player2.add(cardDeck.get(i));
    	}
    	
    	// start of the game
    	while(player1.size() > 0 && player2.size() > 0) {
    		playCard(player1, player2);
    	}
    	if(player1.size() == 0) {
    		System.out.println("\nLooks like Player 1 ran out of cards :O \nCongrats Player 2, you win! \nBetter luck next time Player 1.");
    	}
    	else {
    		System.out.println("\nLooks like Player 2 ran out of cards :O \nCongrats Player 1, you win! \nBetter luck next time Player 2.");
    	}
	}
	
	// method to play a card
	public static void playCard(List<Card> deck1, List<Card> deck2) {
		Card p1Card = deck1.get(0);
		Card p2Card = deck2.get(0);
		System.out.println("Player 1 plays " + p1Card);
		System.out.println("Player 2 plays " + p2Card);
		// checks if the played cards match and goes to war if so
		if(cardMatch(p1Card, p2Card)) {
			System.out.println("Time for war!");
			System.out.println("Player 1 deck size: " + deck1.size());//added for grading
			System.out.println("Player 2 deck size: " + deck2.size());//added for grading
			int warId = 4;
			// checks deck size
			if(deck1.size() > warId && deck2.size() > warId) {
				war(deck1, deck2, warId);
			}
			// breaks out of the recursive loop in case the decks do not have enough cards for war
			else if(deck1.size() <= warId) {
				System.out.println("\nOh no! Player 1 didn't have enough cards to go to war. \nPlayer 1 lost:( \nCongrats Player 2, you won!");
				for(int i = 0; i < deck1.size(); i++) {
					deck2.add(deck1.get(i));
					deck1.remove(i);
				}
				System.exit(0);
			}
			else if(deck2.size() <= warId) {
				System.out.println("\nOh no! Player 2 didn't have enough cards to go to war. \nPlayer 2 lost:( \nCongrats Player 1, you won!");
				for(int i = 0; i < deck2.size(); i++) {
					deck1.add(deck2.get(i));
					deck2.remove(i);
				}
				System.exit(0);
			}
		}
		
		// checks which card is bigger and who wins the round
		if (p1Card.getCard() > p2Card.getCard()) {
			// shows deck size before cards are switched
			System.out.println("Player 1 wins the round \nPlayer 1 deck size: " + deck1.size());
			System.out.println("Player 2 deck size: " + deck2.size());
			// switches cards based on the winner
			deck1.add(deck1.get(0));
			deck1.remove(1);
			deck1.add(deck2.get(0));
			deck2.remove(0);
			// shows deck size after the switch
			System.out.println("Player 1 deck size: " + deck1.size());
			System.out.println("Player 2 deck size: " + deck2.size());
		}
		else if (p2Card.getCard() > p1Card.getCard()) {
			System.out.println("Player 2 wins the round \nPlayer 2 deck size: " + deck2.size());
			System.out.println("Player 1 deck size: " + deck1.size());
			deck2.add(deck2.get(0));
			deck2.remove(0);
			deck2.add(deck1.get(0));
			deck1.remove(0);
			System.out.println("Player 1 deck size: " + deck1.size());
			System.out.println("Player 2 deck size: " + deck2.size());
		}
		System.out.println();
	  } 
	
	// method to check played cards
	public static boolean cardMatch(Card c1, Card c2) {
		if(c1.getCard() == c2.getCard()) {
			return true;
		}
		return false;
	}
	
	public static void war(List<Card> d1, List<Card> d2, int warIndex) {
		// assigning the war cards and printing for the players to see the results
		Card p1 = d1.get(warIndex);
		Card p2 = d2.get(warIndex);
		System.out.println("Player 1 war card: " + p1.toString());
		System.out.println("Player 2 war card: " + p2.toString());
		
		// recursive method in case the war cards match
		// checks through the sizes of the decks and if each deck has enough cards
		if(cardMatch(p1, p2)) {
			System.out.println("Time for war!");
			if(d1.size() > warIndex + 4 && d2.size() > warIndex + 4) {
				war(d1, d2, warIndex + 4);
			}
			else if(d1.size() <= warIndex + 4) {
				System.out.println("\nOh no! Player 1 didn't have enough cards to go to war. \nPlayer 1 lost:( \nCongrats Player 2, you won!");
				for(int i = 0; i < d1.size(); i++) {
					d2.add(d1.get(i));
					d1.remove(i);
				}
				System.out.println("Player 1 deck size: " + d1.size()); //added for grading
				System.out.println("Player 2 deck size: " + d2.size());//added for grading
				System.exit(0);
			}
			else if(d2.size() <= warIndex + 4) {
				System.out.println("\nOh no! Player 2 didn't have enough cards to go to war. \nPlayer 2 lost:( \nCongrats Player 1, you won!");
				for(int i = 0; i < d2.size(); i++) {
					d1.add(d2.get(i));
					d2.remove(i);
				}
				System.out.println("Player 1 deck size: " + d1.size());//added for grading
				System.out.println("Player 2 deck size: " + d2.size());//added for grading
				System.exit(0);
			}
		}
		
		// checks the war card values to find the winner of the war
		// adds and removes the cards into the proper decks after the round
		else if (p1.getCard() > p2.getCard()) {
			System.out.println("Player 1 wins the round");
			if(d2.size() >= 4) {
				for(int i = warIndex; i >= 0; i--) {
					d1.add(d1.get(i));
					d1.remove(i);
					d1.add(d2.get(i));
					d2.remove(i);
				}
			}
			else {
				for(int i = d2.size() - 1; i >= 0; i--) {
					d1.add(d1.get(i));
					d1.remove(i);
					d1.add(d2.get(i));
					d2.remove(i);
				}
			}
		}
		else if (p2.getCard() > p1.getCard()) {
			System.out.println("Player 2 wins the round");
			if(d2.size() >= 4) {
				for(int i = warIndex; i >= 0; i--) {
					d2.add(d2.get(i));
					d2.remove(i);
					d2.add(d1.get(i));
					d1.remove(i);
				}
			}
			else {
				for(int i = d1.size() - 1; i >= 0; i--) {
					d2.add(d2.get(i));
					d2.remove(i);
					d2.add(d1.get(i));
					d1.remove(i);
				}
			}
		}
		System.out.println("Player 1 deck size: " + d1.size());//added for grading
		System.out.println("Player 2 deck size: " + d2.size());//added for grading
	}
}
