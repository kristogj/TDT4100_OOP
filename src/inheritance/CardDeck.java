package inheritance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CardDeck extends CardContainerImpl{
	
	public CardDeck(int n) {
		super(52);
		int index = 0;
		for(int x = 1; x <= 4*n ; x++) {
			Card c = new Card(Card.validSuit.charAt(index), x % n == 0 ? n : x % n);
			cards.add(c);
			if(x % n == 0) {
				index++;
			}
		}
	}
	
	
	public void shufflePerfectly() {
		List<Card> top = cards.subList(0, cards.size()/2);
		List<Card> bottom = cards.subList(cards.size()/2,cards.size());
		ArrayList<Card> shuffleDeck = new ArrayList<Card>();
		for(int x = 0; x < top.size(); x++) {
			shuffleDeck.add(top.get(x));
			shuffleDeck.add(bottom.get(x));
		}
		this.cards = shuffleDeck;
	}
	
	public void deal(CardHand hand, int n) {
		for (int x = 0 ; x < n; x++) {
			hand.addCard(cards.remove(this.cards.size() - 1 ));
		}
	}
	
	public void printDeck() {
		for(Card card : cards) {
			System.out.println(card);
		}
	}
	
	public List<Card> getDeck() {
		return cards;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cards.toString();
	}
	
	//Predicate oppgave
	public boolean hasCard(Predicate<Card> predicate) {
		return cards.stream().anyMatch(predicate);
	}
	
	public int getCardCount(Predicate<Card> predicate) {
		return cards.stream().filter(predicate).collect(Collectors.toList()).size();
	}
	
	public List<Card> getCards(Predicate<Card> predicate){
		return cards.stream().filter(predicate).collect(Collectors.toList());
	}

	

}
