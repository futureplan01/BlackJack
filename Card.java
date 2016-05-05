public class Card{
	// first we must make the cards for Ace, King, Queen, Jack
	public static final int KING = 13;
	public static final int QUEEN = 12;
	public static final int ACE = 1;
	public static final int JACK = 11;
	
	// the rest of the numbers are 2 - 10 which can be represent as there orginal values
	
	//Now we must make the suits....
	//suits will be made by modulus four...
	
	public final static int SPADES = 0;
	public static final int HEARTS = 1;
	public static final int DIAMONDS = 2;
	public static final int CLOVERS = 3;
	
	private final int suit;
	private final int value;
	
	// default constructor...
	
	public Card ( ){
		value = 0;
		suit = 0;
	}
	
	public Card( int valueX, int suitX){
		if( valueX > 13 || valueX < 1)
			throw new IllegalArgumentException("Card Not Acceptable");
		if(suitX > 3 || suitX < 0)
			throw new IllegalArgumentException("Suit Not Acceptable");
		value = valueX;
		suit = suitX;
	}
	
	public int getSuit(){
		return suit;
		
	}
	
	public int getValue(){
		return value;
	}
	
    // Right now we ahve created the card class...
	// however we want to modify it so that It is more user friendly...
	// if the user ask us for the suit we want to give them spades and hearts instead of 0's and 1's
	// We are going to make a getSuitToString method...
	
	public String getSuitToString(){
		switch (suit){
			case 0: return "Spades";
			case 1: return "Hearts";
			case 2: return "Diamonds";
			default: return "Clovers";
		}
		
	}
	
	public String getValueToString(){
		switch(value){
		case 1: return "Ace";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "Jack";
		case 12: return "Queen";
		default: return "King";
		}
	}
	// Now if I want the properties of the card...which is the suit and value I have to add another method...
	
	public String toString(){
		return getValueToString() + " of " + getSuitToString();
	}
	
	
	
}
