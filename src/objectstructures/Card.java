package objectstructures;

public class Card {
	
	static String validSuit = "SHDC";
	
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
	
	@Override
	public String toString() {
		return getSuit() + "" + getFace();
	}
	

	
}
