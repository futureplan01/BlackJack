import javax.swing.JOptionPane;

public class BlackJack {
	public static void main (String [] args){
		Deck myDeck = new Deck();
		myDeck.shuffle();
		
		int count = 0;
		
		Hand myHand = new Hand(myDeck.deck[count],myDeck.deck[++count]);
		DealerHand Dealer = new DealerHand(myDeck.deck[++count],myDeck.deck[++count]);
		
		JOptionPane.showMessageDialog(null, Dealer.ShowDealerHand() + " "
				+ myHand.showHand());
		
		//////////Real game comes here
		if(myHand.amount() < 21){
			String answer = JOptionPane.showInputDialog(null, "Would you like to Hit or Stay?"
					+ " type Yes or No");
			
			if(answer.equalsIgnoreCase("No") || answer.equalsIgnoreCase("Yes")){
				if (answer.equalsIgnoreCase("No")){
					myHand.showSum();
					// User Action is Completed... Compare with dealer then figure out who wins..
					
					if(Dealer.Sum() < myHand.amount()){
						DealerNewHand newHand = new DealerNewHand (myDeck.deck, Dealer, count, myHand.amount());
						newHand.AddCard();
					}
					else{
						JOptionPane.showMessageDialog(null, Dealer.showFullHand() + ".Dealer Wins");
					}
				}
				else{
					HitHand newCards = new HitHand(myDeck.deck, myHand, count);
					newCards.HitMe();
					count++;
					newCards.showNewCards();
					boolean keepHitting = true;
					while(keepHitting){
						answer = JOptionPane.showInputDialog(null, "You now have " + newCards.Sum() 
						+ ". Would you" + " like to hit again?");
						
						if(answer.equalsIgnoreCase("No") || answer.equalsIgnoreCase("Yes")){
							if (answer.equalsIgnoreCase("No")){
								newCards.ShowSum();
								keepHitting = false;
								
								if(Dealer.Sum() < newCards.Sum()){
									DealerNewHand newHand = new DealerNewHand (myDeck.deck, Dealer, count, newCards.Sum());
									// This ends the game..
									newHand.AddCard();
								}
								else{
									JOptionPane.showMessageDialog(null, Dealer.showFullHand() + ".Dealer Wins");
								}
							}
							else{
								newCards.HitMe();
								count++;
								newCards.showNewCards();
							}
						}
					}
				}
			}
			else{
				boolean wantToHit = true;
				
				// Loops Until player decides to hit or not...
				while(wantToHit){
					answer  = JOptionPane.showInputDialog("Invalid statement Please try again, Press "
							+ "Yes or No");
					
					if(answer.equalsIgnoreCase("No") || answer.equalsIgnoreCase("Yes")){
						wantToHit = false;
						
						if(answer.equalsIgnoreCase("No")){
							myHand.showSum();
							if(Dealer.Sum() < myHand.amount()){
								DealerNewHand newHand = new DealerNewHand (myDeck.deck, Dealer, count, myHand.amount());
								newHand.AddCard();
							}
							else{
								JOptionPane.showMessageDialog(null, Dealer.showFullHand() + ".Dealer Wins");
							}
							System.exit(0);
						}
						else{
							HitHand newCards = new HitHand(myDeck.deck, myHand, count);
							newCards.HitMe();
							// everytime you hit got to the next card in the deck
							count++;
							newCards.showNewCards();
							boolean keepHitting = true;
								while(keepHitting && newCards.Sum() < 21){
									answer = JOptionPane.showInputDialog(null, "You now have " + newCards.Sum() 
									+ ". Would you" + " like to hit again? Press Yes or No");
									
									if(answer.equalsIgnoreCase("No") || answer.equalsIgnoreCase("Yes")){
										if (answer.equalsIgnoreCase("No")){
											newCards.ShowSum();
											keepHitting = false;
											if(Dealer.Sum() < newCards.Sum()){
												DealerNewHand newHand = new DealerNewHand (myDeck.deck, Dealer, count, newCards.Sum());
												newHand.AddCard();
											}
											else{
												JOptionPane.showMessageDialog(null, Dealer.showFullHand() + ".Dealer Wins");
											}
										}
										else{
											newCards.HitMe();
											count++;
											newCards.showNewCards();
										}
									}
									
								}
								
						}
					}
					

				}
				// User action is done... if He didn't hit...
				// Dealer plays and then compare... 
				// Winner gets chosen as the chooser for the chosen one...
			}
		}
		else
			JOptionPane.showMessageDialog(null,"You Got BlackJack Congrats... it's less then 5 percent ");
			System.exit(0);
	}
}
