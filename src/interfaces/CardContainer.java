package interfaces;


public interface CardContainer extends Iterable<Card>{
	
	
	//Siden den extends Itarable krever vi også at klassen som implementerer grensesnittet har metoden iterator();
	
	public int getCardCount();
	public Card getCard(int i);

}
