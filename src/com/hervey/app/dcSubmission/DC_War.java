package com.hervey.app.dcSubmission;

import java.util.ArrayList; 	//import ArrayList 
import java.util.Collections;   //import Collections
import java.util.Random;    	//import Random
import java.util.Scanner;
 
public class DC_War {
    public static void main(String[] args) {
    	System.out.println("Danny's game");
    	ArrayList<Card> cardDeck = new ArrayList<Card>(); //create an ArrayList "cardDeck"
    	
    	for(int x=0; x<4; x++){      	//0-3 for suit (4 suits)
        	for(int y=2; y<15; y++){ 	//2-14 for rank (13 ranks)
            	cardDeck.add(new Card(x,y)); //create new card and add into the deck
        	} //end rank for
    	}//end suit for
    	
    	Collections.shuffle(cardDeck, new Random()); //shuffle the deck randomly
    	
    	ArrayList<Card> pODeck = new ArrayList<Card>();
    	ArrayList<Card> pTDeck = new ArrayList<Card>();
    	for(int i=0; i < 26; i++) {
    		pODeck.add(cardDeck.remove(0));
    		pTDeck.add(cardDeck.remove(0));
    	}
    	Scanner nextTurn = new Scanner(System.in);
    	while(pODeck.size() > 0 && pTDeck.size() > 0) {
    		int isWar = 0;
    		System.out.println("Player One plays: " + pODeck.get(isWar) + "\nPlayer Two plays: " + pTDeck.get(isWar));
    		while (pODeck.get(isWar).getCard() == pTDeck.get(isWar).getCard()) {
    			System.out.println("This means war: both players add three cards to the antie.");
    			isWar +=4;
    			if(pODeck.size() <= isWar && !(pTDeck.size() < pODeck.size()))
    			{
    				System.out.println("Player One does not have enough cards\n__________________________________________");
    				while (pODeck.size() > 0)
    					pODeck.remove(0);
    				break;
    			}
    			else if (pTDeck.size() <= isWar)
    			{
    				System.out.println("Player Two does not have enough cards\n__________________________________________");
    				while (pTDeck.size() > 0)
    					pTDeck.remove(0);
    				break;
    			}
    			System.out.println("Player One plays: " + pODeck.get(isWar) + "\nPlayer Two plays: " + pTDeck.get(isWar));
    		}
    		if(pODeck.size() == 0 || pTDeck.size() == 0)
    		{
    			break;
    		}
    		if(pODeck.get(isWar).getCard() > pTDeck.get(isWar).getCard()) {
    			System.out.println("Player One wins this round!");
    			for (int i = 0; i <= isWar; i++){
    				pODeck.add(pTDeck.remove(0));
    				pODeck.add(pODeck.remove(0));
    			}
    			System.out.println("Player One deck size =" + pODeck.size() + "\nPlayer Two Deck size =" + pTDeck.size() + "\n__________________________________________");
    		}
    		else {
    			System.out.println("Player Two wins this round!");
    			for (int i = 0; i <= isWar; i++) {
    				pTDeck.add(pODeck.remove(0));
    				pTDeck.add(pTDeck.remove(0));
    			}
    			System.out.println("Player One deck size =" + pODeck.size() + "\nPlayer Two Deck size =" + pTDeck.size() + "\n__________________________________________");
    		}
    		System.out.print("Press enter to continue:\n\n\n");
    		String x = nextTurn.nextLine();
    	}
    	System.out.println("Player " + ((pODeck.size() > pTDeck.size()) ? "One" : "Two") + " wins the game!");
    }
}