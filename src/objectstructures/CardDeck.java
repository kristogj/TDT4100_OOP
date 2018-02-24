package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	
	private ArrayList<Card> deck;
	
	
	public CardDeck(int n) {
		deck = new ArrayList<Card>();
		int index = 0;
		for(int x = 1; x <= 4*n ; x++) {
			Card c = new Card(Card.validSuit.charAt(index), x % n == 0 ? n : x % n);
			deck.add(c);
			if(x % n == 0) {
				index++;
			}
		}
	}
	
	public int getCardCount() {
		return deck.size();
	}
	
	public Card getCard(int n) {
		if(n < 0 || n >= deck.size()) {
			throw new IllegalArgumentException();
		}
		return deck.get(n);
	}
	
	public void shufflePerfectly() {
		List<Card> top = deck.subList(0, deck.size()/2);
		List<Card> bottom = deck.subList(deck.size()/2,deck.size());
		ArrayList<Card> shuffleDeck = new ArrayList<Card>();
		for(int x = 0; x < top.size(); x++) {
			shuffleDeck.add(top.get(x));
			shuffleDeck.add(bottom.get(x));
		}
		this.deck = shuffleDeck;
	}
	
	public void deal(CardHand hand, int n) {
		for (int x = 0 ; x < n; x++) {
			hand.addCard(this.deck.remove(this.deck.size() - 1 ));
		}
	}
	
	public void printDeck() {
		for(Card card : this.deck) {
			System.out.println(card);
		}
	}
	
	public static void main(String[] args) {
		CardDeck d = new CardDeck(4);
		d.printDeck();
	}

}
