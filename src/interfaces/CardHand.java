package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardHand implements CardContainer{
	
	private List<Card> hand;
	
	
	public CardHand() {
		this.hand = new ArrayList<Card>();
	}
	
	public int getCardCount() {
		return this.hand.size();
	}
	
	public Card getCard(int i) {
		return this.hand.get(i);
	}
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	public Card play(int i) {
		return this.hand.remove(i);
	}

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
	
	

}
