package observable;

public class ObservableHighscoreList extends ObservableList{
	private int maxSize;
	
	public ObservableHighscoreList(int maxSize) {
		super();
		this.maxSize = maxSize;
	}
	
	public boolean acceptsElement(Object object) {
		return object instanceof Integer;
	}
	
	//Skal oppdate results, men også informere alle lytterene om at denne endringen skjedde
	public void addResult(int score) {
		boolean check = false;
		for(int x = 0 ; x < size() ; x++) {
			if(score < (Integer) super.getElement(x)) {
				super.addElement(x,score);
				fire(x);
				check = true;
				break;
			}
		}
		if(!check) {
			super.addElement(score);
		}
		if(size() > this.maxSize) {
			super.removeElement(maxSize);
		}
	}
	
	private void fire(int pos) {
		listeners.stream().forEach(lytter -> lytter.listChanged(this, pos));
	}
	
}
