import javax.swing.JOptionPane;

public class HitHand {
	
	// I can ask if they want to hit again from inside the HitHandclass.
	// I can transport the deck into the hitHandclass.... To determine the outcome...
	public static int count;
	public final Card [] usedDeck;
	public final Card card1;
	public final Card card2;
	public static Card [] hitCards = new Card [5];
	public static int timesHit = 0;
	
	public HitHand(Card [ ] oldCards, Hand oldHands, int counter){
		count = counter;
		usedDeck = new Card [52];
		for ( int i = 0; i < 52; i++){
			usedDeck[i] = oldCards [i];
		}
		card1 = oldHands.getCard1();
		card2 = oldHands.getCard2();
	}

	public Card HitMe (){
		count++;
		hitCards [timesHit] = usedDeck[count];
		timesHit++;
		return hitCards[timesHit - 1];
		// How can I store all the new cards... 
		// If I use an array then it what would be the length ...
		// I could make a maximum length but seems inefficient 
	}
	 
	public int Sum(){
		int sum = 0;
		sum += card1.getValue();
		sum += card2.getValue();
		

		for ( int i = 0; i < timesHit; i++){
			
			int firstCard = hitCards[i].getValue();
			if ( firstCard == 11 || firstCard ==12 || firstCard == 13 )
				firstCard = 10;
			if(firstCard == 1 ){
				firstCard = 11;
			}

			
			sum += firstCard;
		}
		
		return sum;
	}
	
	public void ShowSum(){
		JOptionPane.showMessageDialog(null, "Your total sum is: " + Sum());
	}
	
	public void showNewCards(){
		
		String amountOfHitCards = "";
		for ( int i = 0; i < timesHit; i++){
			amountOfHitCards += " and ";
			amountOfHitCards += hitCards[i];
		}
		
		if( Sum() > 21){
			JOptionPane.showMessageDialog(null, "Your Cards are "+ card1 + " and " + card2 +
					 amountOfHitCards + ". You busted, please try again" );
			System.exit(0);
		}
		
		JOptionPane.showMessageDialog(null, "Your Cards Are Now "
				+ card1 + " and " + card2 + amountOfHitCards );
	}
	
}
