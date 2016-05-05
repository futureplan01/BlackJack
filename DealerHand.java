import javax.swing.JOptionPane;

public class DealerHand {
	public final Card card1;
	public final Card card2;

	
	DealerHand( Card x, Card y){
		card1 = x;
		card2 = y;
	}
	
	public Card getCard1(){
		return card1;
	}
	public Card getCard2(){
		return card2;
	}
	
	public String ShowDealerHand(){
		return("The Dealer hand shows " + card1 + " only.");
	}
	
	public String showFullHand(){
		return ("The Dealer hand is " + card1 + " and "+ card2);
	}
	
	public int ConvertCards (Card x){
		int firstCard = x.getValue();
		if ( firstCard == 11 || firstCard ==12 || firstCard == 13 )
			firstCard = 10;
		if(firstCard == 1 ){
			firstCard = 11;
		}
		
		return firstCard;
	}
	
	public int Sum(){
		int sum  = 0;
		int value1 = ConvertCards(card1);
		int value2 = ConvertCards(card2);
		sum = value1 + value2;
		return sum;
	}
	
	public boolean shouldHit(){
		if(Sum () < 17)
			return true;
		
		else
			return false;
	}
}
