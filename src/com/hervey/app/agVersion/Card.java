package com.hervey.app.agVersion;

public class Card {

	  private String suit;
	  private String type;
	  private int abs_rank;
	  private int value;

	  // Constructor, directly assigns the sign and suit, and must 
	  // initialize the other two instance variables.
	  public Card(String s, String k) {

	    suit = s.toLowerCase();
	    type = k.toLowerCase();

	    // Helps compute the value and rank of the card.
	    if (type.equals("ace")) 
	      abs_rank = 14;
	    else if (type.equals("king"))
	      abs_rank = 13;
	    else if (type.equals("queen"))
	      abs_rank = 12;
	    else if (type.equals("jack"))
	      abs_rank = 11;
	    else if (type.equals("ten"))
	      abs_rank = 10;
	    else if (type.equals("nine"))
	      abs_rank = 9;
	    else if (type.equals("eight"))
	      abs_rank = 8;
	    else if (type.equals("seven"))
	      abs_rank = 7;
	    else if (type.equals("six"))
	      abs_rank = 6;
	    else if (type.equals("five"))
	      abs_rank = 5;
	    else if (type.equals("four"))
	      abs_rank = 4;
	    else if (type.equals("three"))
	      abs_rank = 3;
	    else
	      abs_rank = 2;

	    
	  }

	  public Card(char charAt, int j) {
		this.suit=Character.toString(charAt);
		this.type=this.suit;
		this.value=j;
		this.abs_rank=j;
	}

	// Accessor methods.
	  public int getvalue() {
	    return value;
	  }

	  public String getsuit() {
	    return suit;
	  }

	  public String gettype() {
	    return type;
	  }

	  public int getrank() {
	    return abs_rank;
	  }

	  // Compares two playing cards. Returns a positive number if the first
	  // card is greater than the second, 0 if they are equal, and negative
	  // if the first card is less than the second card.
	  public int compareTo(Card other) {
	    return abs_rank - other.abs_rank;
	  }

	  public String toString() {
	    return (this.abs_rank+" of "+suit);
	  }

	public boolean equalsForWar(Card c2) {
		return this.abs_rank==c2.abs_rank;

	}

	public boolean beats(Card c2extra) {
		return this.abs_rank > c2extra.abs_rank;
		
	}

	}