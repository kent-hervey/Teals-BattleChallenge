package com.hervey.app.iySubmission;

/*
 * 	Isaac J Young	 
 * 	3 June 2021
 * 	War Card Game
 * This program will run 1 game of war with ArrayLists that contain cards
 */

import java.util.ArrayList; 	//import ArrayList 
import java.util.Random;    	//import Random
import java.util.List;      	//import List
import java.util.Collections;   //import Collections
 
public class IYWar {
    public static void main(String[] args) {
    	
    	List<Card> cardDeck = new ArrayList<Card>(); //create an ArrayList "cardDeck"
    	
    	for(int x=0; x<4; x++){      	//0-3 for suit (4 suits)
        	for(int y=2; y<15; y++){ 	//2-14 for rank (13 ranks)
            	cardDeck.add(new Card(x,y)); //create new card and add into the deck
        	} //end rank for
    	}//end suit for
    	
    	Collections.shuffle(cardDeck, new Random()); //shuffle the deck randomly
    	
    	introMessage();
    	
    	playGame(cardDeck);
    }//end main method
    
    public static void playGame(List<Card> cardDeck){
    	List<Card> player1Deck = new ArrayList<Card>();
    	List<Card> player2Deck = new ArrayList<Card>();
    	//Declares 2 players' decks
    	
    	for(int i = 0; i < (cardDeck.size() / 2); i++) {
    		player1Deck.add(cardDeck.get(i));
    	}
    	for(int i = (cardDeck.size() / 2); i < cardDeck.size(); i++) {
    		player2Deck.add(cardDeck.get(i));
    	}
    	//Splits deck between 2 players
    	
    	Collections.shuffle(player1Deck, new Random());
    	Collections.shuffle(player2Deck, new Random());
    	//Shuffle each deck to avoid infinite loop
    	
    	while((player1Deck.size() > 0) && (player2Deck.size() > 0)) {
    		System.out.println("1 Deck: " +player1Deck.size());
    		System.out.println("2 Deck: " + player2Deck.size());
    		System.out.println("Player 1 plays " + player1Deck.get(0).toString());
    		System.out.println("Player 2 plays " + player2Deck.get(0).toString());
    		//play cards
    		
    		if(player1Deck.get(0).getCard() > player2Deck.get(0).getCard()) {
    			System.out.println("Player 1 wins the round");
    			
    			player1Deck.add(player1Deck.get(0));
    			player1Deck.add(player2Deck.get(0));
    			
    			player1Deck.remove(0);
    			player2Deck.remove(0);
    			//player1 win
    		}else if(player2Deck.get(0).getCard() > player1Deck.get(0).getCard()) {
    			System.out.println("Player 2 wins the round");
    			
    			player2Deck.add(player1Deck.get(0));
    			player2Deck.add(player2Deck.get(0));
    			
    			player1Deck.remove(0);
    			player2Deck.remove(0);
    			//player2 win
    		}else {//war
    			System.out.println("Time for war!");
    			
    			int n = 0;
    			int warCard = 4;
    			
    			while(n < 9) {   //max amount of times to run war
    					
    				if(player1Deck.size() <= (((n)*3)-1)+warCard) {
    					if(player2Deck.size() <= (((n)*3)-1)+warCard) {
    						System.out.println("Neither player has enough cards");
    						
    						for(int i = player1Deck.size()-1; i >= 0; i--) {
    							player1Deck.remove(i);
    						}
    						for(int i = player2Deck.size()-1; i >= 0; i--) {
    							player2Deck.remove(i);
    						}
    						//removes the remaining cards in each deck
    						
    						break;
    					}
    					System.out.println("Player 1 doesn't have enough cards for war, and forfeits");
    					
    					for(int i = player1Deck.size()-1; i >= 0; i--) {
    						player2Deck.add(player1Deck.get(i));
    						player1Deck.remove(i);
    						//adds player 1 cards to player 2 deck
    					}
    					for(int i = 0; i <= (((n)*3)-1)+warCard; i++) {
    						player2Deck.add(player2Deck.get(0));
    						player2Deck.remove(0);
    						//moves player 2 deck cards to back of deck
    					}
    					n=9;//ends war loop
    					//player 1 doesn't have enough cards
    				}else if(player2Deck.size() <= (((n)*3)-1)+warCard) {
    					System.out.println("Player 2 doesn't have enough cards for war, and forfeits");
    					
    					for(int i = player2Deck.size()-1; i >= 0; i--) {
    						player1Deck.add(player2Deck.get(i));
    						player2Deck.remove(i);
    						//adds player 2 cards to player 1 deck
    					}
    					for(int i = 0; i <= (((n)*3)-1)+warCard; i++) {
    						player1Deck.add(player1Deck.get(0));
    						player1Deck.remove(0);
    						//moves player 1 cards to back of deck
    					}
    					n=9;//ends war loop
    					//player 2 doesn't have enough cards
    				}else {  //both players have enough cards to have a war
    						
    					if(player1Deck.get((((n)*3)-1)+warCard).getCard() > player2Deck.get((((n)*3)-1)+warCard).getCard()) {
        					System.out.println("Player 1 wins the war");
        					
        					for(int i = 0; i <= (((n)*3)-1)+warCard; i++) {
        						player1Deck.add(player1Deck.get(0));
        		    			player1Deck.add(player2Deck.get(0));
        		    			
        		    			player1Deck.remove(0);
        		    			player2Deck.remove(0);
        					}
        					n=9;//ends war loop
        					//player1 win
        				}else if(player2Deck.get((((n)*3)-1)+warCard).getCard() > player1Deck.get((((n)*3)-1)+warCard).getCard()) {
        					System.out.println("Player 2 wins the war");
        					
        					for(int i = 0; i <= (((n)*3)-1)+warCard; i++) {
        						player2Deck.add(player2Deck.get(0));
        		    			player2Deck.add(player1Deck.get(0));
        		    			
        		    			player2Deck.remove(0);
        		    			player1Deck.remove(0);
        					}
        					n=9;//ends war loop
        					//player2 win
        				}else {
        					n++;
        				}//plays another war if players have same 3rd card
    				}
    			}
    			
    			
    			
    		}
    		//war
    	}
    	
    	if(player1Deck.size() > 0 && player2Deck.size() == 0) {
    		System.out.println("\n\n\nP L A Y E R   O N E   W I N S ! ! !");
    	}else if(player2Deck.size() > 0 && player1Deck.size() == 0) {
    		System.out.println("\n\n\nP L A Y E R   T W O   W I N S ! ! !");
    	}else if(player1Deck.size() == 0 && player2Deck.size() == 0) {
    		System.out.println("\n\n\nT H E   G A M E   E N D S   I N   A   D R A W ! ! !");
    	}
    }
    
    public static void introMessage() {
    	System.out.println("W E L C O M E   T O   W A R !");
    	System.out.println("\n\n\nWar is a card game for two players. \nA standard deck of 52 cards is dealt so that both players have 26 cards. \nDuring each round of play (or \"battle\"), both players play a \ncard from the top of their hand face up. \nThe player who plays the card of the higher rank wins both cards \nand places them at the bottom of his stack of cards. \nIf both cards played are of the same rank, then both players play three \nadditional cards face down and then one more card face up (this is called a \"war\"). \nThe player who wins the war by playing the higher face up card \nwins all ten cards. If the ranks are still the same, additional wars are \nplayed until one player wins the turn. \n\nIf either player runs out of cards to play, that player loses the game.\n\n\nL E T   T H E   W A R   B E G I N !");
    	System.out.println();
    }
    
}//end IYWar class