import javax.swing.JOptionPane;
public class Hand {
	// accept two cards...
	// also should be able to tell you the amount you have if you never played poker...
	public final Card card1;
	public final Card card2;
	// I must learn throughly.
	// I should replace cards with vectors to be more efficient 
	
	public Hand (Card x, Card y ){
		card1 = x;
		card2 = y;
	}
	
	public Card getCard1(){
		return card1;
	}
	
	public Card getCard2(){
		return card2;
	}
	
	public int amount(){
		int sum = 0;
		// Works most of the time except for ace jack queen king...
		
		int firstCard = card1.getValue();
		if ( firstCard == 11 || firstCard ==12 || firstCard == 13 )
			firstCard = 10;
		if(firstCard == 1 ){
			firstCard = 11;
		}
		
		int secondCard = card2.getValue();
		if ( secondCard  == 11 || secondCard == 12 || secondCard  == 13 )
			secondCard  = 10;
		if(secondCard  == 1 ){
			secondCard  = 11;
		}
		
		sum = firstCard + secondCard;
		
		
		return sum;
		
	}
	
	public String showHand(){
		return("Your Hand Is " + card1 + " and " + card2);
	}
	
	public void showSum (){
		JOptionPane.showMessageDialog(null, "Your total amount is " + amount());
	}

}
