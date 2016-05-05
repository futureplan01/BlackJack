import javax.swing.JOptionPane;

public class DealerNewHand {
	public static int count;
	public final int playerHand;
	public final Card [] usedDeck;
	public final Card card1;
	public final Card card2;
	public static Card [] hitCards = new Card [5];
	public static int timesHit = 0;
	
	public DealerNewHand(Card [ ] oldDeck, DealerHand oldHand, int counter, int playerAmount){
		playerHand = playerAmount;
		count = counter;
		usedDeck = new Card [52];
		for ( int i = 0; i < 52; i++){
			usedDeck[i] = oldDeck [i];
		}
		card1 = oldHand.getCard1();
		card2 = oldHand.getCard2();
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
	
	public void AddCard (){
		while ( Sum () < 17 && Sum () < playerHand) {
			HitMe();
		}
		
		
		String amountOfHitCards = "";
		for ( int i = 0; i < timesHit; i++){
			amountOfHitCards += " and ";
			amountOfHitCards += hitCards[i];
		}
		
		if(Sum () < 21 && Sum () > playerHand){
			JOptionPane.showMessageDialog(null, "Dealer hand is " + card1 + " and "
					+ card2 + amountOfHitCards + ". Too Bad Dealer Wins.. Try again..");
		}
		else if(Sum () < 21 && Sum () < playerHand){
			JOptionPane.showMessageDialog(null, "Dealer hand is " + card1 + " and "
					+ card2 + amountOfHitCards + ". Guess what, you won");
		}
		else if(Sum () >21 ){
			JOptionPane.showMessageDialog(null, "Dealer cards were " + card1 + " and " + card2 + amountOfHitCards 
					+ ".Dealer bust, You won");
		}
	}
	
}
