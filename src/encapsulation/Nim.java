package encapsulation;


import java.util.ArrayList;
import java.util.Arrays;

public class Nim {
	
	
	private ArrayList<Integer> piles;
	
	public Nim(int pileSize) {
		piles = new ArrayList<Integer>(Arrays.asList(pileSize,pileSize,pileSize));
	}
	
	public Nim() {
		piles = new ArrayList<Integer>(Arrays.asList(10,10,10));
	}
	
	public void removePieces(int number, int targetPile) {
		if(isGameOver()) {
			throw new IllegalStateException();
		}
		else if(!isValidMove(number,targetPile)) {
			throw new IllegalArgumentException("Unvalid");
		}
	
		piles.set(targetPile, piles.get(targetPile) - number);
	}
	
	public boolean isValidMove(int number, int targetPile) {
		if(number < 1 ||  number > piles.get(targetPile) || targetPile < 0 || targetPile >= piles.size()) {
			return false;
		}
		return true;
	}
	
	public boolean isGameOver() {
		return piles.contains(0);
	}
	
	public int getPile(int targetPile) {
		return piles.get(targetPile);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pile 0: " + piles.get(0) + "\n" + "Pile 1: " + piles.get(1) + "\n" + "Pile 2: " + piles.get(2) + "\n";
	}
	
	public static void main(String[] args) {
		Nim nim = new Nim();
		System.out.println(nim);
		nim.removePieces(5, 0);
		System.out.println(nim);
		nim.removePieces(5, 0);
		System.out.println(nim);
		nim.removePieces(1, 0);
		
	}

	
	
	
	
	
}
