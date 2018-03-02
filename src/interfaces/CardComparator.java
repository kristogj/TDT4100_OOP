package interfaces;

import java.util.Comparator;


public class CardComparator implements Comparator<Card> {
	
	private boolean essBest;
	
	private StringBuilder trumfOrder = new StringBuilder("SHDC");
	
	public CardComparator(boolean essBest,char trumf) {
		this.essBest = essBest;
		if (trumf != ' ') {
			trumfOrder.deleteCharAt(trumfOrder.indexOf(Character.toString(trumf)));
			trumfOrder.insert(0, trumf);
		}
	}
	
	//Ekstraoppgave; bestem trumfmonster selv
	public CardComparator(boolean essBest, String trumfOrder) {
		this.essBest = essBest;
		this.trumfOrder = new StringBuilder(trumfOrder);
	}
	
	@Override
	public int compare(Card c1, Card c2) {
		String rate = trumfOrder.toString();
		if(rate.indexOf(c1.getSuit()) == rate.indexOf(c2.getSuit())) {
			int c1Face = essBest && c1.getFace() == 1 ? 14:c1.getFace();
			int c2Face = essBest && c2.getFace() == 1 ? 14:c2.getFace();
			return c1Face - c2Face;
		}
		else {
			return rate.indexOf(c2.getSuit()) - rate.indexOf(c1.getSuit());
		}
	}
	

}
