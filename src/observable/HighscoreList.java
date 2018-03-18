package observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Laveste verdi er best
public class HighscoreList {
	
	private int maxSize;
	private List<Integer> results;
	private Set<HighscoreListListener> listeners;
	
	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
		this.results = new ArrayList<Integer>();
		this.listeners = new HashSet<HighscoreListListener>();
	}
	
	public int size() {
		return results.size();
	}
	
	public int getElement(int index) {
		return this.results.get(index);
	}
	
	//Skal oppdate results, men også informere alle lytterene om at denne endringen skjedde
	public void addResult(int score) {
		boolean check = false;
		for(int x = 0 ; x < this.results.size() ; x++) {
			if(score < this.results.get(x)) {
				results.add(x,score);
				fire(x);
				check = true;
				break;
			}
		}
		if(!check) {
			this.results.add(score);
		}
		if(size() > this.maxSize) {
			this.results.remove(maxSize);
		}
	}
	
	private void fire(int pos) {
		this.listeners.stream().forEach(lytter -> lytter.listChanged(this, pos));
	}
	
	public void addHighscoreListListener(HighscoreListListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeHighscoreListListener(HighscoreListListener listener) {
		this.listeners.remove(listener);
	}
	
	@Override
	public String toString() {
		String str = "---------------\n";
		int pos = 0;
		for(int res : this.results) {
			str += "Pos" + pos + ": " + res + "\n";
			pos++;
		}
		str += "---------------\n";
		return str;
	}
	
	
	
}
