import java.util.Random;
public class Deck {
	// okay the deck class... should store all 52 cards...
	// should have a shuffle method...
	// be able to deal as much cards as neccesary. 
	// keep count of the cards and tell when it's empty...
	// should I be able to shuffle the cards left??? 
	
	
	// Deck must be type Card in order to store all types of Cards ha..ha.. telling lokes to myself sucks...
	public Card[] deck;
	public int cardsLeftInDeck;
	
	
	// Creates an un-shuffled deck of cards...
	public Deck (){
		int count = 0;
		deck = new Card [52];
		for ( int i = 0; i < 4; i++){
			for ( int j = 1; j <= 13; j++){
				Card myCard = new Card(j, i);
				deck[count] = myCard;
				count++;
			}
		}
		cardsLeftInDeck = 52;
	}
	
	// shuffling works by switching cards places...great idea i wish I came up with it

	public void shuffle() {
		for ( int i = deck.length-1; i > 0; i-- ) {
			int rand = (int)(Math.random()*(i+1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
	}
	
	// Okay how do I deal cards...??
	// deal the first card on the array... then use a counter to increment...
	// maybe I should make another class ca
	
	
	
	
	
}

