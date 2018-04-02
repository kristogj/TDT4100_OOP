package inheritance;

public class CardHand extends CardContainerImpl{
	
	public CardHand(int maxCardCount) {
		super(maxCardCount);
	}
	
	public void addCard(Card card) {
		if(this.getCardCount() == this.getMaxCardCount()) {
			throw new IllegalStateException();
		}
		cards.add(card);
	}
	
	public Card play(int i) {
		return cards.remove(i);
	}

	
}
