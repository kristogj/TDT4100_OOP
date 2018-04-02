package inheritance;



public class Card implements Comparable<Card>{
	
	public static String validSuit = "SHDC";
	
	private char suit;
	private int face;
	
	public Card(char suit, int face) {
		if(validSuit.indexOf(suit) == -1 || face < 1 || face > 13) {
			throw new IllegalArgumentException("Unvalid d");
		}
		this.suit = suit;
		this.face = face;
	}
	
	public char getSuit() {
		return this.suit;
	}
	
	public int getFace() {
		return this.face;
	}
	
	public void setFace(int face) {
		this.face = face;
	}
	
	@Override
	public String toString() {
		return getSuit() + "" + getFace();
	}
	
	@Override
	public int compareTo(Card card) {
		if(validSuit.indexOf(this.suit) == validSuit.indexOf(card.getSuit())) {
			return this.face - card.getFace();
		}
		else {
			return validSuit.indexOf(card.getSuit()) - validSuit.indexOf(this.suit);
		}
	}
	
	public static void main(String[] args) {
		CardDeck deck = new CardDeck(2);
		for (int x = 0 ; x < 20 ; x++) {
			deck.shufflePerfectly();
		}
		System.out.println(deck);
		java.util.Collections.sort(deck.getDeck());
		System.out.println(deck);
	}
	

	
}
