package inheritance;


import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{
	
	
	private CardContainer obj;
	private int i;
	
	public CardContainerIterator(CardContainer obj) {
		this.obj = obj;
		this.i = 0;
	}

	@Override
	public boolean hasNext() {
		return this.i < this.obj.getCardCount();
	}

	@Override
	public Card next() {
		Card card = obj.getCard(this.i);
		this.i++;
		return card;
	}

}
