package inheritance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerImpl implements CardContainer {
	
	protected List<Card> cards;
	private int maxCardCount;
	
	public CardContainerImpl(int maxCardCount) {
		cards = new ArrayList<Card>();
		this.maxCardCount = maxCardCount;
	}

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}

	@Override
	public int getCardCount() {
		return cards.size();
	}

	@Override
	public Card getCard(int i) {
		if(i < 0 || i >= cards.size()) {
			throw new IllegalArgumentException();
		}
		return cards.get(i);
	}
	
	public int getMaxCardCount() {
		return maxCardCount;
	}

}
